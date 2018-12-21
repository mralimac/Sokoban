package main;

import java.io.File;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Gameplay implements GUI{
//Get all levels in the folder
//Add a button for each one
//Make this the general main menu that appears
	private int numberOfFiles;
	private String folderPath;
	private ArrayList<File> listOfFiles = new ArrayList<File>();
	private ArrayList<Button> mainMenuButtons = new ArrayList<Button>();

	
	public Gameplay()
	{
		this.folderPath = "src/levels/";
		File levelFolder = new File(folderPath);
		File[] listOfLevelFiles = levelFolder.listFiles();		
		this.numberOfFiles = listOfLevelFiles.length;
		
		for(int i = 0; i < numberOfFiles; i++)
		{
			listOfFiles.add(listOfLevelFiles[i]);
		}
	}
	
	public void generateMenu()
	{	
		double currentYOfButtons = 0;
		int gridPaneY = 0;
		for(int i = 0; i < listOfFiles.size(); i++)
		{
			Button button = new Button(listOfFiles.get(i).getName());
			button.setMaxWidth(200);
			button.setMaxHeight(50);
			GridPane.setConstraints(button, 0, gridPaneY++, 200, 50);
			grid.getChildren().addAll(button);
		}
	}
	
	
}
