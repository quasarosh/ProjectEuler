package projecteuler;

/**
 * Largest Prime Factor
 * Project Euler Problem #3 - https://projecteuler.net/problem=3
 * 
 * Question: 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * Answer: 6857
 * Execution Time: 0 milliseconds
 * 
 * Solution: 
 * Iterate the numbers between 2 and target-1 number, find if there is a prime number,  
 * which can divide a target number. If yes, update target number (divide by the found prime number) 
 * and largest prime value. (since the number is increasing, the lastly assigned value should be 
 * the largest prime value)
 * 
 * Time Complexity: O(n)
 * 
 * Ref: https://en.wikipedia.org/wiki/Prime_number  
 *   
 *   
 * Reason to Pick: This problem was pretty interested, specifically the large size of a target number. 
 * 
 * Time to spend: 
 * - Solve a question: 20 minutes
 * - Etc (Commenting, testing, restructuring, etc): about a hour
 * 
 * @author Rosh Lee
 *
 */

import projecteuler.utils.PrimeUtils;

 
public class LargestPrimeFactor {
	
	private static final long TARGET = 600851475143L;
	
	/**
	 * This method is used to find the largest prime factor for a given 
	 * target value. 
	 * @param target
	 * @return
	 */
	public long findLargestPrimeFactor(long target) {
		// Exception handling
		if (target < 1) {
			throw new IllegalArgumentException("Target number should be a natural number.");
		}
		
		long largestPrime = 0;
		
		// As long as a number is less than target, and target is bigger than 1, 
		// check if there is a prime factor of the target number.  
		for (long num=2; num<target || target > 1; num++) {
			// If a number is a prime number and can divide the target number, 
			// then update target number and largestPrime value. 
			if (target%num == 0 && PrimeUtils.isPrime(num)) {
				target = target/num;
				largestPrime = num;		
			}
			
		}
		return largestPrime;
	}
	
	/**
	 * Test program. 
	 */
	public static void main(String[] args) {
		
		LargestPrimeFactor largestPrime = new LargestPrimeFactor();
		long startTime = System.currentTimeMillis();
		long res = largestPrime.findLargestPrimeFactor(TARGET);
		long endTime = System.currentTimeMillis();
		System.out.println("Excution Time: " + (endTime - startTime) + " millisecones");
		System.out.println("Largest Prime Factor: " + res);	
		
	}

}
