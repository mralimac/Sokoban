package main;

import javafx.scene.image.Image;

public class Player extends MoveableTile
{

	public Player(int xCoord, int yCoord) {
		super(xCoord, yCoord);
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.tileImage = new Image("assets/Player.png", 100, 100, false, false);
	}

}
