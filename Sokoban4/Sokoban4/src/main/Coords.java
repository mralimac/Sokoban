package main;

//An example of abstraction
public abstract class Coords {
	
	//Attributes Section
	protected int xCoord;
	protected int yCoord;
	//End Attributes
	
	//Method Section
	//These 4 methods are a lovely example of encapsulation (getters/setters)
	public void setXCoord(int xCoord)
	{
		this.xCoord = xCoord;		
	}
	
	public void setYCoord(int yCoord)
	{		
		this.yCoord = yCoord;
	}
	
	public int getXCoord()
	{
		return this.xCoord;
	}
	
	public int getYCoord()
	{
		return this.yCoord;
	}
	//End Method
}
