package com.afour.recruitment.exception;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class RequirementExceptionHandler {
	UUID uuid = UUID.randomUUID();

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	ErrorMessage numberFormatException(NumberFormatException e) {
		return new ErrorMessage(uuid.toString(), HttpStatus.BAD_REQUEST.toString(), e.getMessage());
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler
	ErrorMessage entityNotFoundException(EntityNotFoundException e) {
		return new ErrorMessage(uuid.toString(), HttpStatus.NOT_FOUND.toString(), e.getMessage());
	}


	@ResponseBody
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler
	ErrorMessage httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		return new ErrorMessage(uuid.toString(), HttpStatus.METHOD_NOT_ALLOWED.toString(), e.getMessage());
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler
	ErrorMessage responseStatusException(ResponseStatusException e) {
		return new ErrorMessage(uuid.toString(), HttpStatus.NO_CONTENT.toString(), e.getMessage());
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody ErrorMessage handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		return new ErrorMessage(uuid.toString(), HttpStatus.CONFLICT.toString(), ex.getMessage());
	}

	
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	ErrorMessage exceptionHandler(Exception e) {
		return new ErrorMessage(uuid.toString(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage());
	}
	
}
