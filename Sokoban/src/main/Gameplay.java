package main;

import java.io.File;
import java.util.ArrayList;

public class Gameplay
{
	private ArrayList<Level> allLevels = new ArrayList<Level>();
	
	public Gameplay()
	{
		
	}
	
	public int countNumOfLevels(String folderLocation)
	{		
		folderLocation = "./levels/";
		int num = new File("../levels/").list().length;
		System.out.println(num);
		return num;
	}
}
