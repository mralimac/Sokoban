package gui;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Character {
	private Color colourOfPlayer = Color.ALICEBLUE;
	private int initalX;
	private int initalY;
	
	public Character()
	{
		this.initalX = 5;
		this.initalY = 5;
		
		
	}
	
	public Character(int initalX, int intialY)
	{
		this.initalX = initalX;
		this.initalY = intialY;
	}
}
