package com.iktpreobuka.serialization.controllers;

public class RESTEror {
	
	private Integer code;
	private String message;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public RESTEror(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public RESTEror() {
		super();
		// TODO Auto-generated constructor stub
	}

}
