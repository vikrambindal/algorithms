package vik.demo.sort;

import java.util.Arrays;

public class InsertionSort implements Sort {
	
	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		
		int[] data = {5, 9, 3, 1, 2, 8, 4, 7, 6, 0};  
		
		System.out.println("Before: ");
		is.printData(data);
		
		System.out.println();
		is.sort(data);
		
		System.out.println("\nAfter: ");
		is.printData(data);
	}
	
	private void printData(int[] data) {
		Arrays.stream(data).forEach(System.out::print);
	}
	
	public StatisticsDTO sort(int[] data) {
		int iterations = 0;
		int swaps = 0;
		
		long startTime =  System.nanoTime();
		
		for ( int i = 0 ; i < data.length ; i++ ) {
			int currentUnsortedItem = data[i];
			iterations++;
			for ( int j = i ; j > 0 ; j--) {
				iterations++;
				if (currentUnsortedItem < data[j-1]) {
					data[j] = data[j-1];
					data[j-1]= currentUnsortedItem;
					swaps++;
				}
			}
		}
		long endTime =  System.nanoTime();
		return new StatisticsDTO(iterations, swaps, endTime-startTime);
	}
}
