package projecteuler;

/**
 * 10001st Prime
 * Project Euler Problem #7 - https://projecteuler.net/problem=7
 * 
 * Question: 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 * 
 * Answer: 104743
 * Execution Time: 0 milliseconds
 * 
 * Solution: 
 * Iterate the numbers between 2 and target-1 number, find 10001st or nst prime number.
 * For every iteration the number is checked if it is a prime number or not, and if yes, 
 * then increase a count value. Once count value becomes 10001st or nst, return the last prime number.   
 * 
 * Time Complexity: O(n)
 * 
 * Ref: https://en.wikipedia.org/wiki/Prime_number  
 *   
 * Reason to Pick: After solving the Largest Prime Factor problem, I tried to solve prime number related issue. 
 * 
 * Time to spend: 
 * - Solve a question: 10 minutes
 * - Etc (Commenting, testing, restructuring, etc): 30 miniutes  
 *   
 * @author Rosh Lee
 *
 */

import projecteuler.utils.PrimeUtils;


public class NstPrime {

	private static final int TARGET = 10001;
	
	/**
	 * This method is used to find 10001st prime number. 
	 * @return
	 */
	public int find10001stPrime() {
		int count = 0;
		int index = 2;
		while (count != TARGET) {
			if (PrimeUtils.isPrime(index)) {
				count++;
			}
			index++;
		}
		return index-1; 
	}
	
	/**
	 * This method is a generic version of find10001thPrime method above, 
	 * which is used to find nst prime number.
	 * @param n
	 * @return
	 */
	public int findNstPrime(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("n of nst value shoud be a natural number.");
		}
		
		int count = 0;
		int index = 2;
		while (count != n) {
			if (PrimeUtils.isPrime(index)) {
				count++;
			}
			index++;
		}
		return index-1; 
	}
	
	/**
	 * Test program
	 */
	public static void main(String[] args) {
		
		NstPrime nstPrime = new NstPrime();
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		int nthPrime = nstPrime.findNstPrime(TARGET);
		System.out.println("Excution Time: " + (endTime - startTime) + " millisecones");
		System.out.println("nth prime: " + nthPrime);

	}

}
