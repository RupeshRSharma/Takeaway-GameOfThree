package com.takeaway.player2.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.takeaway.player2.constant.StatusEnum;
import com.takeaway.player2.response.Player2Response;
import com.takeaway.player2.service.Player2Service;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * test class for Player2 controller
 */
public class Player2ControllerTest {

	// Play URI
	private static final String PLAY_URI = "/1.0/player2/play?number=9";

	@Mock // Mock player2 service
	private Player2Service player2Service;

	private MockMvc mvc;

	/**
	 * Initialize setup before tests.
	 */
	@BeforeClass
	public void setUp() {

		MockitoAnnotations.initMocks(this);

		final Player2Controller controller = new Player2Controller(player2Service);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	/**
	 * Test play
	 * @throws Exception MVC exception
	 */
	@Test
	public void play() throws Exception {

		// Mock service call
		Mockito.doNothing().when(player2Service).play(ArgumentMatchers.anyInt());

		// Execute the request
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(PLAY_URI).contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		// getting response body as JSON
		Player2Response response = mapFromJson(mvcResult.getResponse().getContentAsString(), Player2Response.class);

		// assertions on response
		Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
		Assertions.assertTrue(response.getStatus().equals(StatusEnum.SUCCESS));

	}

	/**
	 * Map from json t.
	 * @param <T>
	 *          the type parameter
	 * @param json
	 *          the json
	 * @param clazz
	 *          the clazz
	 * @return the t
	 * @throws JsonMappingException
	 *           the json mapping exception
	 * @throws IOException
	 *           the io exception
	 */
	private  <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

}
