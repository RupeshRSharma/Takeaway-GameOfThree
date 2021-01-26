package com.takeaway.player2.exception;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * Exception for Player2 services
 */
@Getter
public class Player2Exception extends Exception {

	// Error code
	private final String errorCode;

	// Errors
	private List<Error> errors = new ArrayList();

	public Player2Exception(String errorCode) {
		this.errorCode = errorCode;
	}

	public Player2Exception(String errorCode, List<Error> errors) {
		this.errorCode = errorCode;
		this.errors = errors;
	}

	public Player2Exception(String errorCode, String args) {
		super(args);
		this.errorCode = errorCode;
	}

	public Player2Exception(String errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public Player2Exception(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

}
