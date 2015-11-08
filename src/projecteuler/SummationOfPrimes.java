package projecteuler;

/**
 * Summation of Prime
 * Project Euler Problem #10 - https://projecteuler.net/problem=10
 * 
 * Question: 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * 
 * Answer: 142913828922
 * 
 * Solution: 
 * Iterate the numbers between 2 and target-1 number, and accumulate all the prime numbers
 * in the range.   
 * 
 * Time Complexity: O(n)
 * 
 * Ref: https://en.wikipedia.org/wiki/Prime_number  
 * 
 * Sample output: 
 * Sum: 142913828922
 * Execution Time: 1847 milliseconds
 * Reason to Pick: After solving the Largest Prime Factor problem, I tried to solve prime number related issue. 
 * Time to spend: 
 * - Solve a question: 10 minutes
 * - Etc (Commenting, testing, restructuring, etc): 30 miniutes     
 *   
 * @author Rosh Lee
 *
 */

import projecteuler.utils.PrimeUtils;


public class SummationOfPrimes {
	
	private static final int TARGET = 2000000;
	
	/**
	 * This method is used to get a summation of prime numbers
	 * which are less than a given number, n. 
	 * @param n
	 * @return
	 */
	public long summationOfPrimes(int n) {
		// Exception handling
		if (n < 1) {
			throw new IllegalArgumentException("Target number should be a natural number.");
		}
		
		long sum = 0;
		int num = 2;
		
		// If a number is a prime number, 
		// add it to sum value. 
		while (num < n) {
			if (PrimeUtils.isPrime(num)) {
				sum += num;
			}
			num++;
		}
		
		return sum;
	}
	
	/**
	 * Test program
	 */
	public static void main(String[] args) {

		SummationOfPrimes summation = new SummationOfPrimes();
		long startTime = System.currentTimeMillis();
		long sum = summation.summationOfPrimes(TARGET);
		long endTime = System.currentTimeMillis();
		System.out.println("Sum: " +sum);
		System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds");

	}

}
