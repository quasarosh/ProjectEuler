package projecteuler;

/**
 * Multiples of 3 and 5
 * Project Euler Problem #1 - https://projecteuler.net/problem=1
 * 
 * Question: 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * Answer: 233168
 * Execution Time: 0 milliseconds
 * 
 * Solution: 
 * Iterate the numbers which are less than a given target number, and calculate 
 * a sum of a number which is divisible by any given numbers. (In this problem, two 
 * numbers are given.)
 * 
 * Time Complexity: O(n) or O(n*m)
 * n: 0 < n < target
 * m: List of given number
 *   
 * Reason to Pick: First item of ProjectEuler web site and want to get familiar with the problems in this web site. 
 * 
 * Time to spend: 
 * - Solve a question: 10 - 20 minutes
 * - Etc (Commenting, testing, restructuring, etc): more than a hour
 *   
 * @author Rosh Lee
 *
 */

public class MultipliesSum {
	/**
	 * This method is used to get a sum of the number which is divisible by
	 * one of two input numbers and is not bigger than a given target number. 
	 * @param x
	 * @param y
	 * @param target
	 * @return
	 */
	public static int getMultipliesSum (int x, int y, int target) {
		// Exception handling
		if (x <1 || y<1 || target<1) {
			throw new IllegalArgumentException("Divisor or target number should be a natural number.");
		}
		
		int res = 0;
		
		for (int i=1; i<target; i++) {
			// Check if the ith number is divisible by either x or y.
			// If yes, add it to the return value, res.
			if (i%x == 0 || i%y == 0) {
				res += i;
			}
		}
		
		return res;
	}
	
	/**
	 * This method is used to get a sum of the number which is divisible by
	 * any of input numbers and is not bigger than a given target number. 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int getMultipliesSum (int[] nums, int target) {
		// Exceptions handling
		if (nums == null || nums.length == 0) {
			throw new IllegalArgumentException("Divisor list should contain at least one naturla number.");
		}
		
		if (target<1) {
			throw new IllegalArgumentException("Target number should be a natural number.");
		} 
		
		for (int i=0; i<nums.length; i++) {
			if (nums[i] <1) {
				throw new IllegalArgumentException("Divisor number should be a natural number.");
			} 
		}
		
		// Initialization
		int res = 0;
		boolean isDivisible = false;	// This flag is used to check if ith 
										// number is divisible by any number in 'nums' list.
		
		for (int i=1; i<target; i++) {
			for (int j=0; j<nums.length; j++) {
				// Check if the ith number is divisible by any number in 'nums' list.
				// If yes, set the isDivisible flag to true and break the loop. 
				if (i%nums[j] == 0) {
					isDivisible = true;
					break;
				}
			}
			// If isDivisible value is true, it means the ith number is divisible by one or multiple numbers 
			// in the 'nums' list. So, the ith number is added to the result value, res. 
			if (isDivisible) {
				res += i;
				isDivisible = false;
			}
		}
		return res;
	}	
	
	/**
	 * Testing program
	 */
	public static void main(String[] args) {

		int[] nums = {3,5};
		long startTime = System.currentTimeMillis();
		int result = getMultipliesSum(nums, 1000);
		long endTime = System.currentTimeMillis();
		System.out.println("Excution Time: " + (endTime - startTime) + " millisecones");
		System.out.println("Sum is " + result);
		
	}

}
