package main;


import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;


public class Player extends MoveableTile
{
	//Constructor Section
	public Player(int xCoord, int yCoord) {
		super(xCoord, yCoord, new Image("assets/Player.png", 100, 100, false, false), "Player");
		new Floor(xCoord, yCoord);
		System.out.println("Starting Coords: " + xCoord +", " + yCoord);
		this.tileImage = new Image("assets/Player.png", 100, 100, false, false);
		rectangle.toFront();
		rectangle.setFocusTraversable(true);
		rectangle.setId("Player");
	}
	//End Constructor
	
	//Method Section
	public boolean addMovementHandling(KeyEvent event)
	{
		boolean returnCondition = false;
		rectangle.toFront();
		int newXCoord = getXCoord();
		int newYCoord = getYCoord();						
		returnCondition = false;
		if (event.getCharacter().equals("w")) {
			if(generalMovementHandler(newXCoord, newYCoord, 1))
        	{						
        		newYCoord--;
        		returnCondition = true;
        	}
        }
		
        if (event.getCharacter().equals("s")) {
        	if(generalMovementHandler(newXCoord, newYCoord, 3))
        	{		        		
        		newYCoord++;
        		returnCondition = true;
        	}
        }
        
        if (event.getCharacter().equals("d")) {
        	if(generalMovementHandler(newXCoord, newYCoord, 2))
        	{		        		
        		newXCoord++;
        		returnCondition = true;
        	}
        }
        
        if (event.getCharacter().equals("a")) {
        	if(generalMovementHandler(newXCoord, newYCoord, 4))
        	{		        		
        		newXCoord--;
        		returnCondition = true;
        	}
        }
        
       

        setXCoord(newXCoord);
        setYCoord(newYCoord);
        GridPane.setConstraints(rectangle,  getXCoord(), getYCoord());
        rectangle.toFront();
        return returnCondition;
    }
	
	//I couldn't work out where I would need overriding, so I made this method which is an example of it
	public void overRiding()
	{
		System.out.println("But this is");
		System.out.println("*surprised pikachu face*");
	}
	//End Method

	

}

