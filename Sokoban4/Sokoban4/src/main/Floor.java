package main;

import javafx.scene.image.Image;

//In a way, Floor, Player, Wall, Crate and Diamond are examples of aggregation
//They are all connected via Tile and MoveableTile but are otherwise, totally seperate
//from each other therefore not requiring each other to survive
public class Floor extends Tile
{
	
	//Constructor Section	
	public Floor(int xCoord, int yCoord) {
		super(xCoord, yCoord, new Image("assets/Tile.png", 100, 100, false, false), "Floor");
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		//this.tileImage = new Image("assets/Tile.png", 100, 100, false, false);
		getRect().setId("Floor");
		getRect().toBack();
	}

	//This overloaded constructor is here to avoid a null tile being generated if the level data file is incorrect
	public Floor(int xCoord, int yCoord, String tileName) {
		super(xCoord, yCoord, new Image("assets/Tile.png", 100, 100, false, false), "BlankTile");
		this.xCoord = xCoord;
		this.yCoord = yCoord;		
		getRect().setId(tileName);
		getRect().toBack();
	}
	//End Constructor
}
