package main;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public abstract class MoveableTile extends Tile{
//Add methods to allow this tile to move around
	private ArrayList<int[]> coordsOfDiamonds = new ArrayList<int[]>();

	public MoveableTile(int xCoord, int yCoord, Image tileImage, String tileType) {
		super(xCoord, yCoord, tileImage, tileType);
		
	}

	
	public Rectangle getObjectInGridPane(int xCoord, int yCoord)
	{
		//Got this from StackOverflow cause its the best/only way to do this
		//https://stackoverflow.com/questions/20655024/javafx-gridpane-retrieve-specific-cell-content
		for(Node gridObject : grid.getChildren())
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
	
	public void printOutDiamondList()
	{
		for(int i = 0; i < coordsOfDiamonds.size(); i++)
		{
			System.out.println("X: " + coordsOfDiamonds.get(i)[0] + " Y: " + coordsOfDiamonds.get(i)[1]);
		}
	}
	
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
			
		
		grid.getChildren().remove(existingTile);
		GridPane.setConstraints(crate, xCoord, yCoord);		
		
		crate.toFront();
	}
	
	
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

	public void moveInDirection(int direction)
	{
		//1 is North
		//2 is East
		//3 is South
		//4 is West
		switch(direction)
		{
		case 1: this.yCoord--;
		break;
		case 2: this.xCoord++;
		break;
		case 3: this.yCoord++;
		break;
		case 4: this.xCoord--;
		break;
		}
	}	
	
}

