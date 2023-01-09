package com.example.h2.exception;

public class ErrorResponse{

private  String message;	
private int statusCode;

public ErrorResponse(String message) {
	super();
	this.message = message;
}

public ErrorResponse(String message, int statusCode) {
	super();
	this.message = message;
	this.statusCode = statusCode;
}

public int getStatusCode() {
	return statusCode;
}

public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}



}
