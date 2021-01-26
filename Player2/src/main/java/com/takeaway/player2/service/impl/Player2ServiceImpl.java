package com.takeaway.player2.service.impl;

import com.takeaway.player2.dao.Player2Dao;
import com.takeaway.player2.service.Player2Service;
import com.takeaway.player2.util.CommonUtil;
import java.util.Objects;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

/**
 * Service class for Player2.
 */
@Service
@AllArgsConstructor
@Log4j2
public class Player2ServiceImpl implements Player2Service {

	// Player2 DAO
	private final Player2Dao player2Dao;

	/**
	 * Play with the given number
	 *
	 * @param number Input number
	 */
	@Override
	public void play(Integer number) {

		// If no number is present in request, generate a random number and start the play
		if(Objects.isNull(number)){
			player2Dao.play(CommonUtil.generateRandomNumber());
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
				log.info("Sending number {} to Player 1", number);
				player2Dao.play(number);
			}
		}

	}
}
