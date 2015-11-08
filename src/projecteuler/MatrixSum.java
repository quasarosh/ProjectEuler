package projecteuler;

import java.util.HashMap;
import java.util.Map;


public class MatrixSum {

	private static int maxSum = 0; 
	
	public static int matrixSum(int[][] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] colForRow = new int[nums.length];
		matrixSum(nums, 0, 0, colForRow);
		return maxSum;
	}
	
	private static int matrixSum(int[][] nums, int sum, int level, int[] colForRow) {
		if (level == nums[0].length) {	
			System.out.println("Return sum... sum: " + sum);
			maxSum = Math.max(sum,  maxSum);
			return sum;
		}
		
		for (int i=0; i<nums.length; i++) {
			if (isValid(colForRow, level, i+1)) {
				sum += nums[level][i];
				System.out.println("row: " + level + ", col: " + i + ", sum: " + sum);
				colForRow[level] = i+1;
				sum = matrixSum(nums, sum, level+1, colForRow);
				maxSum = Math.max(sum, maxSum);
				System.out.println("## Sum: " + sum + ", maxSum: " + maxSum);
				colForRow[level] = 0;
			}
		}
		System.out.println("Bye Bye...");
		return 0;
	}
	
	private static boolean isValid (int[] colForRow, int row, int curCol) {
		for (int i=0; i<row; i++) {
            int diff = Math.abs(colForRow[i] - curCol);
            if (diff == 0) return false;
        }
        return true;
 	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[][] nums = {
//				{7,53,183,439,863}, 
//				{497,383,563,79,973}, 
//				{287,63,343,169,583}, 
//				{627,343,773,959,943}, 
//				{767,473,103,699,303}
//		};
		
		int[][] nums = {
				{2,1,3},
				{4,2,5}, 
				{2,7,1}
		};
		
		int sum = MatrixSum.matrixSum(nums);
		System.out.println("Sum: " + sum);

	}

}
