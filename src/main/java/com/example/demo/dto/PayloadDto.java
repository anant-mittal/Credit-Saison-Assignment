package com.example.demo.dto;

import java.io.Serializable;

public class PayloadDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String scheme;
	private String type;
	private String bank;
	
	
	public PayloadDto(String scheme, String type, String bank) {
		super();
		this.scheme = scheme;
		this.type = type;
		this.bank = bank;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	

}
