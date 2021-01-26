package com.takeaway.player1.service;

import com.takeaway.player1.dao.Player1Dao;
import com.takeaway.player1.service.impl.Player1ServiceImpl;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Test class for Player1 service
 */
@RunWith(MockitoJUnitRunner.class)
public class Player1ServiceTest {

	@InjectMocks // Inject Player1 service to be tested
	private Player1ServiceImpl player1Service;

	@Mock // Mock player1 dao
	private Player1Dao player1Dao;

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
	public void play() throws Exception {

		// Mock service call
		Mockito.doNothing().when(player1Dao).play(ArgumentMatchers.anyInt());

		// execute request
		player1Service.play(10);

	}

}
