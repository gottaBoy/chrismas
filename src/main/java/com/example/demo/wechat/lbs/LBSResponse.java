package com.example.demo.wechat.lbs;

import java.io.Serializable;
/**
 * @author minyi
 * @see
 * 位置描述
 */
public class LBSResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long status;
	
	private String message;
	
	private LBSResult result;
	
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LBSResult getResult() {
		return result;
	}
	public void setResult(LBSResult result) {
		this.result = result;
	}
    
}
