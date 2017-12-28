package com.example.demo.wechat.lbs;

import java.io.Serializable;

/**
 * @author minyi
 * @see
 * 位置描述
 */
public class FamousArea implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;
	
	private Location location;
	
	private String _distance;
	
	private String _dir_desc;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String get_dir_desc() {
		return _dir_desc;
	}
	public void set_dir_desc(String _dir_desc) {
		this._dir_desc = _dir_desc;
	}
	
	
	

}
