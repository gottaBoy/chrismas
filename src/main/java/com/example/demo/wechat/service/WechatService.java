package com.example.demo.wechat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.wechat.handler.LocationHandler;
import com.example.demo.wechat.handler.LogHandler;
import com.example.demo.wechat.handler.MenuHandler;
import com.example.demo.wechat.handler.MsgHandler;
import com.example.demo.wechat.handler.SubscribeHandler;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Service
public class WechatService {

//	@Autowired
//	private Logger logger;
	
    @Autowired
    protected LogHandler logHandler;
    @Autowired
    protected SubscribeHandler subscribeHandler;
    @Autowired
    protected MenuHandler menuHandler;
    @Autowired
    protected MsgHandler msgHandler;
    @Autowired
    protected LocationHandler locationHandler;
    @Autowired
    public WxMpService wxService;

    @Autowired
    public WxMpMessageRouter router;
    
    public WechatService() {
    	this.refreshRouter();
    }

    public void refreshRouter() {
        final WxMpMessageRouter newRouter = new WxMpMessageRouter(wxService);
        // 记录所有事件的日志
        newRouter.rule().handler(this.logHandler).next();
        // 关注事件
        newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
            .event(WxConsts.EVT_SUBSCRIBE).handler(this.subscribeHandler)
                .end();
        
        //获取地理位置
        newRouter.rule().async(false).msgType(WxConsts.XML_MSG_LOCATION)
        .event(WxConsts.EVT_LOCATION).handler(this.locationHandler).end();
        //button click
        newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
        .event(WxConsts.EVT_CLICK).handler(this.menuHandler)
            .end();
        
        newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
        .event(WxConsts.EVT_VIEW).handler(this.msgHandler)
            .end();
        
        // 默认,转发消息给客服人员
        newRouter.rule().async(false).handler(this.msgHandler).end();
        this.router = newRouter;
    }

    public WxMpXmlOutMessage route(WxMpXmlMessage inMessage) {
        try {
            return this.router.route(inMessage);
        } catch (Exception e) {
            //this.logger.error(e.getMessage(), e);
        	System.out.println(e.getMessage());
        }

        return null;
    }
    
    public WxMpUser getUserInfo(String openid, String lang) {
        WxMpUser wxMpUser = null;
        try {
            wxMpUser = wxService.getUserService().userInfo(openid, lang);
        } catch (WxErrorException e) {
            //this.logger.error(e.getError().toString());
            System.out.println(e.getMessage());
        }
        return wxMpUser;
    }

}
