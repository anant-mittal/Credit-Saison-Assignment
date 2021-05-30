package com.example.demo.dto;

import java.io.Serializable;

public class CardInfoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Boolean success;
	private PayloadDto payload;
	
	public CardInfoDto(Boolean success, PayloadDto payload) {
		super();
		this.success = success;
		this.payload = payload;
	}
	
	
	public CardInfoDto() {
		super();
	}


	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public PayloadDto getPayload() {
		return payload;
	}
	public void setPayload(PayloadDto payload) {
		this.payload = payload;
	}
	
	

}
