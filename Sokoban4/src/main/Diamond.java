package main;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class Diamond extends Tile
{
	//Constructor Section
	public Diamond(int xCoord, int yCoord, GridPane grid) {
		super(xCoord, yCoord, new Image("assets/Diamond.png", 100, 100, false, false), "Diamond", grid);

	}
	//End Constructor	

}

