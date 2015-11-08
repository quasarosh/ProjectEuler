package projecteuler;


public class EvenFibonacciNumbers {

	public static int calculateEvenFibonacciNumbers (int target) {
		int fn = 0;
		int f1 = 1;
		int f2 = 2;
		int res = f2;
		
		while(fn < target) {
			fn = f1 + f2;
			f1 = f2;
			f2 = fn;			
			
			if (fn%2 == 0) {
				res += fn;
			}
			
		}
		return res;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		int res = EvenFibonacciNumbers.calculateEvenFibonacciNumbers(4000000);
		long endTime = System.currentTimeMillis();
		System.out.println("Excution Time: " + (endTime - startTime) + " millisecones");
		System.out.println("Even Fibonacci Numbers Sum: " + res);

	}

}
