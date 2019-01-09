package main;


import javafx.event.EventHandler;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

//Abstraction. This is the general tile class that all tile classes use
public abstract class Tile implements GUI {
	
	//Attributes Section
	private int xCoord;
	private int yCoord;
	private Image tileImage;
	private Rectangle rectangle;
	private String tileType;
	private Tooltip toolTip;
	//End Attributes
	
	//Constructor Section
	public Tile(int xCoord, int yCoord, Image tileImage, String tileType)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;	
		this.tileType = tileType;
		this.tileImage = tileImage;
		this.rectangle = new Rectangle();
		rectangle.setWidth(50);
		rectangle.setHeight(50);
		rectangle.setFill(new ImagePattern(this.tileImage));
		createToolTip();
		getRect().setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
            	addToolTip(t);
            }
        });
		
		getRect().setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
            	removeToolTip();
            }
        });
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
	
	public void setImage(Image tileImage)
	{
		this.tileImage = tileImage;
	}
	
	public void setTileType(String tileType)
	{
		this.tileType = tileType;
	}
	
	public void setRect(Rectangle rectangle)
	{
		this.rectangle = rectangle;
	}
	
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
	public void setToolTip(Tooltip toolTip)
	{
		this.toolTip = toolTip;
	}
	
	public void addToolTip(MouseEvent event)
	{
		this.toolTip.show(getRect(), event.getScreenX()+10, event.getScreenY()-50);
	}
	
	public void removeToolTip()
	{
		this.toolTip.hide();
	}
	
	public void createToolTip()
	{
		this.toolTip = new Tooltip("xCoord: " + this.xCoord + "\nyCoord: "  + this.yCoord + "\nTileType: " + this.tileType);
	}
	
	//End Method
}
