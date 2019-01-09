package main;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class Diamond extends Tile
{
	//Constructor Section
	public Diamond(int xCoord, int yCoord, GridPane grid) {
		super(xCoord, yCoord, new Image("assets/Diamond.png", 100, 100, false, false), "Diamond", grid);
		setTileXCoord(xCoord);
		setTileYCoord(yCoord);
		setTileType("Diamond");
		setTileImage(new Image("assets/Diamond.png", 100, 100, false, false));
	}
	//End Constructor	

	@Override
	public void setTileImage(Image tileImage) {
		setImage(tileImage);
	}

	@Override
	public void setTileType(String tileType) {
		getRect().setId(tileType);
		
	}

	@Override
	public void setTileXCoord(int xCoord) {
		setXCoord(xCoord);
		
	}

	@Override
	public void setTileYCoord(int yCoord) {
		setYCoord(yCoord);
		
	}
}

