package com.example.demo.wechat.bean;

import java.io.Serializable;

/**
 * @author minyi
 * @see
 * 位置描述
 */
public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long driverId;
	
	private Long carId;
	
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	} 
}
