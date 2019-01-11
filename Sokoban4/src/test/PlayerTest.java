package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.scene.layout.GridPane;
import main.Player;

class PlayerTest {

	@Test
	void createPlayer() {
		GridPane grid = new GridPane();
		Player newPlayer = new Player(0, 0, grid);
		assertEquals(0, newPlayer.getXCoord(), "getXCoord should equal zero");
		assertEquals(0, newPlayer.getYCoord(), "getYCoord should equal zero");
	}

}
