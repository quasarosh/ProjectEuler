package projecteuler.utils;

/**
 * Unit tests for PrimeUtils.java file
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class PrimeUtilsTest {

	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Unit test for isPrime method. (Positive tests)
	 */
	@Test
	public void testIsPrime() {
		int target = 1;
		boolean result = PrimeUtils.isPrime(target);
		assertFalse(result);
		
		target = 2;
		result = PrimeUtils.isPrime(target);
		assertTrue(result);
		
		target = 5;
		result = PrimeUtils.isPrime(target);
		assertTrue(result);
		
	}
	
	/**
	 * Unit test for isPrime method. (Negative test)
	 * Exception handling
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testIsPrimeIllegalArgumentException() {
		int target = 0;
		PrimeUtils.isPrime(target);
		
	}

}
