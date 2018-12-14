package main;

import javafx.scene.image.Image;

public class Diamond extends Tile
{

	public Diamond(int xCoord, int yCoord) {
		super(xCoord, yCoord, new Image("assets/Diamond.png", 100, 100, false, false), "Diamond");
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		rectangle.setId("Diamond");
	}

}

