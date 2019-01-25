package main;



import javafx.application.Application;


import javafx.stage.Stage;

public class Main extends Application
{	
	public static void main(String[] args) 
	{
		launch();
	}
	
	public void start(Stage primaryStage) throws Exception
	{	
		new Setup(primaryStage);
		new Gameplay();
	}
}
