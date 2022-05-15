/**
 * 
 */
package com.praroopgupta.wordgeneration.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.praroopgupta.wordgeneration.model.ErrorResponse;

/**
 * @author Praroop Gupta
 *
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { WordsNotFoundException.class })
	protected ResponseEntity<Object> handleWordsNotFoundException(WordsNotFoundException ex, WebRequest request) {
		ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage());
		return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(value = { IllegalArgumentException.class })
	protected ResponseEntity<Object> handleException(IllegalArgumentException ex, WebRequest request) {
		ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage());
		return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
		ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage());
		return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
