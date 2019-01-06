package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Level implements GUI{
	
	//Attributes Section
	//private int levelNumber;
	private int levelNumber;
	private Player thePlayer;
	private ArrayList<Tile> listOfTiles = new ArrayList<Tile>(); //This array of tiles holds multiple different objects, therefore making it polymorphic
	private ArrayList<String> listOfLines = new ArrayList<String>();
	//End Attributes
	
	//Constructor Section
	public Level(int levelNumber) throws IOException
	{
		this.levelNumber = levelNumber;
		loadLevel(levelNumber);
	}
	//End Constructor
	
	//Method Section
	
	//Returns the level width in pixels
	public int getLevelWidth()
	{
		return this.listOfLines.get(1).length() *  50;
	}
	
	//Returns the level height in pixels
	public int getLevelHeight()
	{
		return this.listOfLines.size() * 50 +40;
	}
	
	//Loads the level by reading the file and calling the buildObjects method
	private void loadLevel(int levelNumber) throws IOException
	{
		String filePath = getFilePath(levelNumber);
		try {
			FileReader file = new FileReader(filePath);
			BufferedReader bufferedFile = new BufferedReader(file);

			
			String lineFromFile = bufferedFile.readLine();
			while(lineFromFile != null)
			{
				listOfLines.add(lineFromFile);
				lineFromFile = bufferedFile.readLine();
			}
			
			buildObjects();
			bufferedFile.close();
			
		} catch (FileNotFoundException e) {
			//If file is not found, this exception is thrown. An example of exception handling
			System.out.println("Warning! File not Found");
			e.printStackTrace();
		}
	}
	
	//This method builds the level by reading the file and adding the object relevant to the character in the file
	private void buildObjects()
	{
		int xCoord = 0;
		int yCoord = 0;
		
		for(int i = 0; i < listOfLines.size(); i++)
		{
			xCoord = 0;
			String currentLine = listOfLines.get(i);			
			for(int e = 0; e < currentLine.length(); e++)
			{
				String currentchar = currentLine.substring(e, e+1);
				
				switch(currentchar)
				{
				case " ": listOfTiles.add(new Floor(xCoord,yCoord));					
				break;
				
				case "*": Crate crate = new Crate(xCoord, yCoord);
				listOfTiles.add(crate);
				winHandler.addCrate(crate);
				break;
				
				case "@": Player thePlayer = new Player(xCoord,yCoord);
				listOfTiles.add(thePlayer);
				this.thePlayer = thePlayer;
				break;
				
				case "X": listOfTiles.add(new Wall(xCoord,yCoord));					
				break;
				
				case ".": Diamond diamond = new Diamond(xCoord, yCoord); 
				winHandler.addDiamond(diamond);
				listOfTiles.add(diamond);
				break;
				
				default: listOfTiles.add(new Floor(xCoord, yCoord, "BlankTile"));
				}
				xCoord++;
			}			
			

			yCoord++;
		}
	}
	
	//This method returns the current level number. An example of encapsulation
	public int getLevelNumber()
	{
		return this.levelNumber;
	}
	
	//This method return the player object. An example of encapsulation
	public Player getPlayer()
	{
		return this.thePlayer;
	}
	
	//This method gets the filepath for a file
	public String getFilePath(int levelNumber)
	{
		switch(levelNumber)
		{
		case 1: return "src/levels/level1.txt";
		case 2: return "src/levels/level2.txt";
		case 3: return "src/levels/level3.txt";
		case 4: return "src/levels/level4.txt";
		case 5: return "src/levels/level5.txt";
		}
		return null;
	}
	//End Method
	
}
