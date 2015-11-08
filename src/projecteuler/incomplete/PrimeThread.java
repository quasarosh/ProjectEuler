package projecteuler.incomplete;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;



public class PrimeThread implements Runnable {

	private int sum; 
	private int target;
	private int start;
	private int end;
	private List<List<Integer>> pl;
	
	@Override
	public void run() {
		final AtomicInteger atmSum = new AtomicInteger(sum);
		//System.out.println("p:" + pl.get(0) + ", q: " + pl.get(1));
		//for (List<Integer> list: pl) {
		for (int i=start; i<end; i++) {
			if (i == start) System.out.println("p: " + pl.get(i));
			List<Integer> list = pl.get(i);
			//int tmp = LargestIntegerDivisibleByTwoIntegers.findLargestIntegerDivisibleByTwoIntegers(list.get(0), list.get(1), target);
			atmSum.getAndAdd(LargestIntegerDivisibleByTwoIntegers.findLargestIntegerDivisibleByTwoIntegers(list.get(0), list.get(1), target));
			//System.out.println("atmSum: " + atmSum + ", tmp: " + tmp);
		}
		sum = atmSum.intValue();
		//System.out.println("Done! Sum: " + sum);
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	public int getSum() {
		return sum;
	}
	
	public void setPrimeList(List<List<Integer>> primeList) {
		pl = primeList;
	}
	
	public void setTarget(int target) {
		this.target = target;
	}

}
