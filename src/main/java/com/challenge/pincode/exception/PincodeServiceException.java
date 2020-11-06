package com.challenge.pincode.exception;


public class PincodeServiceException extends Exception{

	String message;
	String details;
	
	private static final long serialVersionUID = 1L;

	
	public PincodeServiceException() {
		super();
	}
	
	public PincodeServiceException(String msg){
		this.message=msg;
	}
	
	public PincodeServiceException(String msg,String details){
		this.message=msg;
		this.details= details;
	}
	
}
