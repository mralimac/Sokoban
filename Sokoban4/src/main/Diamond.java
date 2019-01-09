package main;

import javafx.scene.image.Image;

public class Diamond extends Tile
{
	//Constructor Section
	public Diamond(int xCoord, int yCoord) {
		super(xCoord, yCoord, new Image("assets/Diamond.png", 100, 100, false, false), "Diamond");
		setXCoord(xCoord);
		setYCoord(yCoord);
		getRect().setId("Diamond");
	}
	//End Constructor
}

