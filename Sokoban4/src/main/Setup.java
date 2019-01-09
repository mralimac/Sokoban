package main;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Setup
{
	//Attributes Section
	private Stage primaryStage; 
	private BorderPane borderPane;
	private GridPane grid;
	//End Attributes
	
	//Constructor Section
	public Setup(Stage primaryStage)
	{
		this.borderPane = new BorderPane();
		this.primaryStage = primaryStage;
		this.grid = new GridPane();
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
	
	public BorderPane getBorderPane()
	{
		return borderPane;
	}
	
	public GridPane getGridPane()
	{
		return grid;
	}
	//End Method
}
