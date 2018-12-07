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
	public void setXCoord(int newXCoord)
	{
		this.xCoord = newXCoord;
	}
	public void setYCoord(int newYCoord)
	{
		this.yCoord = newYCoord;
	}
}
