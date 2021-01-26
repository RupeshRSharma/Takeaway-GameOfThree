package com.takeaway.player1.service.impl;

import com.takeaway.player1.dao.Player1Dao;
import com.takeaway.player1.service.Player1Service;
import com.takeaway.player1.util.CommonUtil;
import java.util.Objects;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

/**
 * Service class for Player1.
 */
@Service
@AllArgsConstructor
@Log4j2
public class Player1ServiceImpl implements Player1Service {

	// Player2 DAO
	private final Player1Dao player1Dao;

	/**
	 * Play with the given number.
	 * If no number is present in request, generate a random number and start the play.
	 *
	 * @param number Input number
	 */
	@Override
	public void play(Integer number) {

		// If no number is present in request, generate a random number and start the play
		if(Objects.isNull(number)){
			player1Dao.play(CommonUtil.generateRandomNumber());
		}else{

			// If number+1 or number-1 is divisible by 3, then this is the new number
			if((number+1)%3 == 0){
				log.info("Adding +1 to the number received {}", number);
				++number;
			}else if((number-1)%3 == 0){
				log.info("Adding -1 to the number received {}", number);
				--number;
			}

			// divide the number by 3
			number /= 3;

			// if number is 3, then Player wins, else send the number to other player
			if(number == 1){
				log.info("Player1 Wins!!");
			}else{
				log.info("Sending number {} to Player 2", number);
				player1Dao.play(number);
			}
		}

	}
}
