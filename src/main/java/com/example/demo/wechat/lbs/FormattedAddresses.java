package com.example.demo.wechat.lbs;

import java.io.Serializable;

/**
 * @author minyi
 * @see
 * 位置描述
 */
public class FormattedAddresses implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 经过腾讯地图优化过的描述方式，更具人性化特点
	 */
	private String recommend;
	
	/**
	 * 大致位置，可用于对位置的粗略描述
	 */
	private String rough;
	
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getRough() {
		return rough;
	}
	public void setRough(String rough) {
		this.rough = rough;
	}
}
