package main;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class WinHandler
{
	
	//Attributes Section
	private ArrayList<Diamond> listOfDiamonds = new ArrayList<Diamond>();
	private ArrayList<Crate> listOfCrates = new ArrayList<Crate>();	
	private boolean won = false;
	private GridPane grid;
	//End Attributes
	
	//Constructor Section
	public WinHandler()
	{
		this.grid = Setup.getGridPane();
		this.won = false;	
	}
	//End Constructor
	
	//Method Section	
	
	/**
	 * Adds a crate to the arraylist
	 * @param crate The crate we want to add
	 */
	public void addCrate(Crate crate)
	{
		listOfCrates.add(crate);
	}
	
	
	/**
	 * Adds a diamond to the arraylist
	 * @param diamond The diamond we want to add
	 */
	public void addDiamond(Diamond diamond)
	{
		listOfDiamonds.add(diamond);
	}
	
	/**
	 *Wipes out the arraylist to prevent bugs
	 */
	public void clearAll()
	{
		listOfCrates.clear();
		listOfDiamonds.clear();
	}
	
	/**
	 * Used for debugging, forces a win
	 * @param winValue The boolean value that sets a game to won or not
	 */
	public void setToWin(boolean winValue)
	{
		this.won = winValue;
	}	
	
	/**
	 * Returns true if the game is won. An example of encapsultion
	 * @return If the game is won, this returns true, else false
	 */
	public boolean isWin()
	{
		return this.won;
	}
	
	/**
	 * Assigns a boolean value to "won" depending on game status. Sort of encapsultion
	 */
	public void checkIfGameIsWon()
	{
		this.won = checkGameVictoryConditions();
	}
	
	
	/**
	 * This checks if the game is won by seeing if any diamonds are left on the board, as in, they aren't covered by the crates
	 * @return Returns true if all diamonds are gone
	 */
	public boolean checkGameVictoryConditions()
	{
		for(Node gridObject : grid.getChildren())
		{
			if(gridObject.getId().equals("Diamond"))
			{
				return false;
			}
		}
		return true;	
	}
	//End Method
}
