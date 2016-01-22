package com.cnf.exceptions;

public class SapienDataLoaderDataException extends SapienDataLoaderException{

	
	String exceptionMessage;
	
	public SapienDataLoaderDataException(String message) {
		super(message);
		this.exceptionMessage = message;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.exceptionMessage;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8611049865475234882L;

}
