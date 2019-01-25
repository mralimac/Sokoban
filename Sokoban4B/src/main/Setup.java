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

public class Setup
{
	//Attributes Section
	private static Stage primaryStage; 
	private static BorderPane borderPane;
	private static GridPane grid;
	private static int PlayerID;
	private static AlertHandler alertHandler = new AlertHandler();
	//End Attributes
	
	//Constructor Section
	public Setup(Stage primaryStage)
	{
		Setup.borderPane = new BorderPane();
		Setup.primaryStage = primaryStage;
		Setup.grid = new GridPane();
		doProFile();
		setupGUI();
		setScene();
		
	}
	//End Constructor
	
	//Method Section
	/**
	 * Places the gridpane inside the borderpane
	 */
	private static void setupGUI()
	{
		borderPane.setCenter(grid);		
	}
	
	/**
	 * Generates the window
	 */
	private static void setScene()
	{
		Scene scene = new Scene(borderPane);
		primaryStage.setTitle("Sokoban");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Handles the properties files
	 */
	private static void doProFile()
	{
		Properties proFile = new Properties();
		if(!isPlayerIDSet(proFile))
		{
			setUpProFile(proFile);
		}
		readProFile(proFile);
	}
	
	/**
	 * Checks if the player ID is present in the proFile
	 * @param proFile The properties file that we want to check
	 * @return Returns true if the playerID is present, else false
	 */
	private static boolean isPlayerIDSet(Properties proFile)
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
			alertHandler.newError("WARNING: Properties File invalid!");
		}
		
		if(playerID != 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Generates a new properties file
	 * @param proFile The properties file we want to set up
	 */
	private static void setUpProFile(Properties proFile)
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
			alertHandler.newError("Error writing to Properties File");
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
	
	/**
	 * Reads the properties file and gets the relevant attributes
	 * @param proFile The properties file we want to check
	 */
	private static void readProFile(Properties proFile)
	{
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");					
			
			proFile.load(input);
			
			PlayerID = Integer.parseInt(proFile.getProperty("PlayerID"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{			
			e.printStackTrace();
			alertHandler.newError("WARNING: Properties File invalid!");
		}
	}
	
	/**
	 * Gets the border pane
	 * @return Returns the borderpane
	 */
	public static BorderPane getBorderPane()
	{
		return Setup.borderPane;
	}
	
	/**
	 * Gets the gridpane
	 * @return Returns the gridpane
	 */
	public static GridPane getGridPane()
	{
		return Setup.grid;
	}
	
	/**
	 * Gets the playerID
	 * @return Returns the playerID
	 */
	public static int getPlayerID()
	{
		return Setup.PlayerID;
	}
	
	/**
	 * Gets the stage
	 * @return Returns the stage
	 */
	public static Stage getStage()
	{
		return Setup.primaryStage;
	}
	//End Method
}
