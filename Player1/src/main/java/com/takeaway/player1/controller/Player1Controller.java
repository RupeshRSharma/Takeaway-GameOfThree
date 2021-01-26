package com.takeaway.player1.controller;

import com.takeaway.player1.constant.EndpointConstants;
import com.takeaway.player1.exception.Player1Exception;
import com.takeaway.player1.response.Player1Response;
import com.takeaway.player1.service.Player1Service;
import com.takeaway.player1.util.CommonUtil;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Player1 service endpoints.
 * <p>
 * 1. /1.0/player1/play?number={number}:GET - Play with the given number
 * </p>
 */
@RestController
@RequestMapping(EndpointConstants.BASE_V1_API + EndpointConstants.PLAYER1)
@Log4j2
@AllArgsConstructor
@Validated
public class Player1Controller {

	// Player1 service
	private final Player1Service player1Service;

	/**
	 * Play with the given number.
	 *
	 * @param number Input number
	 * @return Empty Response with Http status 200
	 * @throws Player1Exception Any exception
	 */
	@GetMapping(EndpointConstants.PLAY)
	public ResponseEntity<Player1Response<Void>> play(@RequestParam(name = "number", required = false) @Min(value = 2, message = "Number should be greater than 1.") Integer number) throws Player1Exception {

		log.info("Player1 received number {} to play with.", number);

		player1Service.play(number);

		return ResponseEntity.ok(CommonUtil.generateSuccessResponse());
	}

}
