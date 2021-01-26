package com.takeaway.player2.service;

import com.takeaway.player2.dao.Player2Dao;
import com.takeaway.player2.service.impl.Player2ServiceImpl;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Test class for Player2 service
 */
public class Player2ServiceTest {

	@InjectMocks // Inject Player2 service to be tested
	private Player2ServiceImpl player2Service;

	@Mock // Mock Player2 dao
	private Player2Dao player2Dao;

	/**
	 * Initialize setup before tests.
	 */
	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test play
	 * @throws Exception MVC exception
	 */
	@Test
	private void play() throws Exception {

		// Mock service call
		Mockito.doNothing().when(player2Dao).play(ArgumentMatchers.anyInt());

		// execute request
		player2Service.play(10);

	}

}
