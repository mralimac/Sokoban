package main;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class Player extends MoveableTile
{

	public Player(int xCoord, int yCoord) {
		super(xCoord, yCoord, new Image("assets/Player.png", 100, 100, false, false), "Player");
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
		        		System.out.println("X:" + newXCoord + " Y:" + newYCoord);
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
		        		System.out.println("X:" + newXCoord + " Y:" + newYCoord);
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
		        		System.out.println("X:" + newXCoord + " Y:" + newYCoord);
		        	}
		        	else
		        	{
		        		System.out.println("Player move not in that direction");
		        	}
		        }
		        if (event.getCharacter().equals("a")) {
		        	if(generalMovementHandler(newXCoord, newYCoord, 4))
		        	{		        		
		        		newXCoord--;	
		        		System.out.println("X:" + newXCoord + " Y:" + newYCoord);
		        	}
		        	else
		        	{
		        		System.out.println("Player move not in that direction");
		        	}
		        }
		        
		        setXCoord(newXCoord);
		        setYCoord(newYCoord);
		        
		        GridPane.setColumnIndex(rectangle, getXCoord());		
		        GridPane.setRowIndex(rectangle, getYCoord());
		               
		        
				
			}
			
		});	
		rectangle.setFocusTraversable(true);
		rectangle.setId("Player");
	}

}

