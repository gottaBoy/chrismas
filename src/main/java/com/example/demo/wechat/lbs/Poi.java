package com.example.demo.wechat.lbs;

import java.io.Serializable;

/**
 * @author minyi
 * @see
 * 位置描述
 */
public class Poi implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String title;
	private String address;
	private String category;
	private Location location;
	private String _distance;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String get_distance() {
		return _distance;
	}
	public void set_distance(String _distance) {
		this._distance = _distance;
	}
	
}
