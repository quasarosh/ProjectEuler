package projecteuler;

/**
 * Unit test for EvenFibonacciNumbers.java file
 * 
 * @author Rosh Lee
 */

import org.junit.Before;
import org.junit.Test;


public class EvenFibonadcciNumbersTest {

	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Unit test to check if 'evenFibonacciNumberSum' throws an exception
	 * properly
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testEvenFibonacciNumberSumIllegalArgumentException() {
		EvenFibonacciNumbers evenFib = new EvenFibonacciNumbers();
		int target = 0;
		evenFib.evenFibonacciNumberSum(target);
		target = -3;
		evenFib.evenFibonacciNumberSum(target);
	}
	
}
