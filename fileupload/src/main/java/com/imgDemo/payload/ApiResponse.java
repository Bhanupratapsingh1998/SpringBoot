package com.imgDemo.payload;

public class ApiResponse {
	private int status_code;
	private String message;

	public int getStatus_code() {
		return status_code;
	}

	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ApiResponse() {
		super();
	}

	public ApiResponse( int status_code,String message) {
		super();
		this.status_code = status_code;
		this.message = message;
	}

}
