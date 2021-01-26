package com.takeaway.player1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Exception codes for Player1 service
 */
@AllArgsConstructor
@Getter
public enum Player1ExceptionCode {

	// Invalid number present in the request
	INVALID_NUMBER("P1S_101");

	// Exception code
	private final String code;

}
