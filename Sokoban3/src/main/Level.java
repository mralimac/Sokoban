package main;

import java.util.ArrayList;



public class Level 
{
	//Attributes
	private int levelNumber;
	private int gridWidth;
	private int gridHeight;
	private ArrayList<Tile> listOfTiles = new ArrayList<Tile>();
	//End Attributes
	
	//Constructors
	public Level()
	{
		this.levelNumber = 0;
		this.gridWidth = 10;
		this.gridHeight = 10;
	}
	
	public Level(int levelNumber, int gridWidth, int gridHeight)
	{
		this.levelNumber = levelNumber;
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
	}
	//End Constructors
	
	//Methods
	//Gets level file
	public void getLevelFile(int levelNumber)
	{
		
	}
	
	
	//Build the grid
	public void buildGrid()
	{
		for(int yCoord = 0; yCoord < this.gridHeight; yCoord++)
		{			
			for(int xCoord = 0; xCoord < this.gridWidth; xCoord++)
			{
				
				Tile newTile = new Tile(xCoord, yCoord, 1);
				System.out.println("Create new tile");
				listOfTiles.add(newTile);				
			}
		}
	}
	
	
	//End Methods
}
