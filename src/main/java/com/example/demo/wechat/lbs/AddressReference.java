package com.example.demo.wechat.lbs;

import java.io.Serializable;
/**
 * @author minyi
 * @see
 * 位置描述
 */
public class AddressReference implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FamousArea famous_area;
	private Town town;
	private FamousArea landmark_l1;
	private FamousArea landmark_l2;
	private FamousArea street;
	private FamousArea street_number;
	private FamousArea crossroad;
	private FamousArea water;
	public FamousArea getFamous_area() {
		return famous_area;
	}
	public void setFamous_area(FamousArea famous_area) {
		this.famous_area = famous_area;
	}
	public Town getTown() {
		return town;
	}
	public void setTown(Town town) {
		this.town = town;
	}
	public FamousArea getLandmark_l1() {
		return landmark_l1;
	}
	public void setLandmark_l1(FamousArea landmark_l1) {
		this.landmark_l1 = landmark_l1;
	}
	public FamousArea getLandmark_l2() {
		return landmark_l2;
	}
	public void setLandmark_l2(FamousArea landmark_l2) {
		this.landmark_l2 = landmark_l2;
	}
	public FamousArea getStreet() {
		return street;
	}
	public void setStreet(FamousArea street) {
		this.street = street;
	}
	public FamousArea getStreet_number() {
		return street_number;
	}
	public void setStreet_number(FamousArea street_number) {
		this.street_number = street_number;
	}
	public FamousArea getCrossroad() {
		return crossroad;
	}
	public void setCrossroad(FamousArea crossroad) {
		this.crossroad = crossroad;
	}
	public FamousArea getWater() {
		return water;
	}
	public void setWater(FamousArea water) {
		this.water = water;
	}
}
