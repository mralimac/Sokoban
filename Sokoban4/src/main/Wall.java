package main;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class Wall extends Tile
{

	//Constructor Section
	public Wall(int xCoord, int yCoord, GridPane grid) {
		super(xCoord, yCoord, new Image("assets/Wall.png", 100, 100, false, false), "Wall" , grid);
	}
	//End Constructor

}
