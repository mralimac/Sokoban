package main;



import javafx.application.Application;
import javafx.scene.Scene;


import javafx.stage.Stage;

public class Main extends Application implements GUI
{	
	public static void main(String[] args) 
	{
		launch();
	}
	
	public void start(Stage unusedStagePlzIgnore) throws Exception
	{		
		new Gameplay();
		primaryStage.setResizable(false);
	    primaryStage.setTitle("Sokoban");
	    primaryStage.setScene(new Scene(GUI.grid));
	    primaryStage.show();
	}
}
