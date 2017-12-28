package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.utils.HttpRequest;

public class HttpRequestTest {

	public static void main(String[] args) {
		HttpRequestTest test = new HttpRequestTest();
		test.test2();
//		test.test3();
    }
	
	public void test1(){
		String code = "001pFneF1eRId40YtfeF1yEieF1pFneQ";
        //发送 GET 请求
        String result=HttpRequest.sendGet("http://test.cargocn.cn/cargocn-cloud-server/weChatApp/gzhUserCheck", "code="+code);
        System.out.println(result);
        JSONObject obj;  
        obj = JSONObject.parseObject(result);  
        //{"success":false,"userInfo":null,"message":"获取unionID失败","total":0}
        System.out.println(obj.get("success"));
        System.out.println(obj.get("userInfo"));
        
        
        //发送 POST 请求
        //String sr=HttpRequest.sendPost("http://localhost:6144/Home/RequestPostString", "key=123&v=456");
        //System.out.println(sr);
	}
	
	public void test2(){
		String city = "上海市";
        //发送 GET 请求
        String result=HttpRequest.sendGetGZIP("http://wthrcdn.etouch.cn/weather_mini", "city="+city);
        System.out.println(result);
        JSONObject obj;  
        obj = JSONObject.parseObject(result);  
        //{"success":false,"userInfo":null,"message":"获取unionID失败","total":0}
        System.out.println(obj.get("desc"));
        System.out.println(obj.get("data"));
        
        
        //发送 POST 请求
        //String sr=HttpRequest.sendPost("http://localhost:6144/Home/RequestPostString", "key=123&v=456");
        //System.out.println(sr);
	}
	
	public void test3(){
		String city = "上海市";
        //发送 GET 请求
        String result=HttpRequest.sendGet("http://www.sojson.com/open/api/weather/json.shtml", "city="+city);
        System.out.println(result);
        JSONObject obj;  
        obj = JSONObject.parseObject(result);  
        //{"success":false,"userInfo":null,"message":"获取unionID失败","total":0}
        System.out.println(obj.get("status"));
        System.out.println(obj.get("data"));
        
        
        //发送 POST 请求
        //String sr=HttpRequest.sendPost("http://localhost:6144/Home/RequestPostString", "key=123&v=456");
        //System.out.println(sr);
	}
}
