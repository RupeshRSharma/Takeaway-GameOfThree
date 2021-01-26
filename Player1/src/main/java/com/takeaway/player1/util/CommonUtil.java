package com.takeaway.player1.util;

import com.takeaway.player1.constant.StatusEnum;
import com.takeaway.player1.response.Player1Response;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class that will have static utility methods
 */

public class CommonUtil {

	/**
	 * Generate success response response.
	 * @param <T>
	 *          the type parameter
	 * @param data
	 *          the data
	 * @return the response
	 */
	public static <T> Player1Response<T> generateSuccessResponse(T data) {
		Player1Response<T> response = generateSuccessResponse();
		response.setData(data);
		return response;

	}

	/**
	 * Generate success response response.
	 * @param <T>
	 *          the type parameter
	 * @return the response
	 */
	public static <T> Player1Response<T> generateSuccessResponse() {
		Player1Response<T> response = new Player1Response<>();
		response.setStatus(StatusEnum.SUCCESS);
		return response;

	}

	/**
	 * Generate random integer
	 * @return random integer
	 */
	public static int generateRandomNumber(){
		return ThreadLocalRandom.current().nextInt(2, Integer.MAX_VALUE);
	}

}

