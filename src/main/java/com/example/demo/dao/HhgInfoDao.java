package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.example.demo.bean.HhgInfo;

import java.util.List;

/**
 *  DAO 接口类
 *
 */
public interface HhgInfoDao {

	List<HhgInfo> findHhgInfo();
	
	List<HhgInfo> findHhgInfoBefore();
    /**
     * 获取信息列表
     *
     * @return
     */
    List<HhgInfo> findAllHhgInfo();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    HhgInfo findHhgInfoById(@Param("id") Long id);

    Long saveHhgInfo(HhgInfo HhgInfo);

    Long updateHhgInfo(HhgInfo HhgInfo);

    Long deleteHhgInfo(Long id);
}