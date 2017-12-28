package com.example.demo.wechat.controller;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.menu.WxMpGetSelfMenuInfoResult;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.wechat.service.WechatService;

/**
 * <pre>
 *  注意：此contorller 实现WxMpMenuService接口，仅是为了演示如何调用所有菜单相关操作接口，
 *      实际项目中无需这样，根据自己需要添加对应接口即可
 * </pre>
 *
 * @author Binary Wang(https://github.com/binarywang)
 */
@RestController
@RequestMapping("/wechat/menu")
public class WxMenuController{ //implements WxMpMenuService {

//    @Autowired
//    private WxMpService wxService;

	@Autowired
    private WechatService wechatService;
	
    /**
     * <pre>
     * 自定义菜单创建接口
     * 详情请见：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141013&token=&lang=zh_CN
     * 如果要创建个性化菜单，请设置matchrule属性
     * 详情请见：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455782296&token=&lang=zh_CN
     * </pre>
     *
     * @param menu
     * @return 如果是个性化菜单，则返回menuid，否则返回null
     */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public String menuCreate(@RequestBody WxMenu menu) throws WxErrorException {
        return this.wechatService.wxService.getMenuService().menuCreate(menu);
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String menuCreateSample() throws WxErrorException {
        WxMenu menu = new WxMenu();
        WxMenuButton button1 = new WxMenuButton();
        button1.setType(WxConsts.BUTTON_VIEW);
        button1.setName("领红包");
        button1.setKey("Ling_Hong_Bao");
        button1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx8c9ebf34b648998d&redirect_uri=http://www.cargocn.com/cargocn-cloud-hhg/hhg/wxhb&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

        WxMenuButton button2 = new WxMenuButton();
//        button2.setType(WxConsts.BUTTON_VIEW);
        button2.setName("最新资讯");
//        button2.setKey("Daily_Goods");
//        button2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx8c9ebf34b648998d&redirect_uri=http://www.cargocn.com/cargocn-cloud-hhg/hhg/wxlist&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
        
        WxMenuButton button21 = new WxMenuButton();
        button21.setType(WxConsts.BUTTON_VIEW);
        button21.setName("每日找货");
        button21.setKey("Daily_Goods");
        button21.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx8c9ebf34b648998d&redirect_uri=http://www.cargocn.com/cargocn-cloud-hhg/hhg/wxlist&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
        
        WxMenuButton button22 = new WxMenuButton();
        button22.setType(WxConsts.BUTTON_CLICK);
        button22.setName("码头动态");
        button22.setKey("Daily_Dynamic");
        
        button2.getSubButtons().add(button21);
        button2.getSubButtons().add(button22);
        
        WxMenuButton button3 = new WxMenuButton();
        button3.setName("我的");

        WxMenuButton button31 = new WxMenuButton();
        button31.setType(WxConsts.BUTTON_MINIPROGRAM);
        button31.setName("运单");
        button31.setKey("Yun_Dan");
        button31.setAppId("wx8a26edc25685559b");
        button31.setPagePath("pages/dispatch/dispatch");
        button31.setUrl("http://mp.weixin.qq.com");

        WxMenuButton button32 = new WxMenuButton();
        button32.setType(WxConsts.BUTTON_MINIPROGRAM);
        button32.setName("账户");
        button32.setKey("Zhang_Hu");
        button32.setAppId("wx8a26edc25685559b");
        button32.setPagePath("pages/user/user");
        button32.setUrl("http://mp.weixin.qq.com");
        
//        WxMenuButton button31 = new WxMenuButton();
//        button31.setType(WxConsts.BUTTON_VIEW);
//        button31.setName("运单");
//        button31.setUrl("http://www.cargocn.com");
//
//        WxMenuButton button32 = new WxMenuButton();
//        button32.setType(WxConsts.BUTTON_VIEW);
//        button32.setName("账户");
//        button32.setUrl("http://www.cargocn.com");

        WxMenuButton button33 = new WxMenuButton();
        //button33.setType(WxConsts.BUTTON_VIEW_LIMITED);
        button33.setType(WxConsts.BUTTON_CLICK);
        button33.setName("下载App快速提现");
        button33.setKey("App_Download");
        //button33.setMediaId("100000001");
        //button33.setUrl("https://mp.weixin.qq.com/s?__biz=MzIyNDkwNDc2NA==&mid=100000001&idx=1&sn=36da3a3d19d19e609f4c61d8bfcff571&chksm=680692525f711b4472651e5c19f5ca2d87686163292b39d69a2b2104e56a49b6c9aac4de62c6&scene=18#rd");
        

        button3.getSubButtons().add(button31);
        button3.getSubButtons().add(button32);
        button3.getSubButtons().add(button33);
        
        menu.getButtons().add(button1);
        menu.getButtons().add(button2);
        menu.getButtons().add(button3);

        return this.wechatService.wxService.getMenuService().menuCreate(menu);
    }

    /**
     * <pre>
     * 自定义菜单创建接口
     * 详情请见： https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141013&token=&lang=zh_CN
     * 如果要创建个性化菜单，请设置matchrule属性
     * 详情请见：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455782296&token=&lang=zh_CN
     * </pre>
     *
     * @param json
     * @return 如果是个性化菜单，则返回menuid，否则返回null
     */
    @RequestMapping(value = "/create/{json}", method = RequestMethod.GET)
    public String menuCreate(@PathVariable String json) throws WxErrorException {
        return this.wechatService.wxService.getMenuService().menuCreate(json);
    }

    /**
     * <pre>
     * 自定义菜单删除接口
     * 详情请见: https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141015&token=&lang=zh_CN
     * </pre>
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void menuDelete() throws WxErrorException {
        this.wechatService.wxService.getMenuService().menuDelete();
    }

    /**
     * <pre>
     * 删除个性化菜单接口
     * 详情请见: https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455782296&token=&lang=zh_CN
     * </pre>
     *
     * @param menuId 个性化菜单的menuid
     */
    @RequestMapping(value = "/delete/{menuId}", method = RequestMethod.GET)
    public void menuDelete(@PathVariable String menuId) throws WxErrorException {
        this.wechatService.wxService.getMenuService().menuDelete(menuId);
    }

    /**
     * <pre>
     * 自定义菜单查询接口
     * 详情请见： https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141014&token=&lang=zh_CN
     * </pre>
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public WxMpMenu menuGet() throws WxErrorException {
        return this.wechatService.wxService.getMenuService().menuGet();
    }

    /**
     * <pre>
     * 测试个性化菜单匹配结果
     * 详情请见: http://mp.weixin.qq.com/wiki/0/c48ccd12b69ae023159b4bfaa7c39c20.html
     * </pre>
     *
     * @param userid 可以是粉丝的OpenID，也可以是粉丝的微信号。
     */
    @RequestMapping(value = "/menuTryMatch/{userid}", method = RequestMethod.GET)
    public WxMenu menuTryMatch(@PathVariable String userid) throws WxErrorException {
        return this.wechatService.wxService.getMenuService().menuTryMatch(userid);
    }

    /**
     * <pre>
     * 获取自定义菜单配置接口
     * 本接口将会提供公众号当前使用的自定义菜单的配置，如果公众号是通过API调用设置的菜单，则返回菜单的开发配置，而如果公众号是在公众平台官网通过网站功能发布菜单，则本接口返回运营者设置的菜单配置。
     * 请注意：
     * 1、第三方平台开发者可以通过本接口，在旗下公众号将业务授权给你后，立即通过本接口检测公众号的自定义菜单配置，并通过接口再次给公众号设置好自动回复规则，以提升公众号运营者的业务体验。
     * 2、本接口与自定义菜单查询接口的不同之处在于，本接口无论公众号的接口是如何设置的，都能查询到接口，而自定义菜单查询接口则仅能查询到使用API设置的菜单配置。
     * 3、认证/未认证的服务号/订阅号，以及接口测试号，均拥有该接口权限。
     * 4、从第三方平台的公众号登录授权机制上来说，该接口从属于消息与菜单权限集。
     * 5、本接口中返回的图片/语音/视频为临时素材（临时素材每次获取都不同，3天内有效，通过素材管理-获取临时素材接口来获取这些素材），本接口返回的图文消息为永久素材素材（通过素材管理-获取永久素材接口来获取这些素材）。
     *  接口调用请求说明:
     * http请求方式: GET（请使用https协议）
     * https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN
     * </pre>
     */
    @RequestMapping(value = "/getSelfMenuInfo", method = RequestMethod.GET)
    public WxMpGetSelfMenuInfoResult getSelfMenuInfo() throws WxErrorException {
    	WxMpGetSelfMenuInfoResult result = this.wechatService.wxService.getMenuService().getSelfMenuInfo();
    	System.out.println(result.toString());
        return result;
    }
}
