package main;



import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;


public class Player extends MoveableTile
{
	//Constructor Section
	public Player(int xCoord, int yCoord) {
		super(xCoord, yCoord, new Image("assets/Player.png", 100, 100, false, false), "Player");
		new Floor(xCoord, yCoord);
		setImage(new Image("assets/Player.png", 100, 100, false, false));
		getRect().toFront();
		getRect().setFocusTraversable(true);
		getRect().setId("Player");
		createToolTip();
		
	}
	//End Constructor
	
	//Method Section
	public boolean addMovementHandling(KeyEvent event)
	{
		boolean returnCondition = false;
		getRect().toFront();
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
        GridPane.setConstraints(getRect(),  getXCoord(), getYCoord());
        getRect().toFront();
        return returnCondition;
    }
	
	
	public void createToolTip()
		{
			setToolTip(new Tooltip("xCoord: " + getXCoord() 
								+ "\nyCoord: "  + getYCoord()
								+ "\nName: Roah"
								+ "\nOccupation: Warehouse Keeper"
								));
		}
	}
	//End Method

	



