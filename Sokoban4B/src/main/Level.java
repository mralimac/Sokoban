package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Level
{
	
	//Attributes Section
	private int levelNumber;
	private Player thePlayer;
	private ArrayList<Tile> listOfTiles = new ArrayList<Tile>();
	private ArrayList<String> listOfLines = new ArrayList<String>();
	private WinHandler winHandle;
	private AlertHandler alertHandler = new AlertHandler();
	//Constructor Section
	public Level(int levelNumber, String filePath, WinHandler winHandle) throws IOException
	{
		this.winHandle = winHandle;
		this.levelNumber = levelNumber;
		loadLevel(filePath);
	}
	//End Constructor
	
	//Method Section
	
	//
	/**
	 * Returns the level width in pixels
	 * @return Returns the level width in pixels
	 */
	public int getLevelWidth()
	{
		return this.listOfLines.get(1).length() *  50;
	}
	
	//
	/**
	 * Returns the level height in pixels
	 * @return Returns the level height in pixels
	 */
	public int getLevelHeight()
	{
		return this.listOfLines.size() * 50 +90;
	}
	
	//
	/**
	 * Loads the level by reading the file and calling the buildObjects method
	 * @param filePath The filepath to the level file
	 * @throws IOException Thrown if the level file is wrong/corrupt
	 */
	public void loadLevel(String filePath) throws IOException
	{
		//String filePath = getFilePath();
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
			alertHandler.newError("Warning! File not Found");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method builds the level by reading the file and adding the object relevant to the character in the file
	 */
	public void buildObjects()
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
				winHandle.addCrate(crate);
				break;
				
				case "@": Player thePlayer = new Player(xCoord,yCoord);
				listOfTiles.add(thePlayer);
				this.thePlayer = thePlayer;
				break;
				
				case "X": listOfTiles.add(new Wall(xCoord,yCoord));					
				break;
				
				case ".": Diamond diamond = new Diamond(xCoord, yCoord); 
				winHandle.addDiamond(diamond);
				listOfTiles.add(diamond);
				break;
				
				default: listOfTiles.add(new Floor(xCoord,yCoord));
				}
				xCoord++;
			}			
			

			yCoord++;
		}
	}
	
	//
	/**
	 * This method returns the current level number. An example of encapsulation
	 * @return Returns the current level number
	 */
	public int getLevelNumber()
	{
		return this.levelNumber;
	}
	
	
	/**
	 * This method ret urn the player object. An example of encapsulation
	 * @return Returns the player
	 */
	public Player getPlayer()
	{
		return this.thePlayer;
	}
	//End Method
	
}
