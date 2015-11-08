package projecteuler.utils;

/**
 * This class contains Prime number related utility methods. 
 * @author Rosh Lee
 *
 * Ref: 
 * http://planetmath.org/howtofindwhetheragivennumberisprimeornot
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * http://math.stackexchange.com/questions/1039519/finding-prime-factors-by-taking-the-square-root
 */

public class PrimeUtils {
	/**
	 * This method is used to check whether a given number is a prime number or not. 
	 * @param n
	 * @return
	 */
	public static boolean isPrime(long n) {
        if (n < 1) {
        	throw new IllegalArgumentException("Target number should be a natural number.");
        } else if ( n == 1) {
        	return false;	
        } else if (n == 2) {
            return true;
        }
        
        // Based on Sieve of Eratosthenes algorithm, if there is no number which is less than 
        // sqrt(n)+1 and can divide n, then n is a prime number. (No need to search further) 
        for (long i=2; i<= (long) (Math.sqrt(n))+1; i++) {
        	// If the given number is divisible by other numbers, 
        	// it is not a prime number. So return false. 
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
	
}
