package main;

import javafx.scene.image.Image;


public class Crate extends MoveableTile
{
	//Constructor Section
	public Crate(int xCoord, int yCoord)
	{
		super(xCoord, yCoord, new Image("assets/Crate.png", 100, 100, false, false), "Crate");
		setXCoord(xCoord);
		setYCoord(yCoord);
		
		setImage(new Image("assets/Crate.png", 100, 100, false, false));
		getRect().setId("Crate");
	}
	//End Constructor
}
