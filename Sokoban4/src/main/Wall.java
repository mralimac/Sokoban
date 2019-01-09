package main;

import javafx.scene.image.Image;

public class Wall extends Tile
{

	//Constructor Section
	public Wall(int xCoord, int yCoord) {
		super(xCoord, yCoord, new Image("assets/Wall.png", 100, 100, false, false), "Wall");
		setXCoord(xCoord);
		setYCoord(yCoord);
		setImage(new Image("assets/Wall.png", 100, 100, false, false));
		getRect().setId("Wall");
	}
	//End Constructor
}
