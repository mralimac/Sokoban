package gui;
	

import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import main.Tile;



public class GUI extends Application {
	
	protected GridPane grid;
	private int gridWidth;
	private int gridHeight;
	private Rectangle player;
	private int playerXCoord;
	private int playerYCoord;
	
//	private ArrayList<Rectangle> listOfGUITiles = new ArrayList<Rectangle>();
	
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
	}
	
	public void generateScreen()
	{
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		createGrid(this.gridWidth, this.gridHeight);
		addPlayerToGrid(5, 5);
		Scene scene = new Scene(grid, 500, 500);
	    primaryStage.setTitle("Grid");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	public GridPane getGrid()
	{
		return this.grid;
	}
	
	public void movePlayer()
	{		
		
	}
	
	public void addPlayerToGrid(int xCoord, int yCoord)
	{
		
		Rectangle player = new Rectangle();
		this.player = player;
		
		player.setFill(Color.PINK);

		player.setOnKeyTyped(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				int newXCoord = playerXCoord;
				int newYCoord = playerYCoord;
						
				System.out.println("Key typed: " + event.getCharacter());
				if (event.getCharacter().equals("w")) {
		            System.out.println("Move UP");
		            newYCoord--;
		           
		            
		        }
		        if (event.getCharacter().equals("s")) {
		        	System.out.println("Move DOWN");
		        	 newYCoord++;
		           
		        }
		        if (event.getCharacter().equals("d")) {
		        	System.out.println("Move RIGHT");
		        	 newXCoord++;
		           
		        }
		        if (event.getCharacter().equals("a")) {
		        	System.out.println("Move LEFT");
		        	 newXCoord--;
		        	
		        }
		        
		        
		        playerXCoord = newXCoord;
		        playerYCoord = newYCoord;
		        GridPane.setRowIndex(player, newYCoord);
				GridPane.setColumnIndex(player, newXCoord);
		        
				
			}
			
		});
		player.setWidth(50);
		player.setHeight(50);
		player.setStroke(Color.BLACK);
		player.setFocusTraversable(true);
		
		playerXCoord = xCoord;
        playerYCoord = yCoord;
		GridPane.setRowIndex(player, yCoord);
		GridPane.setColumnIndex(player, xCoord);
		
		grid.getChildren().addAll(player);
	}
	
	public void addTileToGrid(int xCoord, int yCoord)
	{
		Rectangle squareTile = new Rectangle();		
		squareTile.setFill(Color.AQUA);
		
		squareTile.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
            	squareTile.setFill(Color.RED);
            }
        });
		
		squareTile.setWidth(50);
		squareTile.setHeight(50);
		squareTile.setStroke(Color.BLACK);
		
		
		GridPane.setRowIndex(squareTile, yCoord);
		GridPane.setColumnIndex(squareTile, xCoord);
		
		grid.getChildren().addAll(squareTile);
	}

	
	public void createGrid(int gridWidth, int gridHeight)
	{
		
		for(int yCoord = 0; yCoord < this.gridHeight; yCoord++)
		{			
			for(int xCoord = 0; xCoord < this.gridWidth; xCoord++)
			{		
				addTileToGrid(xCoord, yCoord);				
			}
		}
	}
	
	
}
