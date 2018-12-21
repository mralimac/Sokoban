package main;

import javafx.scene.image.Image;

public class Floor extends Tile{

	public Floor(int xCoord, int yCoord) {
		super(xCoord, yCoord, new Image("assets/Tile.png", 100, 100, false, false), "Floor");
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.tileImage = new Image("assets/Tile.png", 100, 100, false, false);
		rectangle.setId("Floor");
		rectangle.toBack();
	}
	
	//Added this to solve a small issue
	public Floor(int xCoord, int yCoord, String tileName) {
		super(xCoord, yCoord, new Image("assets/Tile.png", 100, 100, false, false), "Floor");
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.tileImage = new Image("assets/Tile.png", 100, 100, false, false);
		rectangle.setId(tileName);
		rectangle.toBack();
	}
	
}
