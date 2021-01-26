package com.takeaway.player2.util;

import com.takeaway.player2.constant.StatusEnum;
import com.takeaway.player2.response.Player2Response;
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
	public static <T> Player2Response<T> generateSuccessResponse(T data) {
		Player2Response<T> response = generateSuccessResponse();
		response.setData(data);
		return response;

	}

	/**
	 * Generate success response response.
	 * @param <T>
	 *          the type parameter
	 * @return the response
	 */
	public static <T> Player2Response<T> generateSuccessResponse() {
		Player2Response<T> response = new Player2Response<>();
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

