package com.takeaway.player1.dao.impl;

import com.takeaway.player1.constant.EndpointConstants;
import com.takeaway.player1.dao.Player1Dao;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import lombok.AllArgsConstructor;

/**
 * DAO implementation of Player1 DAO
 */
@Service
@Log4j2
@AllArgsConstructor
public class Player1DaoImpl implements Player1Dao {

	// Web client for Player2
	private final WebClient webClientPlayer2;

	/**
	 * Play with the number
	 *
	 * @param number Input number
	 *
	 */
	@Override
	public void play(Integer number) {

		log.info("Sending number {} to Player 2", number);

		webClientPlayer2
				.get()
				.uri(uriBuilder -> uriBuilder.path(EndpointConstants.PLAY).queryParam("number", number).build())
				.retrieve()
				.bodyToMono(Void.class).subscribe();

	}

}
