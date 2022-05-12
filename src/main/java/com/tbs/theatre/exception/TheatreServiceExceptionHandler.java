package com.tbs.theatre.exception;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TheatreServiceExceptionHandler {

	@ExceptionHandler({ TheatreServiceException.class })
    protected ResponseEntity<ErrorResponse> handleApiException(TheatreServiceException ex) {
		return new ResponseEntity<>(new ErrorResponse(ex.getStatus(), ex.getMessage(), Instant.now()), ex.getStatus());
    }
	
}
