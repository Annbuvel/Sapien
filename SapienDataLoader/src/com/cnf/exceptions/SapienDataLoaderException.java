package com.cnf.exceptions;

public class SapienDataLoaderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4108028478135923281L;
	
	private String exceptionMessage;
	
	
	public String getExceptionMessage() {
		return exceptionMessage;
	}


	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}


	public SapienDataLoaderException(String message)
	{
		this.setExceptionMessage(message);
	}
	
	

}
