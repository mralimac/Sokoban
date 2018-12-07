package main;

import java.awt.Color;

import gui.GUI;


public class Tile extends GUI
{
	private int xCoord;
	private int yCoord;
	private int typeOfTile;
	
	
	public Tile(int xCoord, int yCoord, int typeOfTile)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.typeOfTile = typeOfTile;
		
	}	
	
	public int getXCoord()
	{
		return this.xCoord;
	}
	
	public int getYCoord()
	{
		return this.xCoord;
	}
}
