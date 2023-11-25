package com.CoderTanu.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND)
public class ResourcsNotFoundException  extends RuntimeException{
	
	public ResourcsNotFoundException(String message) {
		super(message);
	}

}
