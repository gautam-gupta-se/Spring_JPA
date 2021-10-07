package com.gautam.irs.exception;


/**
 * All other user defined exception classes will inherit this exception class.
 *
 */
public class HappyGoException extends Exception {
	private static final long serialVersionUID = 1L;
	public HappyGoException(String message) {
		super(message);
	}
}
