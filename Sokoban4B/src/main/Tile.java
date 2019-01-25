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
public abstract class Tile extends MapElement 
{
	
	//Attributes Section
	private int xCoord;
	private int yCoord;
	private String tileImage;
	private Rectangle rectangle;
	private String tileType;
	private Tooltip toolTip;
	//End Attributes
	
	//Constructor Section
	/**
	 * Creates a new tile
	 * @param xCoord The Xcoord of where the tile is gonna be
	 * @param yCoord The yCoord of where the tile is gonna be
	 * @param tileImage The image the tile will show
	 * @param tileType The ID of the tile
	 */
	public Tile(int xCoord, int yCoord, String tileImage, String tileType)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;	
		this.tileType = tileType;
		this.tileImage = tileImage;
		this.rectangle = new Rectangle();
		this.setGrid(Setup.getGridPane());
		rectangle.setWidth(50);
		rectangle.setHeight(50);
		rectangle.setFill(new ImagePattern(new Image(this.tileImage, 100, 100, false, false)));
		rectangle.setId(tileType);
		
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
	//
	/**
	 * Returns the tile type as a String
	 * @return Returns the tile type as a String
	 */
	public String getTileType()
	{
		return this.tileType;
	}
	
	//
	/**
	 * Returns the rectangle object attached to this tile
	 * @return Returns the rectangle object attached to this tile
	 */
	public Rectangle getRect()
	{
		return this.rectangle;
	}

	//These 4 methods are a lovely example of encapsulation (getters/setters)
	/** 
	 * Sets the xCoord
	 * @param xCoord the Xcoord we want to set
	 */
	public void setXCoord(int xCoord)
	{
		this.xCoord = xCoord;		
	}
	
	/** 
	 * Sets the yCoord
	 * @param yCoord the yCoord we want to set
	 */
	public void setYCoord(int yCoord)
	{		
		this.yCoord = yCoord;
	}
	
	/**
	 * Gets the xCoord
	 * @return Returns the xCoord
	 */
	public int getXCoord()
	{
		return this.xCoord;
	}
	
	/**
	 * Gets the yCoord
	 * @return Returns the yCoord
	 */
	public int getYCoord()
	{
		return this.yCoord;
	}
	/**
	 * Sets the tooltip
	 * @param toolTip The tooltip we want to set
	 */
	public void setToolTip(Tooltip toolTip)
	{
		this.toolTip = toolTip;
	}
	
	/**
	 * Adds a tooltip
	 * @param event The hover over event to make the tooltip appear relative to it
	 */
	public void addToolTip(MouseEvent event)
	{
		this.toolTip = new Tooltip("xCoord: " + getXCoord() + "\nyCoord: "  + getYCoord() + "\nTileType: " + getTileType());
		this.toolTip.show(getRect(), event.getScreenX()+10, event.getScreenY()-50);
	}
	
	/**
	 * Removes a toolTip
	 */
	public void removeToolTip()
	{
		this.toolTip.hide();
		this.toolTip = null;
	}
	
	
	
	//End Method
}
