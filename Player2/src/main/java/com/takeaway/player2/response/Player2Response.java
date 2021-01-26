package com.takeaway.player2.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.takeaway.player2.constant.StatusEnum;
import com.takeaway.player2.exception.Error;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response class for Player2Response services.
 * @param <T>
 *          the type parameter
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Getter
@Setter
public class Player2Response<T> {

	/**
	 * Instantiates a new Response with given data.
	 * @param data
	 *          the data
	 */
	public Player2Response(T data) {
		this.setData(data);
	}

	/**
	 * The Status.
	 */
	private StatusEnum status;

	/**
	 * The Errors.
	 */
	private List<Error> errors = new ArrayList<>();

	/**
	 * The data
	 */
	private T data;

	/**
	 * Add error to response
	 * @param error
	 */
	public void addError(Error error) {
		this.errors.add(error);
	}

}

