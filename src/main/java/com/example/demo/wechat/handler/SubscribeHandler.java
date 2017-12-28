package com.example.demo.wechat.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.WxUserInfo;
import com.example.demo.service.WxUserInfoService;
import com.example.demo.wechat.builder.ImageBuilder;

import java.util.Map;

/**
 * @author minyi
 */
@Component
public class SubscribeHandler extends AbstractHandler {

	@Autowired
	WxUserInfoService wxUserInfoService;
	
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) throws WxErrorException {

        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());

        // 获取微信用户基本信息
        WxMpUser wxMpUser = weixinService.getUserService()
                .userInfo(wxMessage.getFromUser(), null);
        
        WxUserInfo wxUserInfo = new WxUserInfo();
        if (wxMpUser != null && wxMpUser.getOpenId()!=null && wxMpUser.getUnionId()!=null) {
        	wxUserInfo = wxUserInfoService.selectByOpenidAndUnionid(wxMpUser.getOpenId(), wxMpUser.getUnionId());
        	if(wxUserInfo.getId()!=null){
        		this.logger.info("获取用户信息成功，老用户 OPENID ：" + wxMessage.getFromUser());
        	}else{
        		this.logger.info("获取用户信息成功，新关注用户 OPENID ：" + wxMessage.getFromUser());
        		wxUserInfo = ConvertWxMpUserToWxUserInfo(wxMpUser,wxUserInfo);
        		
        		wxUserInfo.setAppid("wx8c9ebf34b648998d");
        		wxUserInfo.setAppname("黄骅港物流");
        		
        		int flag = wxUserInfoService.insert(wxUserInfo);
        		if(flag==1){
        			this.logger.info("保存用户信息成功，新关注用户 OPENID ：" + wxMessage.getFromUser());
        		}else{
        			this.logger.info("保存用户信息失败，新关注用户 OPENID ：" + wxMessage.getFromUser());
        		}
        	}
        }else{
        		this.logger.info("获取用户信息失败，新关注用户 OPENID ：" + wxMessage.getFromUser());
        }

        WxMpXmlOutMessage responseResult = null;
        try {
            responseResult = handleSpecial(wxMessage);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        if (responseResult != null) {
            return responseResult;
        }

        try {
        	return new ImageBuilder().build("https://mmbiz.qlogo.cn/mmbiz_jpg/vI9VeRGmQqCEVfjClv7MCpNflFh2XXoRsq68oWa3lIcn6BADlescIKtC13TiciaEDWFg2Okhw0cBxQODS7iaT92yQ/0?wx_fmt=jpeg", wxMessage, weixinService);
            //return new TextBuilder().build("感谢关注", wxMessage, weixinService);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        return null;
    }

    private WxUserInfo ConvertWxMpUserToWxUserInfo(WxMpUser wxMpUser,WxUserInfo wxUserInfo){
    	if(wxMpUser.getCity()!=null){
    		wxUserInfo.setCity(wxMpUser.getCity());
    	}
        if(wxMpUser.getCountry()!=null){
        	wxUserInfo.setCountry(wxMpUser.getCountry());
    	}
        if(wxMpUser.getGroupId()!=null){
        	wxUserInfo.setGroupid(wxMpUser.getGroupId().toString());
    	}
    	if(wxMpUser.getHeadImgUrl()!=null){
    		wxUserInfo.setHeadimgurl(wxMpUser.getHeadImgUrl());
    	}
    	if(wxMpUser.getLanguage()!=null){
    		wxUserInfo.setLanguage(wxMpUser.getLanguage());
    	}
    	if(wxMpUser.getNickname()!=null){
    		wxUserInfo.setNickname(wxMpUser.getNickname());
    	}
    	if(wxMpUser.getOpenId()!=null){
    		wxUserInfo.setOpenid(wxMpUser.getOpenId());
    	}
    	if(wxMpUser.getProvince()!=null){
    		wxUserInfo.setProvince(wxMpUser.getProvince());
    	}
    	if(wxMpUser.getRemark()!=null){
    		wxUserInfo.setRemark(wxMpUser.getRemark());
    	}
    	if(wxMpUser.getSex()!=null){
    		wxUserInfo.setSex(wxMpUser.getSex());
    	}
//    	if(wxMpUser.getSexId()!=null){
//    		wxUserInfo.setSexId(wxMpUser.getSexId());
//    	}
    	if(wxMpUser.getSubscribe()!=null){
    		if(wxMpUser.getSubscribe()){
    			wxUserInfo.setSubscribe("1");
    		}else{
    			wxUserInfo.setSubscribe("0");
    		}
    	}
    	if(wxMpUser.getSubscribeTime()!=null){
    		wxUserInfo.setSubscribeTime(wxMpUser.getSubscribeTime().toString());
    	}
    	if(wxMpUser.getTagIds()!=null){
    		String arrStr = "";
    		if(wxMpUser.getTagIds().length>0){
    			Long[] arr = wxMpUser.getTagIds();
    			for(int i=1;i<arr.length;i++){
        			if(arr[i]!=null){
        				arrStr = arr[i] + ",";
        			}
        		}
    			arrStr.substring(0, arrStr.length()-1);
    		}
    		wxUserInfo.setTagidList(arrStr);
    	}
    	if(wxMpUser.getUnionId()!=null){
    		wxUserInfo.setUnionid(wxMpUser.getUnionId());
    	}
    	return wxUserInfo;
    }

    /**
     * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
     */
    private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage)
            throws Exception {
        //TODO
        return null;
    }

}
