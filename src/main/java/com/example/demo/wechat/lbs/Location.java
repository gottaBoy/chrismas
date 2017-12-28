package com.example.demo.wechat.lbs;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author minyi
 * @see
 * 
 */
public class Location implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	/**
	 * 经度
	 */
	private BigDecimal lat;
	/**
	 * 维度
	 */
	private BigDecimal lng;

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
}
