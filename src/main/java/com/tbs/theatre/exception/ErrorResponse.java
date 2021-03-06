package com.tbs.theatre.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private HttpStatus status;
	private String message;
	private Instant timestamp;

	public ErrorResponse(HttpStatus status, String message, Instant timestamp) {
	        this.status= status;
	        this.message = message;
	        this.timestamp = timestamp;
	    }

	public HttpStatus getStatus() {
		return this.status;
	}

	public String getMessage() {
		return this.message;
	}

	public Instant getTimestamp() {
		return this.timestamp;
	}

}
