package main;



import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


public class Player extends MoveableTile
{
	private Tooltip playerToolTip;
	
	//Constructor Section
	public Player(int xCoord, int yCoord) {
		super(xCoord, yCoord, "assets/Player.png", "Player");
		new Floor(xCoord, yCoord);
		getRect().toFront();
		getRect().setFocusTraversable(true);
		//createToolTip();
		
	}
	//End Constructor
	
	//Method Section
	/**
	 * @param event The keyboard event that is passed to this method
	 * @return Returns true if the player can move, false if not
	 */
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
	
	
	/* (non-Javadoc)
	 * @see main.Tile#addToolTip(javafx.scene.input.MouseEvent)
	 */
	public void addToolTip(MouseEvent event)
	{
		this.playerToolTip = new Tooltip("xCoord: " + getXCoord() 
							+ "\nyCoord: "  + getYCoord()
							+ "\nName: Roah"
							+ "\nOccupation: Warehouse Keeper"
							);
							
		this.playerToolTip.show(getRect(), event.getScreenX()+10, event.getScreenY()-50);
	}
	
	
	/* (non-Javadoc)
	 * @see main.Tile#removeToolTip()
	 */
	public void removeToolTip()
	{
		this.playerToolTip.hide();
		this.playerToolTip = null;
	}

}
	//End Method

	



