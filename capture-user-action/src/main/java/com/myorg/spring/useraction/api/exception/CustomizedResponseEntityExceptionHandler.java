package com.myorg.spring.useraction.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler
		extends
			ResponseEntityExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<CustomResponse> handleUserNotFoundException(
			UserNotFoundException ex, WebRequest request) {
		CustomResponse response = new CustomResponse(1111, ex.getMessage(),
				"please enter correct address");
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<CustomResponse> handleAllExceptions(
			Exception ex, WebRequest request) {
		CustomResponse response = new CustomResponse(111, ex.getMessage(),
				"excception");
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
