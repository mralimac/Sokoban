package main;

import java.util.ArrayList;

import javafx.scene.Node;

public class WinHandler implements GUI{
	
	//Attributes Section
	private ArrayList<Diamond> listOfDiamonds = new ArrayList<Diamond>();
	private ArrayList<Crate> listOfCrates = new ArrayList<Crate>();	
	private boolean won = false;
	//End Attributes
	
	//Constructor Section
	public WinHandler()
	{
		this.won = false;	
	}
	//End Constructor
	
	//Method Section
	
	//Adds a crate to the arraylist
	public void addCrate(Crate crate)
	{
		listOfCrates.add(crate);
	}
	
	//Adds a diamond to the arraylist
	public void addDiamond(Diamond diamond)
	{
		listOfDiamonds.add(diamond);
	}
	
	//Wipes out the arraylist to prevent bugs
	public void clearAll()
	{
		listOfCrates.clear();
		listOfDiamonds.clear();
	}
	
	//Used for debugging, forces a win
	public void setToWin(boolean winValue)
	{
		this.won = winValue;
	}
	
	//Returns true if the game is won. An example of encapsultion
	public boolean isWin()
	{
		return this.won;
	}
	
	//Assigns a boolean value to "won" depending on game status. Sort of encapsultion
	public void checkIfGameIsWon()
	{
		this.won = checkGameVictoryConditions();
	}
	
	//This checks if the game is won by seeing if any diamonds are left on the board, as in, they aren't covered by the crates
	public boolean checkGameVictoryConditions()
	{
		for(Node gridObject : grid.getChildren())
		{
			if(gridObject.getId().equals("Diamond"))
			{
				return false;
			}
		}
		System.out.println("No Diamonds Remain");
		return true;	
	}
	//End Method
}
