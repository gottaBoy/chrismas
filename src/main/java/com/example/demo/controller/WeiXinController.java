package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.HhgInfo;
import com.example.demo.commons.datatables.DataTablesRequest;
import com.example.demo.commons.datatables.DataTablesResponse;
import com.example.demo.service.HhgInfoService;
import com.example.demo.utils.HttpRequest;
import com.example.demo.wechat.config.WechatMpProperties;
import com.example.demo.wechat.config.WechatUrlProperties;
import com.github.pagehelper.PageInfo;

@RestController
public class WeiXinController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	@Autowired
//    private WxMpService wxService;
	@Autowired
    private WechatMpProperties mp_props;
	@Autowired
    private WechatUrlProperties url_props;
	@Autowired
    private HhgInfoService hhgInfoService;
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView error() {
		ModelAndView mv = new ModelAndView("error");
		return mv;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView rootlist() {
		ModelAndView mv = new ModelAndView("hhgInfo/list");
		return mv;
	}
	
	@RequestMapping(value = "/hhg/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("hhgInfo/list");
		return mv;
	}
	
	@RequestMapping(value = "/hhg/getPageList", method = RequestMethod.POST)
	public @ResponseBody DataTablesResponse<HhgInfo> list(String dtParaJson) {
		logger.debug(dtParaJson);
		DataTablesRequest req = DataTablesRequest.getInstance(dtParaJson);
		PageInfo<HhgInfo> page = hhgInfoService.findHhgInfo(req.getPageNum(),req.getiDisplayLength());
		DataTablesResponse<HhgInfo> ret = new DataTablesResponse<HhgInfo>();
		ret.setData(page.getList());
		ret.setDraw(req.getsEcho() + 1);
		ret.setRecordsTotal(page.getTotal());
		ret.setRecordsFiltered(page.getTotal());
		return ret;
	}
	
	@RequestMapping(value = "/hhg/listbefore", method = RequestMethod.GET)
	public ModelAndView listbefore() {
		ModelAndView mv = new ModelAndView("hhgInfo/listbefore");
		return mv;
	}
	
	@RequestMapping(value = "/hhg/getPageListBefore", method = RequestMethod.POST)
	public @ResponseBody DataTablesResponse<HhgInfo> listbefore(
			String dtParaJson) {
		logger.debug(dtParaJson);
		DataTablesRequest req = DataTablesRequest.getInstance(dtParaJson);
		PageInfo<HhgInfo> page = hhgInfoService.findHhgInfoBefore(req.getPageNum(),req.getiDisplayLength());
		DataTablesResponse<HhgInfo> ret = new DataTablesResponse<HhgInfo>();
		ret.setData(page.getList());
		ret.setDraw(req.getsEcho() + 1);
		ret.setRecordsTotal(page.getTotal());
		ret.setRecordsFiltered(page.getTotal());
		return ret;
	}

	@RequestMapping(value = "/hhg/create", method = RequestMethod.GET)
	public ModelAndView create(ModelAndView mv) {
		mv.setViewName("hhgInfo/create");
		return mv;
	}
	
	@RequestMapping(value = "/hhg/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(ModelAndView mv,@PathVariable("id") Long id) {
		HhgInfo hhgInfo = new HhgInfo();
		if(id!=null){
			hhgInfo = hhgInfoService.findHhgInfoById(id);
		}
		mv.addObject("hhgInfo",hhgInfo);
		mv.setViewName("hhgInfo/edit");
		return mv;
	}
	
	@RequestMapping(value = "/hhg/saveHhgInfo", method = RequestMethod.POST)
	public ModelAndView publishSave(ModelAndView mv,HhgInfo hhgInfo) {
		Long flag = 0L;
		if(hhgInfo.getId()!=null && hhgInfo.getId()>0){
			flag = hhgInfoService.updateHhgInfo(hhgInfo);
		}else{
			flag = hhgInfoService.saveHhgInfo(hhgInfo);
		}
		if(flag>0){
			mv.setViewName("hhgInfo/list");
		}else{
			mv.setViewName("hhgInfo/list");
		}
		return mv;
	}
	
	@RequestMapping(value = "/hhg/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(ModelAndView mv,@PathVariable("id") Long id) {
		Long flag = 0L;
		flag = hhgInfoService.deleteHhgInfo(id);
		if(flag>0){
			mv.setViewName("hhgInfo/list");
		}else{
			mv.setViewName("hhgInfo/list");
		}
		return mv; 
    }
	
    
	@RequestMapping(value = "/hhg/wxlist", method = RequestMethod.GET)
    public ModelAndView wxlist(ModelAndView mv,HttpServletRequest req) {
		
		String code = req.getParameter("code");
		if(code==null){
			mv.addObject("showTel", false);
			mv.addObject("code", "");
		}else{
			//跨平台请求
			String param = "code="+code;//+"&appid="+this.properties.getAppId()+"&secret="+this.properties.getSecret();
			String url = this.url_props.getCodeUrl();
			String result = HttpRequest.sendGet(url, param);
			JSONObject obj = JSONObject.parseObject(result);  
			if(obj.get("success")!=null && (boolean) obj.get("success")){
				//用户 未认证-1  认证审核中-2   认证通过-3   认证失败-4
				if(obj.get("userInfo")!=null && obj.get("userInfo").equals("3")){
					mv.addObject("showTel", true);
				}else{
					mv.addObject("showTel", false);
				}
			}else{
				mv.addObject("showTel", false);
			}
			mv.addObject("code", code);
		}
		logger.debug("获取code的值"+ code);
		List<HhgInfo> hhgInfoList = hhgInfoService.findAllHhgInfo();
        mv.setViewName("hhgInfo/wxlist");
        mv.addObject("hhgInfoList", hhgInfoList);
        return mv;
    }
	
	@RequestMapping(value = "/hhg/wxhb", method = RequestMethod.GET)
    public ModelAndView wxhb(ModelAndView mv,HttpServletRequest req) {
		
		String code = req.getParameter("code");
		logger.debug("获取code的值"+ code);
		if(code==null){
	        mv.setViewName("hhgInfo/qhb");
		}else{
			//跨平台请求
			String param = "code="+code;
			String url = this.url_props.getCodeUrl();
			String result = HttpRequest.sendGet(url, param);
			JSONObject obj = JSONObject.parseObject(result); 
			if(obj.get("success")!=null && (boolean) obj.get("success")){
				//用户 未认证-1  认证审核中-2   认证通过-3   认证失败-4
				if(obj.get("userInfo")!=null && (obj.get("userInfo").equals("2")||obj.get("userInfo").equals("3")||obj.get("userInfo").equals("4"))){
					mv.setViewName("hhgInfo/lhb");
				}else{
					mv.setViewName("hhgInfo/qhb");
				}
			}else{
				mv.setViewName("hhgInfo/qhb");
			}
		}
        return mv;
    }
	
    @RequestMapping(value = "/hhg/wxhbcd", method = RequestMethod.GET)
    public ModelAndView wxhbcd(ModelAndView mv,HttpServletRequest req) {
	    mv.setViewName("hhgInfo/wxhbcd");
        return mv;
    }

    @RequestMapping(value = "/hhg/news", method = RequestMethod.POST)
    public void createhhgInfo(@RequestBody HhgInfo hhgInfo) {
        hhgInfoService.saveHhgInfo(hhgInfo);
    }

    @RequestMapping(value = "/hhg/news", method = RequestMethod.PUT)
    public void modifyhhgInfo(@RequestBody HhgInfo hhgInfo) {
        hhgInfoService.updateHhgInfo(hhgInfo);
    }

    @RequestMapping(value = "/hhg/news/{id}", method = RequestMethod.DELETE)
    public void modifyhhgInfo(@PathVariable("id") Long id) {
        hhgInfoService.deleteHhgInfo(id);
    }
}
