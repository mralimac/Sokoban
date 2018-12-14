package main;

import javafx.scene.image.Image;

public class Wall extends Tile
{

	public Wall(int xCoord, int yCoord) {
		super(xCoord, yCoord);
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.tileImage = new Image("assets/Wall.png", 100, 100, false, false);
	}

}
