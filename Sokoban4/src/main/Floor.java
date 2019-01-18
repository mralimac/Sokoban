package main;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class Floor extends Tile
{
	
	//Constructor Section
	public Floor(int xCoord, int yCoord, GridPane grid) {
		super(xCoord, yCoord, new Image("assets/Tile.png", 100, 100, false, false), "Floor", grid);
		getRect().toBack();
	}

	//Added this to solve a small issue
	//Update: This issue was resolved properly, but it is a example of overloading so it stays
	public Floor(int xCoord, int yCoord, String tileName, GridPane grid) {
		super(xCoord, yCoord, new Image("assets/Tile.png", 100, 100, false, false), "Floor", grid);
		getRect().toBack();
	}
	//End Constructor

}
