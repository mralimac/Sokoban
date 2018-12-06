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



public class GUI extends Application {
	
	private GridPane grid;
	private int gridWidth;
	private int gridHeight;
	
	public GUI()
	{
		this.gridWidth = 10;
		this.gridHeight = 10;
		this.grid = new GridPane();
		//launch();
	}
	
	public GUI(int gridWidth, int gridHeight)
	{
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		this.grid = new GridPane();
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		createGrid(this.gridWidth, this.gridHeight);
		Scene scene = new Scene(grid, 500, 500);
	    primaryStage.setTitle("Grid");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	
	public void createGrid(int gridWidth, int gridHeight)
	{
		
		for(int yCoord = 0; yCoord < this.gridHeight; yCoord++)
		{
			System.out.println("Grid Height" + yCoord);
			for(int xCoord = 0; xCoord < this.gridWidth; xCoord++)
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
				tile.setWidth(50);
				tile.setHeight(50);
				if(xCoord == 0 || yCoord == 0 || xCoord == 9 || yCoord == 9)
				{
					tile.setFill(Color.GREEN);
				}
				else
				{
					tile.setFill(Color.AQUA);
				}
				
				tile.setStroke(Color.BLACK);
				GridPane.setRowIndex(tile, xCoord);
				GridPane.setColumnIndex(tile, yCoord);
				grid.getChildren().addAll(tile);
			}
		}
	}
	
	
}