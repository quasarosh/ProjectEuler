package projecteuler;


public class MultipliesSum {
	public static int getMultipliesSum (int num, int target) {
		int res = 0;
		for (int i=1; i*num<target; i++) {
			res += i*num;
		}
		
		return res;
	}
	
	public static int getMultipliesSum (int x, int y, int target) {
		int res = 0;
		for (int i=1; i<target; i++) {
			if (i%x == 0 || i%y == 0) {
				res += i;
			}
		}
		
		return res;
	}
	
	public static int getMultipliesSum (int[] nums, int target) {
		int res = 0;
		boolean isDivisible = false;
		for (int i=1; i<target; i++) {
			for (int j=0; j<nums.length; j++) {
				if (i%nums[j] == 0) {
					isDivisible = true;
				}
			}
			if (isDivisible) {
				res += i;
				isDivisible = false;
			}
		}
		return res;
	}	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] nums = {3,5};
		long startTime = System.currentTimeMillis();
		int result = MultipliesSum.getMultipliesSum(nums, 1000);
		long endTime = System.currentTimeMillis();
		System.out.println("Excution Time: " + (endTime - startTime) + " millisecones");
		System.out.println("Sum is " + result);
		
	}

}
