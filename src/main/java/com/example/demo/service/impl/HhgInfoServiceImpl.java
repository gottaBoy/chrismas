package com.example.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.HhgInfo;
import com.example.demo.dao.HhgInfoDao;
import com.example.demo.service.HhgInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class HhgInfoServiceImpl implements HhgInfoService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private HhgInfoDao hhgInfoDao;
    
    @Override
	public PageInfo<HhgInfo> findHhgInfo(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<HhgInfo> list = hhgInfoDao.findHhgInfo();
		PageInfo<HhgInfo> page = new PageInfo<HhgInfo>(list);
		logger.debug(page.toString());
		return page;
	}
    
    @Override
   	public PageInfo<HhgInfo> findHhgInfoBefore(int pageNum, int pageSize) {
   		PageHelper.startPage(pageNum, pageSize);
   		List<HhgInfo> list = hhgInfoDao.findHhgInfoBefore();
   		PageInfo<HhgInfo> page = new PageInfo<HhgInfo>(list);
   		logger.debug(page.toString());
   		return page;
   	}

    public List<HhgInfo> findAllHhgInfo(){
        return hhgInfoDao.findAllHhgInfo();
    }

    public HhgInfo findHhgInfoById(Long id) {
        return hhgInfoDao.findHhgInfoById(id);
    }

    @Override
    public Long saveHhgInfo(HhgInfo HhgInfo) {
        return hhgInfoDao.saveHhgInfo(HhgInfo);
    }

    @Override
    public Long updateHhgInfo(HhgInfo HhgInfo) {
        return hhgInfoDao.updateHhgInfo(HhgInfo);
    }

    @Override
    public Long deleteHhgInfo(Long id) {
        return hhgInfoDao.deleteHhgInfo(id);
    }

}