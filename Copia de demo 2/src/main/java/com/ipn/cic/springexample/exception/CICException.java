package com.ipn.cic.springexample.exception;

public class CICException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public CICException(String messageString) {
		super(messageString);
	}

}
