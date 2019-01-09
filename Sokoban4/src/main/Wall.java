package main;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class Wall extends Tile
{

	//Constructor Section
	public Wall(int xCoord, int yCoord, GridPane grid) {
		super(xCoord, yCoord, new Image("assets/Wall.png", 100, 100, false, false), "Wall" , grid);
		setTileXCoord(xCoord);
		setTileYCoord(yCoord);
		setTileImage(new Image("assets/Wall.png", 100, 100, false, false));
		setTileType("Wall");
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
