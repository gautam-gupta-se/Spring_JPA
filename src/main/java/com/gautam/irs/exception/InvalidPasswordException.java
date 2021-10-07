package com.gautam.irs.exception;
public class InvalidPasswordException extends HappyGoException {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * This Exception is thrown from RegistrationService class with error message
	 * RegistrationService.INVALID_PASSWORD if the given password is not matching
	 * the constraints given in the regular expression.
	 * 
	 * 
	 *
	 */
	public InvalidPasswordException(String message) {
		super(message);
	}
}
