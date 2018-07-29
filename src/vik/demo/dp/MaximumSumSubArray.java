package vik.demo.dp;

public class MaximumSumSubArray {

	public static void main(String[] args) {
		int[] data = {-5, 6, 7, 1, 4, -8, 16};
		
		MaximumSumSubArray msa = new MaximumSumSubArray();
		System.out.println("Brute Force: " + msa.bruteForce(data));
		System.out.println("Kadane: " + msa.kadane(data));
	}
	
	private int kadane(int[] data) {
		int currentSum = data[0];
		int globalSum = data[0];
		
		for (int i = 1 ; i < data.length ; i++) {
			currentSum = Math.max(data[i], data[i] + currentSum);
			if (currentSum > globalSum) {
				globalSum = currentSum;
			}
		}
		return globalSum;
	}
	
	private int bruteForce(int[] data) {
		int nextSum = 0;
		int highestSum = 0;
		
		for (int i = 0 ; i < data.length ; i++) {
			nextSum = 0;
			for (int j = i ; j < data.length ; j++) {
				nextSum += data[j];
				if (nextSum > highestSum) {
					highestSum = nextSum;
				}
			}
		}
		return highestSum;
	}

}
