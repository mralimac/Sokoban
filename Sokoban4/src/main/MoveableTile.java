package main;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public abstract class MoveableTile extends Tile{
//Add methods to allow this tile to move around
	
	

	public MoveableTile(int xCoord, int yCoord, Image tileImage, String tileType) {
		super(xCoord, yCoord, tileImage, tileType);
		
	}	
	
	public Rectangle getObjectInGridPane(int xCoord, int yCoord)
	{
		//Got this from StackOverflow cause its the best/only way to do this
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
		
		
		
		boolean isThereACrateInWay = isCrateInWay(xCoord, yCoord, direction);
		if(isThereACrateInWay)
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
		System.out.println("Before Crate moves X: " + xCoord + "Y: " + yCoord);
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
		System.out.println("After Crate moves X: " + xCoord + "Y: " + yCoord);
		
		Rectangle objectInGrid = getObjectInGridPane(xCoord, yCoord);
		if(objectInGrid == null)
		{
			return false;
		}
		
		if(objectInGrid.getId().equals("Wall") || objectInGrid.getId().equals("Crate"))
		{
			System.out.println("What is in way" + objectInGrid.getId());
			return false;
		}		
		
		
		return true;
	}
	
	public void moveCrate(int xCoord, int yCoord, int direction)
	{
		System.out.println("Crate movement x: " + xCoord + ", y: " + yCoord);
		
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
		
		crate.toFront();
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
		
		
		GridPane.setColumnIndex(crate, xCoord);
		GridPane.setRowIndex(crate, yCoord);
		
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
		System.out.println(objectInGrid.getId());
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

