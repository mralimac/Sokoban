package main;

public class Floor extends Tile
{
	
	//Constructor Section
	public Floor(int xCoord, int yCoord) {
		super(xCoord, yCoord,"assets/Tile.png", "Floor");
		getRect().toBack();
	}

	//Added this to solve a small issue
	//Update: This issue was resolved properly, but it is a example of overloading so it stays
	public Floor(int xCoord, int yCoord, String tileName) {
		super(xCoord, yCoord, "assets/Tile.png", "Floor");
		getRect().toBack();
	}
	//End Constructor
	

	
}
