package projecteuler;

// http://planetmath.org/howtofindwhetheragivennumberisprimeornot
public class LargestPrimeFactor {

	public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        }
        
        for (long i=2; i<= (long) (Math.sqrt(n))+1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
	
	public static long findLargestPrimeFactor(long num) {
		long prime = 0;
		
		for (long l=2; l<num || num > 1; l++) {
			if (num%l == 0 && isPrime(l)) {
				num = num/l;
				prime = l;
			}
			
		}
		return prime;
	}
	
	public static int find10001thPrime() {
		int count = 0;
		int index = 2;
		while (count != 10001) {
			if (isPrime(index)) {
				count++;
			}
			index++;
		}
		return index-1; 
	}
	
	public static int findNthPrime(int n) {
		int count = 0;
		int index = 2;
		while (count != n) {
			if (isPrime(index)) {
				count++;
			}
			index++;
		}
		return index-1; 
	}
	
	public static long summationOfPrimes(int n) {
		long sum = 0;
		int index = 2;
		
		while (index < n) {
			if (isPrime(index)) {
				sum += index;
			}
			index++;
		}
		
		return sum;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long num = 600851475143L;
		long startTime = System.currentTimeMillis();
		long res = LargestPrimeFactor.findLargestPrimeFactor(num);
		long endTime = System.currentTimeMillis();
		System.out.println("Excution Time: " + (endTime - startTime) + " millisecones");
		System.out.println("Largest Prime Factor: " + res);	

		System.out.println("nth prime: " + LargestPrimeFactor.findNthPrime(10001));
		
		startTime = System.currentTimeMillis();
		System.out.println("Sum: " + LargestPrimeFactor.summationOfPrimes(2000000));
		endTime = System.currentTimeMillis();
		System.out.println("Excution Time: " + (endTime - startTime) + " millisecones");
	}

}
