package com.takeaway.player2.controller;

import com.takeaway.player2.constant.EndpointConstants;
import com.takeaway.player2.exception.Player2Exception;
import com.takeaway.player2.response.Player2Response;
import com.takeaway.player2.service.Player2Service;
import com.takeaway.player2.util.CommonUtil;
import javax.validation.Valid;
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
 * Controller for Player2 service endpoints.
 * <p>
 * 1. /1.0/player2/play?number={number}:GET - Play with the given number
 * </p>
 */
@RestController
@RequestMapping(EndpointConstants.BASE_V1_API + EndpointConstants.PLAYER2)
@Log4j2
@AllArgsConstructor
@Validated
public class Player2Controller {

	// Player2 service
	private final Player2Service player2Service;

	/**
	 * Play with the given number.
	 *
	 * @param number Input number
	 * @return Empty Response with Http status 200
	 * @throws Player2Exception Any exception
	 */
	@GetMapping(EndpointConstants.PLAY)
	public ResponseEntity<Player2Response<Void>> play(@RequestParam(name = "number", required = false) @Min(value = 2, message = "Number should be greater than 1.") Integer number) throws Player2Exception {

		log.info("Player2 received number {} to play with.", number);

		player2Service.play(number);

		return ResponseEntity.ok(CommonUtil.generateSuccessResponse());
	}

}
