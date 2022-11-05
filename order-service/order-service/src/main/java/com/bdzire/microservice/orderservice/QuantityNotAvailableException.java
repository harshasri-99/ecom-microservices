package com.bdzire.microservice.orderservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class QuantityNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public QuantityNotAvailableException(String message) {
		super(message);
	}
}
