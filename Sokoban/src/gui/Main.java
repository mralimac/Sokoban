package gui;
	

import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;



public class Main extends Application {
	
	private GridPane grid = new GridPane();
	@Override
	public void start(Stage primaryStage) throws Exception {	
		//GridPane grid = new GridPane();
		createGrid(10,10);
	   


		
		
		Scene scene = new Scene(grid, 1000, 1000);
	    primaryStage.setTitle("Grid");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	public void createGrid(int gridWidth, int gridHeight)
	{
		
		for(int i = 0; i < gridHeight; i++)
		{
			System.out.println("Grid Height" + i);
			for(int x = 0; x < gridWidth; x++)
			{
				//System.out.println("Grid Width" + i);
				Rectangle tile = new Rectangle();
				
				
				tile.setOnMouseClicked(new EventHandler<MouseEvent>()
		        {
		            @Override
		            public void handle(MouseEvent t) {
		            	tile.setFill(Color.RED);
		            }
		        });
				tile.setWidth(100);
				tile.setHeight(100);
				tile.setFill(Color.AQUA);
				tile.setStroke(Color.BLACK);
				GridPane.setRowIndex(tile, i);
				GridPane.setColumnIndex(tile, x);
				grid.getChildren().addAll(tile);
			}
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}