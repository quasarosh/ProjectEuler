package rosh.projecteuler.incomplete;

import java.util.ArrayList;
import java.util.List;



public class LargestIntegerDivisibleByTwoIntegers {

	public static boolean isDivisible(int p, int q, int num) {
		if (num <= 0) return false;
        if (num%p != 0 || num%q != 0) return false; 
		
		boolean pFlag = false;
		boolean qFlag = false;
		
        while (num%p == 0) {
        	num /= p;
        	pFlag = true;
        }
        
        while (num%q == 0) {
        	num /= q;
        	qFlag = true;
        }
        
        if (num == 1 && pFlag && qFlag) return true;
        return false;
	}
	
	public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        }
        
        for (int i=2; i<= Math.sqrt(n)+1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
	
	public static int findLargestIntegerDivisibleByTwoIntegers(int p, int q, int num) {
		int largest = 0;
		for (int i=num; i>=0; i--) {
			if (isDivisible(p, q, i)) {
				largest = i;
				break;
			}
		}
		return largest;
	}
	
	public static List<Integer> makePrimeNumList (int num) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i=1; i<= num; i++) {
			if (isPrime(i)) {
				list.add(i);
			}
		}
		return list;
	}
	
	public static List<List<Integer>> makePrimeCombinationList (List<Integer> primes, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		findCombinations(primes, n, 0, list, res);
		return res;
	}
	
	private static void findCombinations(List<Integer> primes, int n, int curr, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == n) {
			res.add(new ArrayList<Integer>(list));
			//System.out.println("[" + list.get(0) + "," + list.get(1) + "]");
			
			return;
		}
		
		for (int i=curr; i<primes.size(); i++) {
			list.add(primes.get(i));
			findCombinations(primes, n, i+1, list, res);
			list.remove(list.size()-1);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 10000;
		long startTime = System.currentTimeMillis();
		List<Integer> primeList = LargestIntegerDivisibleByTwoIntegers.makePrimeNumList(num);
		List<List<Integer>> primeCombList = LargestIntegerDivisibleByTwoIntegers.makePrimeCombinationList(primeList, 2);
		System.out.println("Size: " + primeCombList.size());

		int sum = 0;
		for (List<Integer> pl: primeCombList) {
			sum += LargestIntegerDivisibleByTwoIntegers.findLargestIntegerDivisibleByTwoIntegers(pl.get(0), pl.get(1), num);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Excution Time: " + (endTime - startTime) + " millisecones");
		System.out.println("Sum: " + sum);
		//int largest = LargestIntegerDivisibleByTwoIntegers.findLargestIntegerDivisibleByTwoIntegers(2, 3, 100);
		//System.out.println("Largest: " + largest);
		
	}

}
