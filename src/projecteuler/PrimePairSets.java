package projecteuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimePairSets {

	private static List<Integer> primeList = new ArrayList<Integer>(); 
	private static Set<Integer> primeSet = new HashSet<Integer>();
	//private static int[] primes = Library.listPrimes(30000);
	
	public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } 
        
        double sqrt_n = Math.sqrt(n)+1;
        for (int i=2; i<= sqrt_n; i++) {
        	if (n%i == 0) {
        		return false;
			}
        }

        return true;
    }
	
	public static int getNextPrimeNumber(int num) {
		do {
			num++;
		} while(!isPrime(num));
		return num;
	}
	
	public static int concatenateNums(int x, int y) {
		int z = y;
        while (z > 0) {
            x *= 10;
            z /= 10;
        }
        return x + y;
	}
	
	public static boolean isPrimePair(int[] primePairSet, int num) {
		for (int i=0; i<primePairSet.length; i++) {
			if (!isPrime(concatenateNums(primePairSet[i], num)) 
					|| !isPrime(concatenateNums(num, primePairSet[i]))) {
				return false;
			}
		}
		return true;
	}
		
	public static int getNextPrimePair(int[] primePairSet, int num) {
		do {
			num = getNextPrimeNumber(num);
		} while(!isPrimePair(primePairSet, num));
		return num;
	}
	
	public static void makePrimeNumList (int num) {
		//List<Integer> list = new ArrayList<Integer>();
		for (int i=1; i<= num; i++) {
			if (isPrime(i)) {
				primeList.add(i);
				//primeSet.add(i);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] primePairSet = {3,7,109}; 
		int len = primePairSet.length;
		long startTime = System.currentTimeMillis();
		makePrimeNumList(30000); 
//		System.out.println("List size: " + primeList.size());
		int nextPrimePairNumber = getNextPrimePair(primePairSet, primePairSet[len-1]);
		long endTime = System.currentTimeMillis();
		System.out.println("Excution Time: " + (endTime - startTime) + " millisecones");
		System.out.println("Next Prime Pair Number: " + nextPrimePairNumber);
		
	}

}
