package main;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class Main extends Application
{	
	
	public static void main(String[] args) 
	{
		launch();
	}
	
	public void start(Stage primaryStage) throws Exception
	{		
		GridPane grid = new GridPane();
		Tile tile = new Tile(3, 3);
		
		GridPane.setRowIndex(tile.getRect(), 0);
		GridPane.setColumnIndex(tile.getRect(), 0);
		grid.getChildren().addAll(tile.getRect());
		Scene scene = new Scene(grid, 500, 500);
	    primaryStage.setTitle("Sokoban");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
}
