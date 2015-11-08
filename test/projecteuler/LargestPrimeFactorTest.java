package projecteuler;

/**
 * Unit tests for LargestPrimeFactor.java file
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LargestPrimeFactorTest {

	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Unit test for findLargestPrimeFactor method
	 * normal flow (positive test)
	 */
	@Test
	public void testFindLargestPrimeFactor() {
		
		LargestPrimeFactor largestPrime = new LargestPrimeFactor();
		long target = 13195;
		long expect = 29;
		long result = largestPrime.findLargestPrimeFactor(target);
		assertEquals(expect, result);
		
	}
	
	/**
	 * Unit test for findLargestPrimeFactor method
	 * Test exception handling
	 */
	@Test(expected=IllegalArgumentException.class) 
	public void testFindLargestPrimeFactorIllegalArgumentException() {
		
		LargestPrimeFactor largestPrime = new LargestPrimeFactor();
		long target = 0;
		largestPrime.findLargestPrimeFactor(target);

	}
}
