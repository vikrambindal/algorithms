package vik.demo.misc;

public class ArrayNumLtSum {

	public static void main(String[] args) {
		ArrayNumLtSum t = new ArrayNumLtSum();
		int[] data = { 2,4,6,8,9 };
		int sum = 14;
		int numOfPairs = 0;
		
		int start = 0;
		int end = data.length - 1;
		while ( start != end) {
			System.out.println(" data: end=" + data[end] + " ,start=" + data[start]);
			if (data[end] + data[start] < sum) {
				numOfPairs += end-start;
				t.printPairs(data, start, end);
				System.out.println(numOfPairs);
			} else {
				end--;
			}
			start++;
		}
		
		System.out.println("NumOfPairs = " + numOfPairs);
	}
	
	private void printPairs(int[] data, int start, int end) {
		for (int i = start+1; i <= end ; i++) {
			System.out.println("[" + data[start] + "," + data[i] + "]");
		}
	}
}
