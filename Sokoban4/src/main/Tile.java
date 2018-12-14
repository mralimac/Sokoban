package main;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Tile extends Coords {
	Image tileImage;
	Rectangle rectangle;
	
	public Tile(int xCoord, int yCoord)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.tileImage = new Image("assets/Tile.png", 50, 50, false, false);
		this.rectangle = new Rectangle();
		rectangle.setWidth(50);
		rectangle.setHeight(50);
		rectangle.setFill(new ImagePattern(tileImage));
	}
	
	public Rectangle getRect()
	{
		return this.rectangle;
	}
}
