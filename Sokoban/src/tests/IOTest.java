package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Gameplay;

class IOTest {

	@Test
	void test() {
		Gameplay game1 = new Gameplay();
		
		int numOfLevels = game1.countNumOfLevels("");
		if(numOfLevels == 5)
		{
			
		}
		else
		{
			fail("Number of Levels Returned " + numOfLevels);
		}	
	}

}
