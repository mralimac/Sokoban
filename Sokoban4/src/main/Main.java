package main;



import javafx.application.Application;


import javafx.stage.Stage;

public class Main extends Application
{	
	public static void main(String[] args) 
	{
		//new Setup();
		launch();
	}
	
	public void start(Stage primaryStage) throws Exception
	{	
		Setup setup = new Setup(primaryStage);
		new Gameplay(primaryStage, setup.getBorderPane(), setup.getGridPane());
	}
}
