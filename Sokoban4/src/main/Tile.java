package main;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

//Abstraction. This is the general tile class that all tile classes use
public abstract class Tile extends Coords implements GUI {
	
	//Attributes Section
	protected Image tileImage;
	protected Rectangle rectangle;
	protected String tileType;
	//End Attributes
	
	//Constructor Section
	public Tile(int xCoord, int yCoord, Image tileImage, String tileType)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;	
		this.tileType = tileType;
		this.rectangle = new Rectangle();
		rectangle.setWidth(50);
		rectangle.setHeight(50);
		
		
		rectangle.setFill(new ImagePattern(tileImage));
		GridPane.setConstraints(rectangle, this.xCoord, this.yCoord);
		grid.setVgap(0);
		grid.setHgap(0);
		grid.getChildren().addAll(rectangle);		
	}	
	//End Constructor
	
	//Method Section
	//Returns the tile type as a String
	public String getTileType()
	{
		return this.tileType;
	}
	
	//Returns the rectangle object attached to this tile
	public Rectangle getRect()
	{
		return this.rectangle;
	}
	
	//I couldn't work out where I would need overriding, so this method exists here and in player
	public void overRiding()
	{
		System.out.println("This isn't an example of overriding");
	}
	//End Method
}
