package main;

import javafx.scene.image.Image;

public abstract class Tile extends Coords{
	
	private Image tileImage;
	
	public Tile(int xCoord, int yCoord)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
}
