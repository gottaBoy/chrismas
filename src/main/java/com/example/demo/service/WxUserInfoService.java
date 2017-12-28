package com.example.demo.service;

import com.example.demo.bean.WxUserInfo;

public interface WxUserInfoService {

	int deleteByPrimaryKey(Long id);

    int insert(WxUserInfo record);

    int insertSelective(WxUserInfo record);

    WxUserInfo selectByPrimaryKey(Long id);
    
    WxUserInfo selectByOpenidAndUnionid(String openid,String unionid);

    int updateByPrimaryKeySelective(WxUserInfo record);

    int updateByPrimaryKey(WxUserInfo record);
}
