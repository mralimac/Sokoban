package main;

import javafx.scene.image.Image;

//This is used to force all tiles to conform to a minimum of methods
public interface TilePlacement {
	public void setTileImage(Image tileImage);
	public void setTileType(String tileType);
	public void setTileXCoord(int xCoord);
	public void setTileYCoord(int yCoord);
}
