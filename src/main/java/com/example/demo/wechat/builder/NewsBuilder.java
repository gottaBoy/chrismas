package com.example.demo.wechat.builder;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;

public class NewsBuilder extends AbstractBuilder{

	@Override
	public WxMpXmlOutMessage build(String content, WxMpXmlMessage wxMessage, WxMpService service) {
		
		//@SuppressWarnings("unchecked")
		//List<WxMpXmlOutNewsMessage.Item> newContent = (List<Item>) JSONObject.parseObject(content, WxMpXmlOutNewsMessage.Item.class);
		WxMpXmlOutNewsMessage newContent = JSONObject.parseObject(content, WxMpXmlOutNewsMessage.class);
		WxMpXmlOutNewsMessage m = WxMpXmlOutMessage.NEWS().articles(newContent.getArticles())
                .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                .build();

        return m;
	}

}
