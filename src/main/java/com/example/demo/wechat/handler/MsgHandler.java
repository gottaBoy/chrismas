package com.example.demo.wechat.handler;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage.Item;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.wechat.builder.ImageBuilder;
import com.example.demo.wechat.builder.NewsBuilder;
import com.example.demo.wechat.builder.TextBuilder;
import com.example.demo.wechat.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(WxConsts.XML_MSG_EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
        try {
            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
                    && weixinService.getKefuService().kfOnlineList()
                    .getKfOnlineList().size() > 0) {
                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
                        .fromUser(wxMessage.getToUser())
                        .toUser(wxMessage.getFromUser()).build();
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        
        String content = "当前支持关键词：红包 领取红包  提现  红包提现  钱  20元  20 怎么认证  认证  如何认证  认证不了 app app下载  快速提现  提现不了" ;//+ JsonUtils.toJson(wxMessage);
        
        //1.领取红包
        //key:红包 领取红包
        //pic_url=https://mmbiz.qlogo.cn/mmbiz_jpg/vI9VeRGmQqAQflZicDxbEypJEJpPkRjSKqHOw5RiacZQZhmsClX0JopibeejArAvdpPuXx7FRgMt0mK3Zdn3YZ2EQ/0?wx_fmt=jpeg
        //url=https://mp.weixin.qq.com/s?__biz=MzIyNDkwNDc2NA==&mid=100000011&idx=1&sn=7a5b8c9f9bbf03e5e3c3fb4872bb7de4&chksm=680692585f711b4e35f0ca14f9dd1078bf6f8a9bff8389cf03b08b5d951dccb85c63ef31c6dd&scene=20#rd
        
        
        //2.红包提现 
        //key: 提现  红包提现  钱  20元  20
        //pic_url=https://mmbiz.qlogo.cn/mmbiz_jpg/vI9VeRGmQqAQflZicDxbEypJEJpPkRjSKCffazEtoRiaLDzAQ04Y5uDpk0Wn2oCAW7CxTJ8g72zrChztqNmKBOpw/0?wx_fmt=jpeg
        //url=https://mp.weixin.qq.com/s?__biz=MzIyNDkwNDc2NA==&mid=100000040&idx=1&sn=94093c5d1f7d77f5ddf0f960d5a0fcf7&chksm=6806927b5f711b6dbb7ce40320b0877fe2870e6a95f090ea7d10387d630d5725509b8dd834ae&scene=20#rd
        
        //3.认证 
        //key:怎么认证  认证  如何认证  认证不了
        //url=https://mmbiz.qlogo.cn/mmbiz_jpg/vI9VeRGmQqCEVfjClv7MCpNflFh2XXoRsq68oWa3lIcn6BADlescIKtC13TiciaEDWFg2Okhw0cBxQODS7iaT92yQ/0?wx_fmt=jpeg
        
        //4.快速体现
        //key:app app下载  快速提现  提现不了
        //pic_url=https://mmbiz.qlogo.cn/mmbiz_jpg/vI9VeRGmQqAQflZicDxbEypJEJpPkRjSKCffazEtoRiaLDzAQ04Y5uDpk0Wn2oCAW7CxTJ8g72zrChztqNmKBOpw/0?wx_fmt=jpeg
        //url=https://mp.weixin.qq.com/s?__biz=MzIyNDkwNDc2NA==&mid=100000056&idx=1&sn=f0b9d40e291571b00ed3f07f57590eb9&chksm=6806926b5f711b7d2931786b715d07eabf9d7e2e3734849c0bfd4738c9c5258b7cc70cad66da&scene=20#rd
        
        if(StringUtils.startsWithAny(wxMessage.getContent(), "红包","领取红包")){//1.领取红包
        	//List<WxMpXmlOutNewsMessage.Item> articles = new ArrayList<WxMpXmlOutNewsMessage.Item>();
        	WxMpXmlOutNewsMessage articles = new WxMpXmlOutNewsMessage();
        	Item item = new Item();
        	item.setDescription("想要领现金红包却不知道从哪下手？一步一步教你领取！");
        	item.setPicUrl("https://mmbiz.qlogo.cn/mmbiz_jpg/vI9VeRGmQqAQflZicDxbEypJEJpPkRjSKqHOw5RiacZQZhmsClX0JopibeejArAvdpPuXx7FRgMt0mK3Zdn3YZ2EQ/0?wx_fmt=jpeg");
        	item.setTitle("福利啦-进黄骅港就领20元红包!");
        	item.setUrl("https://mp.weixin.qq.com/s?__biz=MzIyNDkwNDc2NA==&mid=100000011&idx=1&sn=7a5b8c9f9bbf03e5e3c3fb4872bb7de4&chksm=680692585f711b4e35f0ca14f9dd1078bf6f8a9bff8389cf03b08b5d951dccb85c63ef31c6dd&scene=20#rd");
        	articles.addArticle(item);
        	content = JSONObject.toJSONString(articles);
        	return new NewsBuilder().build(content, wxMessage, weixinService);
        	
        }else if(StringUtils.startsWithAny(wxMessage.getContent(), "提现","红包提现","钱","20元","20")){//2.红包提现 
        	
        	WxMpXmlOutNewsMessage articles = new WxMpXmlOutNewsMessage();
        	Item item = new Item();
        	item.setDescription("认证司机，20元红包到账 3步搞定！");
        	item.setPicUrl("https://mmbiz.qlogo.cn/mmbiz_jpg/vI9VeRGmQqAQflZicDxbEypJEJpPkRjSKCffazEtoRiaLDzAQ04Y5uDpk0Wn2oCAW7CxTJ8g72zrChztqNmKBOpw/0?wx_fmt=jpeg");
        	item.setTitle("黄骅港-第一批红包全部到账");
        	item.setUrl("https://mp.weixin.qq.com/s?__biz=MzIyNDkwNDc2NA==&mid=100000040&idx=1&sn=94093c5d1f7d77f5ddf0f960d5a0fcf7&chksm=6806927b5f711b6dbb7ce40320b0877fe2870e6a95f090ea7d10387d630d5725509b8dd834ae&scene=20#rd");
        	articles.addArticle(item);
        	content = JSONObject.toJSONString(articles);
        	return new NewsBuilder().build(content, wxMessage, weixinService);
        	
        }else if(StringUtils.startsWithAny(wxMessage.getContent(), "怎么认证","认证","如何认证","认证不了")){//3.认证
        	
        	return new ImageBuilder().build("https://mmbiz.qlogo.cn/mmbiz_jpg/vI9VeRGmQqCEVfjClv7MCpNflFh2XXoRsq68oWa3lIcn6BADlescIKtC13TiciaEDWFg2Okhw0cBxQODS7iaT92yQ/0?wx_fmt=jpeg", wxMessage, weixinService);
      
        }else if(StringUtils.startsWithAny(wxMessage.getContent(), "app","app下载","快速提现","提现不了")){//4.快速体现
        	
        	WxMpXmlOutNewsMessage articles = new WxMpXmlOutNewsMessage();
        	Item item = new Item();
        	item.setDescription("下载app提现 2步完成！");
        	item.setPicUrl("https://mmbiz.qlogo.cn/mmbiz_jpg/vI9VeRGmQqAQflZicDxbEypJEJpPkRjSKCffazEtoRiaLDzAQ04Y5uDpk0Wn2oCAW7CxTJ8g72zrChztqNmKBOpw/0?wx_fmt=jpeg");
        	item.setTitle("App提现");
        	item.setUrl("https://mp.weixin.qq.com/s?__biz=MzIyNDkwNDc2NA==&mid=100000056&idx=1&sn=f0b9d40e291571b00ed3f07f57590eb9&chksm=6806926b5f711b7d2931786b715d07eabf9d7e2e3734849c0bfd4738c9c5258b7cc70cad66da&scene=20#rd");
        	articles.addArticle(item);
        	content = JSONObject.toJSONString(articles);
        	return new NewsBuilder().build(content, wxMessage, weixinService);
        	
        }else if(StringUtils.startsWithAny(wxMessage.getContent(), "煤炭","柴油车","柴油","煤")){   
        	
        	WxMpXmlOutNewsMessage articles = new WxMpXmlOutNewsMessage();
        	Item item = new Item();
        	item.setDescription("！！！柴油货车不能运煤炭到黄骅港码头啦‍");
        	item.setPicUrl("https://mmbiz.qlogo.cn/mmbiz_jpg/vI9VeRGmQqCujkwCsq0B5PB91zBShPXEHW7sDyibXG5hBZyiaa4waSUkr6cJeBK4uNiabYdjSGibblFYW6ch0MwtTA/0?wx_fmt=jpeg");
        	item.setTitle("【重磅】取消柴油货车进港通知");
        	item.setUrl("https://mp.weixin.qq.com/s?__biz=MzIyNDkwNDc2NA==&mid=2247483736&idx=1&sn=91c4120176be1636cd930698725ef917&chksm=e806920bdf711b1d3072fd28adcd963b217c0c4989786b9934655d9811a291f75eb32c5d819f&scene=0#rd");
        	articles.addArticle(item);
        	content = JSONObject.toJSONString(articles);
        	
        	return new NewsBuilder().build(content, wxMessage, weixinService);
        	
        }else if(StringUtils.startsWithAny(wxMessage.getContent(), "关","关键","关键字","key")){
        	//TODO 组装回复消息
        	return new TextBuilder().build(content, wxMessage, weixinService);
        }
    	//调起客服服务
    	try {
            if (weixinService.getKefuService().kfOnlineList()
                    .getKfOnlineList().size() > 0) {
                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
                        .fromUser(wxMessage.getToUser())
                        .toUser(wxMessage.getFromUser()).build();
            }else{
//            	content = "尊敬的客服，您好！当前客服繁忙请稍后重试";
//            	return new TextBuilder().build(content, wxMessage, weixinService);
                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
                        .fromUser(wxMessage.getToUser()).build();
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
            content = "尊敬的客服，您好！当前客服繁忙请稍后重试";
        	return new TextBuilder().build(content, wxMessage, weixinService);
        }
        
    }

}
