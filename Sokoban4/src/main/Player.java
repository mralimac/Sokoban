package main;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class Player extends MoveableTile
{

	public Player(int xCoord, int yCoord) {
		super(xCoord, yCoord, new Image("assets/Player.png", 100, 100, false, false), "Player");
		new Floor(xCoord, yCoord);
		System.out.println("Starting Coords: " + xCoord +", " + yCoord);
		this.tileImage = new Image("assets/Player.png", 100, 100, false, false);
		rectangle.toFront();
		
		rectangle.setOnKeyTyped(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				rectangle.toFront();
				int newXCoord = getXCoord();
				int newYCoord = getYCoord();						
				
				if (event.getCharacter().equals("w")) {
					if(generalMovementHandler(newXCoord, newYCoord, 1))
		        	{						
		        		newYCoord--;	
		        		//System.out.println("X:" + newXCoord + " Y:" + newYCoord);
		        	}
		        	else
		        	{
		        		System.out.println("Player move not in that direction");
		        	}
		           
		            
		        }
		        if (event.getCharacter().equals("s")) {
		        	if(generalMovementHandler(newXCoord, newYCoord, 3))
		        	{		        		
		        		newYCoord++;	
		        		//System.out.println("X:" + newXCoord + " Y:" + newYCoord);
		        	}
		        	else
		        	{
		        		System.out.println("Player move not in that direction");
		        	}
		        	
		        	 
		           
		        }
		        if (event.getCharacter().equals("d")) {
		        	if(generalMovementHandler(newXCoord, newYCoord, 2))
		        	{		        		
		        		newXCoord++;	
		        		//System.out.println("X:" + newXCoord + " Y:" + newYCoord);
		        	}
		        	else
		        	{
		        		System.out.println("Player move not in that direction");
		        	}
		        }
		        
		        if (event.getCharacter().equals("t")) {
		        	printOutDiamondList();
		        }
		        
		        if (event.getCharacter().equals("a")) {
		        	if(generalMovementHandler(newXCoord, newYCoord, 4))
		        	{		        		
		        		newXCoord--;	
		        		//System.out.println("X:" + newXCoord + " Y:" + newYCoord);
		        	}
		        	else
		        	{
		        		System.out.println("Player move not in that direction");
		        	}
		        }

				Rectangle objectInGrid = getObjectInGridPane(newXCoord, newYCoord);
				//System.out.println("Player is standing on " + objectInGrid.getId());
				
		        setXCoord(newXCoord);
		        setYCoord(newYCoord);
		        GridPane.setConstraints(rectangle,  getXCoord(), getYCoord());
//		        GridPane.setColumnIndex(rectangle, getXCoord());		
//		        GridPane.setRowIndex(rectangle, getYCoord());
		        rectangle.toFront();
		        
				
			}
			
		});	
		rectangle.setFocusTraversable(true);
		rectangle.setId("Player");
	}

}

