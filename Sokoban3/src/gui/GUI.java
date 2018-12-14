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
	
	public Rectangle getObjectInGridPane(int xCoord, int yCoord)
	{
		//Got this from Stackoverflow cause its the best/only way to do this
		for(Node gridObject : grid.getChildren())
		{
			if(GridPane.getColumnIndex(gridObject) == xCoord && GridPane.getRowIndex(gridObject) == yCoord)
			{
				if(gridObject instanceof Rectangle)
				{
					return (Rectangle) (gridObject);
				}
				return null;
			}
		}
		
		
		return null;
	}
	
	public void moveTheCrate(int xCoord, int yCoord, int direction)
	{
		switch(direction)
		{
		case 1: yCoord--;
		break;
		case 2: xCoord++;
		break;
		case 3: yCoord++;
		break;
		case 4: xCoord--;
		}
	}
	
	
	public boolean isThereACrateInDirection(int xCoord, int yCoord, int direction)
	{
		switch(direction)
		{
		case 1: yCoord--;
		break;
		case 2: xCoord++;
		break;
		case 3: yCoord++;
		break;
		case 4: xCoord--;
		}
		
		Rectangle objectInGrid = getObjectInGridPane(xCoord, yCoord);
		if(objectInGrid.getFill().equals(Color.BROWN))
		{
			return false;
		}		
		
		return true;
	}
	
	public boolean isDirectionPossible(int xCoord, int yCoord, int direction)
	{
		switch(direction)
		{
		case 1: yCoord--;
		break;
		case 2: xCoord++;
		break;
		case 3: yCoord++;
		break;
		case 4: xCoord--;
		}
		
		Rectangle objectInGrid = getObjectInGridPane(xCoord, yCoord);
		if(objectInGrid.getFill().equals(Color.RED))
		{
			return false;
		}		
		
		return true;
	}
	
//	public void updateCrateOnGrid(Crate crate)
//	{
//		
//	}
	
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
					if(isDirectionPossible(newXCoord, newYCoord, 1))
		        	{
		        		newYCoord--;	
		        		System.out.println("Move UP");
		        	}
		        	else
		        	{
		        		System.out.println("Player move not in that direction");
		        	}
		           
		            
		        }
		        if (event.getCharacter().equals("s")) {
		        	if(isDirectionPossible(newXCoord, newYCoord, 3))
		        	{
		        		newYCoord++;	
		        		System.out.println("Move DOWN");
		        	}
		        	else
		        	{
		        		System.out.println("Player move not in that direction");
		        	}
		        	
		        	 
		           
		        }
		        if (event.getCharacter().equals("d")) {
		        	if(isDirectionPossible(newXCoord, newYCoord, 2))
		        	{
		        		newXCoord++;	
		        		System.out.println("Move RIGHT");
		        	}
		        	else
		        	{
		        		System.out.println("Player move not in that direction");
		        	}
		        }
		        if (event.getCharacter().equals("a")) {
		        	if(isDirectionPossible(newXCoord, newYCoord, 4))
		        	{
		        		newXCoord--;	
		        		System.out.println("Move LEFT");
		        	}
		        	else
		        	{
		        		System.out.println("Player move not in that direction");
		        	}
		        }
		        
		        
		        playerXCoord = newXCoord;
		        playerYCoord = newYCoord;
		        GridPane.setRowIndex(player, newYCoord);
		        GridPane.setColumnIndex(player, newXCoord);
		        GridPane.getColumnIndex(player);
		        
				
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
	
	public void addTileToGrid(int xCoord, int yCoord, Color colour)
	{
		Rectangle squareTile = new Rectangle();		
		squareTile.setFill(colour);
		
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
				if(xCoord == 0 || xCoord == this.gridWidth-1 || yCoord == 0 || yCoord == this.gridHeight-1)
				{
					addTileToGrid(xCoord, yCoord, Color.RED);
				}
				else
				{
					addTileToGrid(xCoord, yCoord, Color.AQUA);
				}
								
			}
		}
	}
	
	
}
