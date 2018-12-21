package main;

import javafx.scene.image.Image;


public class Crate extends MoveableTile
{
	
	
	public Crate(int xCoord, int yCoord)
	{
		super(xCoord, yCoord, new Image("assets/Crate.png", 100, 100, false, false), "Crate");
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		
		this.tileImage = new Image("assets/Crate.png", 100, 100, false, false);
		rectangle.setId("Crate");
		
		
	}
}
