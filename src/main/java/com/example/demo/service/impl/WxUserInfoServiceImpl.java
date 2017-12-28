package com.example.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.WxUserInfo;
import com.example.demo.dao.WxUserInfoMapper;
import com.example.demo.service.WxUserInfoService;

@Service
public class WxUserInfoServiceImpl implements WxUserInfoService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private WxUserInfoMapper wxUserInfoMapper;
    
	@Override
	public int deleteByPrimaryKey(Long id) {
		return wxUserInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(WxUserInfo record) {
		return wxUserInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(WxUserInfo record) {
		return wxUserInfoMapper.insertSelective(record);
	}

	@Override
	public WxUserInfo selectByPrimaryKey(Long id) {
		return wxUserInfoMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public WxUserInfo selectByOpenidAndUnionid(String openid,String unionid){
		return wxUserInfoMapper.selectByOpenidAndUnionid(openid,unionid);
	}

	@Override
	public int updateByPrimaryKeySelective(WxUserInfo record) {
		return wxUserInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(WxUserInfo record) {
		return wxUserInfoMapper.updateByPrimaryKey(record);
	}

}
