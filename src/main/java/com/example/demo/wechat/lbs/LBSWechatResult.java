package com.example.demo.wechat.lbs;

import java.io.Serializable;

/**
 * @author minyi
 * @see
 * 位置结果信息
 */
public class LBSWechatResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * unionId
	 */
	private String unionId;
	/**
	 * 位置详情
	 */
	private String adress;
	/**
	 * 经纬度信息
	 */
	private Location location;
	/**
	 * 省市县
	 */
	private AddressComponent addressComponent;

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public AddressComponent getAddressComponent() {
		return addressComponent;
	}

	public void setAddressComponent(AddressComponent addressComponent) {
		this.addressComponent = addressComponent;
	}

	@Override
	public String toString() {
		return "LBSWechatResult [unionId=" + unionId + ", adress=" + adress + ", location=" + location
				+ ", addressComponent=" + addressComponent + "]";
	}
	
}
