package com.takeaway.player2.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Exception codes for Player2 service
 */
@AllArgsConstructor
@Getter
public enum Player2ExceptionCode {

	// Invalid number present in the request
	INVALID_NUMBER("P2S_101");

	// Exception code
	private final String code;

}
