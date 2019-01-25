package main;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public abstract class MoveableTile extends Tile{
	
	//Attributes Section
	private ArrayList<int[]> coordsOfDiamonds = new ArrayList<int[]>();
	//End Attributes
	
	//Constructor Section
	public MoveableTile(int xCoord, int yCoord, String tileImage, String tileType) {
		super(xCoord, yCoord, tileImage, tileType);
		
		
	}
	//End Constructor
	
	//Method Section
	
	/**
	 * This method checks the entire gridpane for a matching object
	 * I got this partially from a StackOverflow Answer (https://stackoverflow.com/questions/20655024/javafx-gridpane-retrieve-specific-cell-content)	
	
	 * @param xCoord Coord that we want to check
	 * @param yCoord Coord that we want to check
	 * @return Returns rectangle object at those coords
	 */
	public Rectangle getObjectInGridPane(int xCoord, int yCoord)
	{
		//Got this from StackOverflow cause its the best/only way to do this
		//https://stackoverflow.com/questions/20655024/javafx-gridpane-retrieve-specific-cell-content
		for(Node gridObject : getGrid().getChildren())
		{
			if(GridPane.getColumnIndex(gridObject) == xCoord && GridPane.getRowIndex(gridObject) == yCoord )
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
	
	
	/**
	 * This is the general movement handler, it helps move the player and crates around
	 * This returns true or false based on if the player can move in the direction requested
	 * @param xCoord Coord we are checking
	 * @param yCoord Coord we are checking
	 * @param direction Direction we are checking
	 * @return Returns true if a player and/or crate can move, else false
	 */
	public boolean generalMovementHandler(int xCoord, int yCoord, int direction)
	{
		
		if(isCrateInWay(xCoord, yCoord, direction))
		{
			
			int crateXCoords = xCoord;
			int crateYCoords = yCoord;
			switch(direction)
			{
			case 1: crateYCoords = yCoord--;
			break;
			case 2: crateXCoords = xCoord++;
			break;
			case 3: crateYCoords = yCoord++;
			break;
			case 4: crateXCoords = xCoord--;
			}
			
			if(canCrateMove(crateXCoords, crateYCoords, direction))
			{				
				moveCrate(crateXCoords, crateYCoords, direction);
				
				
				return true;
				
			}
			else
			{
				
				//Crate can't move therefore neither can player
				return false;
			}
		}
		
		
		if(!isDirectionPossible(xCoord, yCoord, direction))
		{			
			return false;
		}
		
		return true;
		
	}

	/**
	 * Checks if the crate can be moved by checking if the tile in the direction specified is not a wall or another crate
	 * @param xCoord Coord we are checking
	 * @param yCoord Coord we are checking
	 * @param direction Direction we are checking
	 * @return Returns true if the crate can move, else false
	 */
	public boolean canCrateMove(int xCoord, int yCoord, int direction)
	{
		switch(direction)
		{
		case 1: yCoord = yCoord - 2;
		break;
		case 2: xCoord = xCoord + 2;
		break;
		case 3: yCoord = yCoord + 2;
		break;
		case 4: xCoord = xCoord - 2;
		}
		
		
		Rectangle objectInGrid = getObjectInGridPane(xCoord, yCoord);
		if(objectInGrid == null)
		{
			return false;
		}
		
		if(objectInGrid.getId().equals("Wall") || objectInGrid.getId().equals("Crate"))
		{
			return false;
		}		
		
		
		return true;
	}
	
	
	/**
	 * Checks if a diamond tile needs to be placed instead of a floor tile
	 * (since floor/diamond tiles are technically deleted when a crate moves onto them)
	 * @param xCoord xCoord of where we are checking
	 * @param yCoord yCoord of where we are checking
	 * @return True if we do need a place a tile, else false
	 */
	public boolean doWeNeedToPlaceADiamond(int xCoord, int yCoord)
	{
		for(int i = 0; i < coordsOfDiamonds.size(); i++)
		{
			int[] coordsToCheck = coordsOfDiamonds.get(i);
			if(coordsToCheck[0] == xCoord && coordsToCheck[1] == yCoord)
			{
				coordsOfDiamonds.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 	This method moves the crate by deleting the tile that is moving to, then placing the crate onto the now blank tile
	It also places a floor tile on the location where the crate was previously, unless the tile was a diamond previously
	Then it places a diamond tile
	 * @param xCoord Coord of where we are checking
	 * @param yCoord Coord of where we are checking
	 * @param direction Direction we are checking
	 */
	public void moveCrate(int xCoord, int yCoord, int direction)
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
		Rectangle crate = getObjectInGridPane(xCoord, yCoord);
		
		
		
		
		if(doWeNeedToPlaceADiamond(xCoord, yCoord))
		{
			GridPane.setConstraints(new Diamond(xCoord, yCoord).getRect(), xCoord, yCoord);
		}
		else
		{
			GridPane.setConstraints(new Floor(xCoord, yCoord).getRect(), xCoord, yCoord);
		}
		
		//if(crate != null) crate.toFront();
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
		
		Rectangle existingTile = getObjectInGridPane(xCoord, yCoord);
		if(existingTile.getId() == "Diamond")
		{	
			int[] diamondCoords = new int[2];
			diamondCoords[0] = xCoord;
			diamondCoords[1] = yCoord;
			coordsOfDiamonds.add(diamondCoords);			
		}
			
		
		getGrid().getChildren().remove(existingTile);
		//new Crate(xCoord, yCoord, getGrid());
		GridPane.setConstraints(crate, xCoord, yCoord);		
		
		crate.toFront();
	}
	
	
	/**
	 * Checks if there is a crate in the direction that the player wants to go
	 * @param xCoord Coord of where we are checking
	 * @param yCoord Coord of where we are checking
	 * @param direction Direction we are checking
	 * @return True if there is a crate in the way, else false
	 */
	public boolean isCrateInWay(int xCoord, int yCoord, int direction)
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
		
		if(objectInGrid == null || objectInGrid.getId().equals("Crate"))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if the direction is possible (IE, is there a wall in the way)
	 * @param xCoord Coord of where we are checking
	 * @param yCoord Coord of where we are checking
	 * @param direction Direction we are checking
	 * @return Returns true if the direction is possible, else false
	 */
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
		if(objectInGrid.getId().equals("Wall"))
		{
			return false;
		}		
		
		
		return true;
	}
	
	//End Method
	
}

