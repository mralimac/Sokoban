package main;



import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


public class Player extends MoveableTile
{
	private Tooltip playerToolTip;
	
	//Constructor Section
	public Player(int xCoord, int yCoord, GridPane grid) {
		super(xCoord, yCoord, new Image("assets/Player.png", 100, 100, false, false), "Player", grid);
		new Floor(xCoord, yCoord, grid);
		setTileXCoord(xCoord);
		setTileYCoord(yCoord);
		setTileType("Player");
		setTileImage(new Image("assets/Player.png", 100, 100, false, false));
		getRect().toFront();
		getRect().setFocusTraversable(true);
		//createToolTip();
		
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
        
       

        setTileXCoord(newXCoord);
        setTileYCoord(newYCoord);
        GridPane.setConstraints(getRect(),  getXCoord(), getYCoord());
        getRect().toFront();
        return returnCondition;
    }
	
	//This method overrides the method in Tile
	public void addToolTip(MouseEvent event)
	{
		this.playerToolTip = new Tooltip("xCoord: " + getXCoord() 
							+ "\nyCoord: "  + getYCoord()
							+ "\nName: Roah"
							+ "\nOccupation: Warehouse Keeper"
							);
							
		this.playerToolTip.show(getRect(), event.getScreenX()+10, event.getScreenY()-50);
	}
	
	//This method removes the tooltip
	public void removeToolTip()
	{
		this.playerToolTip.hide();
		this.playerToolTip = null;
	}
	
	@Override
	public void setTileImage(Image image) {
		setImage(image);
	}
	
	@Override
	public void setTileType(String tileType) {
		getRect().setId(tileType);
		
	}
	
	@Override
	public void setTileXCoord(int xCoord) {
		setXCoord(xCoord);
		
	}
	
	@Override
	public void setTileYCoord(int yCoord) {
		setYCoord(yCoord);
		
	}
	
}
	//End Method

	



