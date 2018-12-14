package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Level {
	private int levelNumber;
	private int numberOfSteps;
	
	ArrayList<Diamond> listOfDiamonds = new ArrayList<Diamond>();
	
	public Level(int levelNumber)
	{
		this.levelNumber = levelNumber;
	}
	
	public void loadLevel()
	{
		String filePath = getFilePath();
		try {
			FileReader file = new FileReader(filePath);
			BufferedReader bufferedFile = new BufferedReader(file);			
		} catch (FileNotFoundException e) {			
			System.out.println("Warning! File not Found");
			e.printStackTrace();
		}
		
		
	}
	
	public String getFilePath()
	{
		switch(this.levelNumber)
		{
		case 1: return "assets/level1.txt";
		case 2: return "assets/level2.txt";
		case 3: return "assets/level3.txt";
		case 4: return "assets/level4.txt";
		case 5: return "assets/level5.txt";
		}
		return null;
	}
	
	
}
