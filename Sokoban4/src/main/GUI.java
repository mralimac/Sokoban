package main;

import javafx.scene.layout.GridPane;

//used to be an interface, but was reformed, and slimmed down into an abstract class to reduce coupling
public abstract class GUI 
{	
	//Attributes Sections
	private GridPane grid;
	//End Attributes
	
	//Methods Section
	public void setGrid(GridPane grid)
	{
		this.grid = grid;
	}
	
	public GridPane getGrid()
	{
		return this.grid;
	}
	//End Method
}
