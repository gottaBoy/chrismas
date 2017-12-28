package com.example.demo.wechat.handler;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.wechat.bean.DriverResponse;
import com.example.demo.wechat.builder.TextBuilder;
import com.example.demo.wechat.config.WechatUrlProperties;
import com.example.demo.wechat.lbs.AddressComponent;
import com.example.demo.wechat.lbs.LBSResponse;
import com.example.demo.wechat.lbs.LBSWechatResult;
import com.example.demo.wechat.lbs.Location;
import com.example.demo.wechat.utils.HttpRequest;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author minyi
 * @see 
 */
@Component
public class LocationHandler extends AbstractHandler {

	@Autowired
    private WechatUrlProperties url_props;
	
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) throws WxErrorException{
    	//上报地理位置事件
        this.logger.info("\n上报地理位置 。。。 ");
        this.logger.info("\n纬度 : " + wxMessage.getLatitude());
        this.logger.info("\n经度 : " + wxMessage.getLongitude());
        this.logger.info("\n精度 : " + String.valueOf(wxMessage.getPrecision()));
        
        //if (wxMessage.getMsgType().equals(WxConsts.XML_MSG_LOCATION)) {
        String openId = null;
        String unionId = null;
    	// 获取微信用户基本信息
        WxMpUser userWxInfo = wxMpService.getUserService().userInfo(wxMessage.getFromUser(), null);
        if (userWxInfo != null) {
            //处理业务逻辑,可以将用户地理位置信息保存到本地数据库，以便以后使用
        	openId = userWxInfo.getOpenId();
        	unionId = userWxInfo.getUnionId();
        	this.logger.debug("openId="+ openId + ";unionId=" + unionId);
        }
        //解析地址可参考： http://blog.csdn.net/wangshengan/article/details/44804547
        //维度 + 经度
        String location = wxMessage.getLatitude() + "," + wxMessage.getLongitude();
//            String key = "NCFBZ-RWCWD-6KG4N-PEG6K-IKHW2-UNBFZ";
//            String url = "http://apis.map.qq.com/ws/geocoder/v1";
        String param = "location="+ location +"&key=" + this.url_props.getLbsKey() + "&get_poi=1";
        
        String result = HttpRequest.sendGet(this.url_props.getLbsUrl(), param);
        LBSResponse obj = JSONObject.parseObject(result, LBSResponse.class);
        LBSWechatResult lBSWechatResult = new LBSWechatResult();
        
        if(obj.getResult()!=null&&obj.getResult().getAddress_component()!=null){
        	AddressComponent addressComponent = obj.getResult().getAddress_component();
        	this.logger.info("address_component==>"+ addressComponent);
        	
        	lBSWechatResult.setUnionId(unionId);
            lBSWechatResult.setAdress(obj.getResult().getAddress());
            Location newlocation = new Location();
            newlocation.setLat(new BigDecimal(wxMessage.getLatitude()));
            newlocation.setLng(new BigDecimal(wxMessage.getLongitude()));
            lBSWechatResult.setLocation(newlocation);
            lBSWechatResult.setAddressComponent(addressComponent);
            
            //String post_url = "http://localhost:8080/cargocn-cloud-server/weChatApp/saveWechatDriverLocation";
            //上传地理位置信息接口,接收处理用户发送的地理位置消息
            String res_result = HttpRequest.sendGet(this.url_props.getLocUrl(), "param=" + JSONObject.toJSONString(lBSWechatResult));        
            DriverResponse res_obj = JSONObject.parseObject(res_result, DriverResponse.class);
            if(res_obj!=null && res_obj.getSuccess()){
            	this.logger.info("save_address_component==>保存地理信息成功");
            }else{
            	this.logger.info("save_address_component==>保存地理信息失败");
            }
        }else{
        	this.logger.info("address_component==>获取失败！");
        }
        return null;
//        try {
//            String content = "感谢反馈，您的的地理位置已收到！";
//            return "success"new TextBuilder().build(content, wxMessage, null);
//        } catch (Exception e) {
//            this.logger.error("位置消息接收处理失败", e);
//            return null;
//        }
    //}  
  }
}
