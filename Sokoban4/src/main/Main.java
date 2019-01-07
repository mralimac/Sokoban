package main;



import javafx.application.Application;


import javafx.stage.Stage;

public class Main extends Application implements GUI
{	
	public static void main(String[] args) 
	{
		//new Setup();
		launch();
	}
	
	public void start(Stage unusedStagePlzIgnore) throws Exception
	{	
		new Setup();
		new Gameplay();
	}
}
