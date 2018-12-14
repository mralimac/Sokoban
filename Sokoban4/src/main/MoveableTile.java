package main;

public abstract class MoveableTile extends Tile{
//Add methods to allow this tile to move around
	
	

	public MoveableTile(int xCoord, int yCoord) {
		super(xCoord, yCoord);
		
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
