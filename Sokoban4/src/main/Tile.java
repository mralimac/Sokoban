package main;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Tile extends Coords implements GUI {
	Image tileImage;
	Rectangle rectangle;
	String tileType;
	
	public Tile(int xCoord, int yCoord, Image tileImage, String tileType)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;	
		this.tileType = tileType;
		this.rectangle = new Rectangle();
		rectangle.setWidth(50);
		rectangle.setHeight(50);
		
		
		rectangle.setFill(new ImagePattern(tileImage));
		GridPane.setColumnIndex(rectangle, this.xCoord);
		GridPane.setRowIndex(rectangle, this.yCoord);			
		grid.getChildren().addAll(rectangle);
		
	}
	
	public String getTileType()
	{
		return this.tileType;
	}
	
	public Rectangle getRect()
	{
		return this.rectangle;
	}	
}
