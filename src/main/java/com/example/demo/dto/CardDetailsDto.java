package com.example.demo.dto;

import java.io.Serializable;

public class CardDetailsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String scheme;
	private String type;
	private BankDto bank;
	
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
	public BankDto getBank() {
		return bank;
	}
	public void setBank(BankDto bank) {
		this.bank = bank;
	}
	
	

}
