package main;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;


public class Crate extends MoveableTile
{
	//Constructor Section
	public Crate(int xCoord, int yCoord, GridPane grid)
	{
		super(xCoord, yCoord, new Image("assets/Crate.png", 100, 100, false, false), "Crate", grid);
	}
	//End Constructor


}
