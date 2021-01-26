package com.takeaway.player2.advice;

import com.takeaway.player2.constant.StatusEnum;
import com.takeaway.player2.exception.Error;
import com.takeaway.player2.exception.ErrorCodes;
import com.takeaway.player2.exception.Player2Exception;
import com.takeaway.player2.response.Player2Response;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception handler for Player2Controller.
 */
@ControllerAdvice
@Log4j2
@AllArgsConstructor
public class Player2ControllerAdvice {

	private final ErrorCodes errorCodes; // Error codes

	/**
	 * Handle Player2Exception, return Http status 200 OK with error details.
	 * @param exception
	 *          {@link Player2Exception}
	 * @return Response entity with Http status 200 OK and error details
	 */
	@ExceptionHandler(Player2Exception.class)
	ResponseEntity<Player2Response> handlePlayer2Exception(Player2Exception exception){

		Player2Response response = new Player2Response();
		response.setStatus(StatusEnum.FAILURE);
		response.addError(errorCodes.getError(exception.getErrorCode()));

		log.error("Player1 Exception Occurred:", exception);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Handle validation exceptions response entity.
	 * @param ex
	 *          the ex
	 * @return the response entity
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Player2Response<Object>> handleValidationExceptions(ConstraintViolationException ex) {

		Player2Response<Object> responseObject = new Player2Response<>();
		List<String> errors = new ArrayList<>();
		responseObject.setStatus(StatusEnum.FAILURE);
		ex.getConstraintViolations().forEach(error -> errors.add(error.getMessage()));

		populateResponseError(responseObject,
				"Request validation failed :" + errors.toString(), "P1S101", Error.SeverityEnum.FATAL);

		log.error("Request validation failed :", ex);
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}

	/**
	 * Populate response error.
	 * @param <T>
	 *          the type parameter
	 * @param response
	 *          the response
	 * @param errorMessage
	 *          the error message
	 * @param errorCode
	 *          the error code
	 * @param severity
	 *          the severity
	 */
	private <T extends Player2Response> void populateResponseError(T response, String errorMessage,
																   String errorCode, Error.SeverityEnum severity) {
		Error error = new Error();
		error.setCode(errorCode);
		error.setMessage(errorMessage);
		error.setSeverity(severity);
		response.getErrors().add(error);
	}


}