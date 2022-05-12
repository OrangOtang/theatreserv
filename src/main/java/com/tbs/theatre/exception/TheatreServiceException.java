package com.tbs.theatre.exception;

import org.springframework.http.HttpStatus;

public class TheatreServiceException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus status;

    public TheatreServiceException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
	
	

}
