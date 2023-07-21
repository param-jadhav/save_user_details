package com.myorg.spring.useraction.api.exception;

public class CustomResponse {

	private int responseCode;
	private String message;
	private String details;
	public CustomResponse(int responseCode, String message, String details) {
		this.responseCode = responseCode;
		this.message = message;
		this.details = details;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	@Override
	public String toString() {
		return "CustomResponse [responseCode=" + responseCode + ", message=" + message + ", details=" + details + "]";
	}
	

}
