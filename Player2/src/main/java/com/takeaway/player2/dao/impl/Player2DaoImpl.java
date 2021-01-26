package com.takeaway.player2.dao.impl;

import com.takeaway.player2.constant.EndpointConstants;
import com.takeaway.player2.dao.Player2Dao;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * DAO implementation of Player2 DAO
 */
@Service
@AllArgsConstructor
@Log4j2
public class Player2DaoImpl implements Player2Dao {

	// Web client for Player1
	private final WebClient webClientPlayer1;

	/**
	 * Play with the number
	 *
	 * @param number Input number
	 *
	 */
	@Override
	public void play(Integer number) {

		log.info("Sending number {} to Player1", number);

		webClientPlayer1
				.get()
				.uri(uriBuilder -> uriBuilder.path(EndpointConstants.PLAY).queryParam("number", number).build())
				.retrieve()
				.bodyToMono(Void.class).subscribe();
	}
}
