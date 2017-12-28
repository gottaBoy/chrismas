package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.HhgInfo;
import com.github.pagehelper.PageInfo;

public interface HhgInfoService {

	public PageInfo<HhgInfo> findHhgInfo(int pageNum, int pageSize);
	
	public PageInfo<HhgInfo> findHhgInfoBefore(int pageNum, int pageSize);
    /**
     * 获取黄骅港最新消息列表
     *
     * @return
     */
    List<HhgInfo> findAllHhgInfo();

    /**
     * 根据ID,查询消息信息
     *
     * @param id
     * @return
     */
    HhgInfo findHhgInfoById(Long id);

    /**
     * 新增信息
     *
     * @param HhgInfo
     * @return
     */
    Long saveHhgInfo(HhgInfo hhgInfo);

    /**
     * 更新信息
     *
     * @param HhgInfo
     * @return
     */
    Long updateHhgInfo(HhgInfo hhgInfo);

    /**
     * 根据城ID,删除信息
     *
     * @param id
     * @return
     */
    Long deleteHhgInfo(Long id);
}
