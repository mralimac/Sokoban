package main;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;


public class Crate extends MoveableTile
{
	//Constructor Section
	public Crate(int xCoord, int yCoord, GridPane grid)
	{
		super(xCoord, yCoord, new Image("assets/Crate.png", 100, 100, false, false), "Crate", grid);
		setTileXCoord(xCoord);
		setTileYCoord(yCoord);		
		setTileImage(new Image("assets/Crate.png", 100, 100, false, false));
		setTileType("Crate");
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
