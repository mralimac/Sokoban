package main;

public abstract class Coords {
	protected int xCoord;
	protected int yCoord;
	
	public int getXCoord()
	{
		return this.xCoord;
	}
	
	public int getYCoord()
	{
		return this.yCoord;
	}
	
	
	public void setXCoord(int xCoord)
	{
		this.xCoord = xCoord;
	}
	
	public void setYCoord(int yCoord)
	{
		this.yCoord = yCoord;
	}
}
