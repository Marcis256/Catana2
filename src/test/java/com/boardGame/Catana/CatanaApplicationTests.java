package com.boardGame.Catana;

import com.boardGame.Catana.controller.GameController;
import com.boardGame.Catana.model.Player;
import com.boardGame.Catana.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CatanaApplicationTests {
	@Mock
	private PlayerService playerService;

	@InjectMocks
	private GameController gameController;

	@Test
	public void testCreateNewPlayer() throws Exception {
		// Create a sample player
		Player player = new Player();
		player.setId(1L);
		player.setName("John");

		// Mock the playerService behavior
		when(playerService.createNewPlayer(any(Player.class))).thenReturn(player);

		// Call the controller method
		Player createdPlayer = gameController.createNewPlayer(player);

		// Verify that the playerService.createNewPlayer method was called with the correct argument
		verify(playerService).createNewPlayer(player);

		// Verify that the returned player object is the same as the one returned by the playerService
		assertEquals(player, createdPlayer);
	}

}
