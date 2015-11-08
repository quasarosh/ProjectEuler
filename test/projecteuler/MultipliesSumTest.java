package projecteuler;

/**
 * Unit tests for MultipliesSum.java file. 
 * 
 * @author Rosh Lee
 */

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class MultipliesSumTest {

	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Unit test for getMultipliesSum method (with two divisors) 
	 * Test scenario #1: normal flow with natural numbers
	 * Test scenario #2: x and y are bigger than target 
	 */
	@Test
	public void testGetMultipliesSumWithTwoValues() {
		int target = 10, x = 3, y = 5;
		int result = MultipliesSum.getMultipliesSum(x, y, target);
		int expect = 23;
		assertEquals(result, expect);
		
		// Case: x and y are bigger than target.
		x = 30;
		y = 50;
		result = MultipliesSum.getMultipliesSum(x, y, target);
		expect = 0;
		assertEquals(result, expect);		
	}

	/**
	 * Unit test for getMultipliesSum method (with divisor list)
	 * Test scenario #1: normal flow with natural numbers
	 * Test scenario #2: x and y are bigger than target  
	 */
	@Test
	public void testGetMultipliesSumWithDivisorList() {
		int target = 10, x = 3, y = 5;
		int expect = MultipliesSum.getMultipliesSum(x, y, target);
		int[] divList = {3,5};
		int result = MultipliesSum.getMultipliesSum(divList, target);
		assertEquals(result, expect);
		
		int[] divList2 = {3,5,7};
		expect = 30;
		result = MultipliesSum.getMultipliesSum(divList2, target);
		assertEquals(result, expect);
		
		int[] divList3 = {30, 50};
		expect = 0;
		result = MultipliesSum.getMultipliesSum(divList3, target);
		assertEquals(result, expect);
	}
	
	/**
	 * Unit test to check whether getMultipliesSum method (with two divisors) 
	 * is throwing an exception properly. 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetMultipliesSumWithTwoValuesIllegalArgumentException() {
		int target = 0, x = 3, y = 5;
		MultipliesSum.getMultipliesSum(x, y, target);
		target = 10; 
		x = -1;
		MultipliesSum.getMultipliesSum(x, y, target);
		x = 3;
		y = -5;
		MultipliesSum.getMultipliesSum(x, y, target);
	}
	
	/**
	 * Unit test to check whether getMultipliesSum method (with divisor list)
	 * is throwing an exception properly. 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetMultipliesSumWithDivisorListIllegalArgumentException() {
		int target = 10;
		int[] divList = null;
		MultipliesSum.getMultipliesSum(divList, target);
		int[] divList2 = {};
		MultipliesSum.getMultipliesSum(divList2, target);
		int[] divList3 = {3,-1};
		MultipliesSum.getMultipliesSum(divList3, target);
		divList3[1] = 2;
		target = 0;
		MultipliesSum.getMultipliesSum(divList3, target);
	}
	
}
