package com.example.demo.wechat.handler;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage.Item;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.wechat.builder.NewsBuilder;

import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MenuHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

    	
//        String msg = String.format("type:%s, event:%s, key:%s",
//                wxMessage.getMsgType(), wxMessage.getEvent(),
//                wxMessage.getEventKey());
//        if (WxConsts.BUTTON_VIEW.equals(wxMessage.getEvent())) {
//            return null;
//        }
//
//        return WxMpXmlOutMessage.TEXT().content(msg)
//                .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
//                .build();
    	String content = "";
    	if(wxMessage.getEventKey()!=null && wxMessage.getEventKey().equals("Daily_Dynamic")){
    		WxMpXmlOutNewsMessage articles = new WxMpXmlOutNewsMessage();
        	Item item = new Item();
        	item.setDescription("！！！柴油货车不能运煤炭到黄骅港码头啦‍");
        	item.setPicUrl("https://mmbiz.qlogo.cn/mmbiz_jpg/vI9VeRGmQqCujkwCsq0B5PB91zBShPXEHW7sDyibXG5hBZyiaa4waSUkr6cJeBK4uNiabYdjSGibblFYW6ch0MwtTA/0?wx_fmt=jpeg");
        	item.setTitle("【重磅】取消柴油货车进港通知");
        	item.setUrl("https://mp.weixin.qq.com/s?__biz=MzIyNDkwNDc2NA==&mid=2247483736&idx=1&sn=91c4120176be1636cd930698725ef917&chksm=e806920bdf711b1d3072fd28adcd963b217c0c4989786b9934655d9811a291f75eb32c5d819f&scene=0#rd");
        	articles.addArticle(item);
        	content = JSONObject.toJSONString(articles);
        	
        	return new NewsBuilder().build(content, wxMessage, weixinService);
    		
    	}else if(wxMessage.getEventKey()!=null && wxMessage.getEventKey().equals("App_Download")){
    		
        	WxMpXmlOutNewsMessage articles = new WxMpXmlOutNewsMessage();
        	Item item = new Item();
        	item.setDescription("点击进入，长按二维码下载APP。");
        	item.setPicUrl("https://mmbiz.qlogo.cn/mmbiz_jpg/vI9VeRGmQqCibBIwSS1bTmrZFxj1A2apSuasgBGt9kJpJxVfXzPmEozib9dAwxuzTzYgDJ7dTU61LLYvzZT49sNA/0?wx_fmt=jpeg");
        	item.setTitle("黄骅港货先生App下载");
        	item.setUrl("https://mp.weixin.qq.com/s?__biz=MzIyNDkwNDc2NA==&mid=100000001&idx=1&sn=36da3a3d19d19e609f4c61d8bfcff571&chksm=680692525f711b4472651e5c19f5ca2d87686163292b39d69a2b2104e56a49b6c9aac4de62c6&scene=18#rd");
        	articles.addArticle(item);
        	content = JSONObject.toJSONString(articles);
        	
        	return new NewsBuilder().build(content, wxMessage, weixinService);
        }else{
        	return null;
        }
    }

}
