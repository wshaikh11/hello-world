package com.afour.recruitment.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage 
{
	String requestID;
	String type;
	String message;
}
