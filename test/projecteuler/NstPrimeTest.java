package projecteuler;

/**
 * Unit tests for NstPrime.java file 
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class NstPrimeTest {

	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Unit test for find10001stPrime method (Positive test)
	 */
	@Test
	public void testFind10001stPrime() {

		NstPrime the10001stPrime = new NstPrime();
		int expect = 104743;
		int result = the10001stPrime.find10001stPrime();
		assertEquals(expect, result);
		
	}
	
	/**
	 * Unit test for findNstPrime method (Positive tests)
	 */
	@Test
	public void testFindNstPrime() {

		NstPrime nstPrime = new NstPrime();
		int n = 10001;
		int expect = 104743;
		int result = nstPrime.findNstPrime(n);
		assertEquals(expect, result);
		
		// Check whether both methods returns a same result.
		expect = nstPrime.find10001stPrime();
		assertEquals(expect, result);
		
	}
	
	/**
	 * Unit test for findNstPrime method (Negative test)
	 * Exception handling
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testFindNstPrimeIllegalArgumentException() {

		NstPrime nstPrime = new NstPrime();
		int n = 0;
		nstPrime.findNstPrime(n);
		
	}
	

}
