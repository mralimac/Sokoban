package main;

import javafx.scene.image.Image;

public class Floor extends Tile
{
	
	//Constructor Section
	public Floor(int xCoord, int yCoord) {
		super(xCoord, yCoord, new Image("assets/Tile.png", 100, 100, false, false), "Floor");
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		//this.tileImage = new Image("assets/Tile.png", 100, 100, false, false);
		rectangle.setId("Floor");
		rectangle.toBack();
	}

	//Added this to solve a small issue
	//Update: This issue was resolved properly, but it is a example of overloading so it stays
	public Floor(int xCoord, int yCoord, String tileName) {
		super(xCoord, yCoord, new Image("assets/Tile.png", 100, 100, false, false), "Floor");
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.tileImage = new Image("assets/Tile.png", 100, 100, false, false);
		rectangle.setId(tileName);
		rectangle.toBack();
	}
	//End Constructor
}
