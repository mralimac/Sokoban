package main;


import javafx.event.EventHandler;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

//Abstraction. This is the general tile class that all tile classes use
//As this extends GUI and uses an Interface, this makes this class (and all the subclasses) polymorphic
public abstract class Tile extends GUI implements TilePlacement{
	
	//Attributes Section
	private int xCoord;
	private int yCoord;
	private Image tileImage;
	private Rectangle rectangle;
	private String tileType;
	private Tooltip toolTip;	
	//End Attributes
	
	//Constructor Section
	public Tile(int xCoord, int yCoord, Image tileImage, String tileType, GridPane grid)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;	
		this.tileType = tileType;
		this.tileImage = tileImage;
		this.rectangle = new Rectangle();
		this.setGrid(grid);
		rectangle.setWidth(50);
		rectangle.setHeight(50);
		rectangle.setFill(new ImagePattern(this.tileImage));
		
		//I added a tooltip to give myself an opporunity to showcase Overriding. it also helps with bug solving
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
		getGrid().setVgap(0);
		getGrid().setHgap(0);
		getGrid().getChildren().addAll(rectangle);		
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
	
	//As this method exists both here and in Player, this is an example of Overriding. This was done so Player could create its own Tooltip
	public void addToolTip(MouseEvent event)
	{
		this.toolTip = new Tooltip("xCoord: " + getXCoord() + "\nyCoord: "  + getYCoord() + "\nTileType: " + getTileType());
		this.toolTip.show(getRect(), event.getScreenX()+10, event.getScreenY()-50);
	}
	
	public void removeToolTip()
	{
		this.toolTip.hide();
		this.toolTip = null;
	}
	
	
	
	//End Method
}
