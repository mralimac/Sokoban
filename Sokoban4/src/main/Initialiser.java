package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Initialiser
{
	//Attributes Section
	private Stage primaryStage; 
	private BorderPane borderPane;
	private GridPane grid;
	private int PlayerID;
	//End Attributes
	
	//Constructor Section
	public Initialiser(Stage primaryStage)
	{
		this.borderPane = new BorderPane();
		this.primaryStage = primaryStage;
		this.grid = new GridPane();
		doProFile();
		setupGUI();
		setScene();
		
	}
	//End Constructor
	
	//Method Section
	private void setupGUI()
	{
		borderPane.setCenter(grid);		
	}
	
	private void setScene()
	{
		Scene scene = new Scene(borderPane);
		primaryStage.setTitle("Sokoban");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void doProFile()
	{
		Properties proFile = new Properties();
		if(!isPlayerIDSet(proFile))
		{
			setUpProFile(proFile);
		}
		readProFile(proFile);
	}
	
	private boolean isPlayerIDSet(Properties proFile)
	{
		InputStream input = null;
		int playerID = 0;
		try {
			input = new FileInputStream("config.properties");					
			
			proFile.load(input);
			if(proFile.getProperty("PlayerID").equals(null) || proFile.getProperty("PlayerID").equals("")) 
			{
				return false;
			}
			playerID = Integer.parseInt(proFile.getProperty("PlayerID"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{			
			e.printStackTrace();
			System.out.println("WARNING: Properties File invalid!");
		}
		
		if(playerID != 0)
		{
			return true;
		}
		return false;
	}
	
	private void setUpProFile(Properties proFile)
	{
		OutputStream output = null;
		int playerID = ThreadLocalRandom.current().nextInt(1000, 10000);
		String stringPlayerID = playerID+"";
		try {
			output = new FileOutputStream("config.properties");
			proFile.setProperty("PlayerID", stringPlayerID);
			proFile.store(output, null);
		}
		catch(IOException io)		
		{
			io.printStackTrace();
		}
		finally
		{
			if(output != null)
			{
				try {
					output.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	private void readProFile(Properties proFile)
	{
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");					
			
			proFile.load(input);
			
			this.PlayerID = Integer.parseInt(proFile.getProperty("PlayerID"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{			
			e.printStackTrace();
			System.out.println("WARNING: Properties File invalid!");
		}
	}
	
	public BorderPane getBorderPane()
	{
		return this.borderPane;
	}
	
	public GridPane getGridPane()
	{
		return this.grid;
	}
	
	public int getPlayerID()
	{
		return this.PlayerID;
	}
	//End Method
}
