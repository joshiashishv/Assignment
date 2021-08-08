package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
	
import org.junit.Test;


import main.MaxCheeseInRow;

public class TestMaxCheeseInRow {

	@Test  
	public void testFindMax(){

		assertEquals(113,MaxCheeseInRow.findMaxCheeseWt(Arrays.asList(new Integer[]{8,10,100,10,5})));  
		assertEquals(116,MaxCheeseInRow.findMaxCheeseWt(Arrays.asList(new Integer[]{7,3,5,9,99,100,3})));  
		assertFalse(111==MaxCheeseInRow.findMaxCheeseWt(Arrays.asList(new Integer[]{7,3,5,9,99,100,3})));  
	}  

}
