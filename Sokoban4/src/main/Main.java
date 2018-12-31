package main;



import javafx.application.Application;
import javafx.scene.Scene;


import javafx.stage.Stage;

public class Main extends Application
{	
	//public GridPane grid = new GridPane();
	
	public static void main(String[] args) 
	{
		launch();
	}
	
	@SuppressWarnings("unused")
	public void start(Stage primaryStage) throws Exception
	{		
		//GridPane grid = new GridPane();
		Level level1 = new Level(1);
		
		Scene scene = new Scene(GUI.grid, 1200, 800);
	    primaryStage.setTitle("Sokoban");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
}
