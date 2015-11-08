package projecteuler.utils;

/**
 * Unit tests for FibonacciUtiils.java
 * 
 * @author Rosh Lee
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import projecteuler.enums.NumberType;


public class FibonacciUtilsTest {

	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Unit test to check the corner cases: Target is 1 or 2 
	 */
	@Test
	public void testFibonacciNumberSumConnerCases() {
		int target = 1;
		int result = FibonacciUtils.fibonacciNumberSum(target, NumberType.ALL);
		int expect = 1;
		assertEquals(result, expect);
		target = 2;
		result = FibonacciUtils.fibonacciNumberSum(target, NumberType.ALL);
		expect = 2;
		assertEquals(result, expect);
	}
	
	/**
	 * Unit test to check whether fibonacciNumberSum method is returning 
	 * proper value for NumberType.ALL. (Accumulation of all Fibonacci numbers,
	 * which are less than target value.
	 */
	@Test
	public void testFibonacciNumberSum() {
		int target = 5;
		int result = FibonacciUtils.fibonacciNumberSum(target, NumberType.ALL);
		int expect = 0;
		int fib = 0;
		for (int i=1; fib<target;i++) {
			fib = FibonacciUtils.fibonacci(i);
			expect += fib;
		}
		assertEquals(result, expect);
	}
	
	/**
	 * Unit test to check whether fibonacciNumberSum method is returning 
	 * proper value for NumberType.ODD. (Accumulation of all odd-valued Fibonacci numbers,
	 * which are less than target value.
	 */
	@Test
	public void testOddFibonacciNumberSum() {
		int target = 5;
		int result = FibonacciUtils.fibonacciNumberSum(target, NumberType.ODD);
		int expect = 0;
		int fib = 0;
		for (int i=1; fib<target;i++) {
			fib = FibonacciUtils.fibonacci(i);
			if (fib%2 == 1) {
				expect += fib;
			}	
		}
		assertEquals(result, expect);
	}
	
	/**
	 * Unit test to check whether fibonacciNumberSum method is returning 
	 * proper value for NumberType.EVEN. (Accumulation of all even-valued Fibonacci numbers,
	 * which are less than target value.
	 */
	@Test
	public void testEvenFibonacciNumberSum() {
		int target = 5;
		int result = FibonacciUtils.fibonacciNumberSum(target, NumberType.EVEN);
		int expect = 0;
		int fib = 0;
		for (int i=1; fib<target;i++) {
			fib = FibonacciUtils.fibonacci(i);
			if (fib%2 == 0) {
				expect += fib;
			}	
		}
		assertEquals(result, expect);
	}
	
	/**
	 * Unit test to check whether fibonacciNumberSum method is throwing an exception
	 * properly. 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testFibonacciNumberSumIllegalArgumentException() {
		int target = 0;
		FibonacciUtils.fibonacciNumberSum(target, NumberType.EVEN);
		target = -1;
		FibonacciUtils.fibonacciNumberSum(target, NumberType.ODD);
	}

}
