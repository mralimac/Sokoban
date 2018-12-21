package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Level {
	private int levelNumber;
	
	
	private ArrayList<Diamond> listOfDiamonds = new ArrayList<Diamond>();
	private ArrayList<Tile> listOfTiles = new ArrayList<Tile>();
	private ArrayList<String> listOfLines = new ArrayList<String>();
	
	public Level(int levelNumber) throws IOException
	{
		this.levelNumber = levelNumber;
		loadLevel();
	}
	
	public int getLevelWidth()
	{
		return this.listOfLines.get(1).length() *  50;
	}
	
	public int getLevelHeight()
	{
		return this.listOfLines.size() * 50;
	}
	
	public void loadLevel() throws IOException
	{
		String filePath = getFilePath();
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
			System.out.println("Warning! File not Found");
			e.printStackTrace();
		}
		
		
	}
	
	

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
					//System.out.println("Adding new Floor");
				break;
				case "*": listOfTiles.add(new Crate(xCoord, yCoord));				
					//System.out.println("Adding new Crate");
				break;
				case "@": listOfTiles.add(new Player(xCoord,yCoord));
					System.out.println("Adding new Player\n" + "X: " + xCoord + ", Y:" + yCoord);
				break;
				case "X": listOfTiles.add(new Wall(xCoord,yCoord));
					//System.out.println("Adding new Wall");
				break;
				case ".": Diamond diamond = new Diamond(xCoord, yCoord); 
				listOfDiamonds.add(diamond);
				listOfTiles.add(diamond);
					//System.out.println("Adding new Diamond");
				break;
				}
				xCoord++;
			}			
			

			yCoord++;
		}
	}
	
	public String getFilePath()
	{
		switch(this.levelNumber)
		{
		case 1: return "src/levels/level1.txt";
		case 2: return "src/levels/level2.txt";
		case 3: return "src/levels/level3.txt";
		case 4: return "src/levels/level4.txt";
		case 5: return "src/levels/level5.txt";
		}
		return null;
	}
	
	
}
