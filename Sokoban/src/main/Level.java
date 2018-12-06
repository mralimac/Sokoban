package main;

public class Level 
{
	//Attributes
	private int levelNumber;
	private int gridWidth;
	private int gridHeight;
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
	public void displayGrid()
	{
		
	}
	//End Methods
}
