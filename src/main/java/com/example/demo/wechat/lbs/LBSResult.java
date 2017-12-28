package com.example.demo.wechat.lbs;

import java.io.Serializable;
import java.util.List;

/**
 * @author minyi
 * @see
 * 位置描述
 */
public class LBSResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String address;
	
	private FormattedAddresses formatted_addresses;
	
	private AddressComponent address_component;
	
	private AdInfo ad_info;
	
	private AddressReference address_reference;
	
	private List<Poi> pois;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public FormattedAddresses getFormatted_addresses() {
		return formatted_addresses;
	}
	public void setFormatted_addresses(FormattedAddresses formatted_addresses) {
		this.formatted_addresses = formatted_addresses;
	}
	public AddressComponent getAddress_component() {
		return address_component;
	}
	public void setAddress_component(AddressComponent address_component) {
		this.address_component = address_component;
	}
	public AdInfo getAd_info() {
		return ad_info;
	}
	public void setAd_info(AdInfo ad_info) {
		this.ad_info = ad_info;
	}
	public AddressReference getAddress_reference() {
		return address_reference;
	}
	public void setAddress_reference(AddressReference address_reference) {
		this.address_reference = address_reference;
	}
	public List<Poi> getPois() {
		return pois;
	}
	public void setPois(List<Poi> pois) {
		this.pois = pois;
	}
}
