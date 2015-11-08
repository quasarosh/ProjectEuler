package projecteuler;

/**
 * Unit tests for SummationOfPrimes.java file.  
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SummationOfPrimesTest {

	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Unit test for summationOfPrimes method (Positive tests)
	 */
	@Test
	public void testFindNstPrime() {

		SummationOfPrimes summation = new SummationOfPrimes();
		int n = 10;
		long expect = 17;
		long result = summation.summationOfPrimes(n);
		assertEquals(expect, result);
		
	}
	
	/**
	 * Unit test for summationOfPrimes method (Negative test)
	 * Exception handling
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testSummationOfPrimesIllegalArgumentException() {

		SummationOfPrimes summation = new SummationOfPrimes();
		int n = 0;
		summation.summationOfPrimes(n);
		
	}

}
