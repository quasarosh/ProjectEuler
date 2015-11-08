package projecteuler.utils;

/**
 * This class contains Fibonacci number related utility methods. 
 * @author Rosh Lee
 *
 */

import projecteuler.enums.NumberType;


public class FibonacciUtils {
	/**
	 * This method is used to find a nth Fibonacci number. 
	 * @param n
	 * @return
	 */
	public static int fibonacci (int n) {
		// Exception handling
		if (n < 1) {
			throw new IllegalArgumentException("Target number should be a natural number.");
		}
		
		// Special cases
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		}
		
		// Initialization
		int fn = 0;		// Current Fibonacci number - f(n)
		int fn1 = 2;	// f(n-1)
		int fn2 = 1;	// f(n-2)
		
		for (int i=3; i<=n; i++) {
			fn = fn1 + fn2;
			fn2 = fn1;
			fn1 = fn;			
		}
		return fn;
	}
	
	/**
	 * This method is used to get a sum of a given number type of Fibonacci numbers, which 
	 * are less than a given target number.  
	 * @param target
	 * @param numType - ALL (sum of all Fibonacci numbers), ODD (sum of odd Fibonacci numbers), 
	 * 					EVEN (sum of even Fibonacci numbers)
	 * @return
	 */
	public static int fibonacciNumberSum (int target, NumberType numType) {
		// Error handling
		if (target < 1) {
			throw new IllegalArgumentException("Target number can't be less than 1");
		}
		
		// Corner cases. If target is less than 3, need to return fn1 or fn2.
		if (target == 1) {
			return 1;
		} else if (target == 2) {
			return 2;
		}
		
		// Initialization
		int fn = 0;		// Current Fibonacci number - f(n)
		int fn1 = 2;	// f(n-1)
		int fn2 = 1;	// f(n-2)
		
		// Initial value of sum is different based on the number type.
		int sum = 0;
		if (numType.equals(NumberType.ALL)) {
			sum = fn1+fn2;
		} else if (numType.equals(NumberType.ODD)) {
			sum = fn2;
		} else if (numType.equals(NumberType.EVEN)) {
			sum = fn1;
		}
		
		// Calculate & Update Fibonacci number.
		while(fn < target) {
			fn = fn1 + fn2;
			fn2 = fn1;
			fn1 = fn;
			
			// Accumulate only given number type value of Fibonacci number. 
			if (numType.equals(NumberType.ALL)) {
				sum += fn;
			} else if (numType.equals(NumberType.ODD)) {
				if (fn % 2 == 1) {
					sum += fn;
				}
			} else if (numType.equals(NumberType.EVEN)) {
				if (fn % 2 == 0) {
					sum += fn;
				}
			}			
		}
		return sum;
	}
}
