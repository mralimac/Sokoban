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
	
	
	public void start(Stage primaryStage) throws Exception
	{		
//		Gameplay game1 = new Gameplay();
//		game1.generateMenu();
		//GridPane grid = new GridPane();
		Level level1 = new Level(1);		
		
		//Current issue appears to be, if a newer crate goes over an old crates tile, it will no longer collide
		Scene scene = new Scene(GUI.grid, level1.getLevelWidth(),  level1.getLevelHeight());
		//Scene scene = new Scene(GUI.grid, 500,  1000);
	    primaryStage.setTitle("Sokoban");
	    primaryStage.setResizable(false);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
}
