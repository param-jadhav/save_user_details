package com.myorg.spring.useraction.api.exception;

import lombok.Data;

@Data
public class CustomResponse {

	private int responseCode;
	private String message;
	private String details;
	public CustomResponse(int responseCode, String message, String details) {
		this.responseCode = responseCode;
		this.message = message;
		this.details = details;
	}

}
