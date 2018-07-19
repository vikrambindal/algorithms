package vik.demo.sort;

import java.util.Arrays;

public class BubbleSort implements Sort {

	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		
		int[] data = {5, 9, 3, 1, 2, 8, 4, 7, 6, 0};  
		
		System.out.println("Before: ");
		bs.printData(data);
		
		bs.sort(data);
		
		System.out.println("\nAfter: ");
		bs.printData(data);
	}
	
	private void printData(int[] data) {
		Arrays.stream(data).forEach(System.out::print);
	}
	
	public StatisticsDTO sort(int[] data) {
		int iterations = 0;
		int swaps = 0;
		
		long startTime =  System.nanoTime();
		
		for ( int i = 0 ; i < data.length ; i++ ) {
			iterations++;
			for ( int j = 1; j < data.length - i; j++) {
				iterations++;
				
				if (data[j-1] > data[j]) {
					int temp = data[j];
					data[j] = data[j-1];
					data[j-1] = temp;
					swaps++;
				}
			}
		}
		long endTime =  System.nanoTime();
		return new StatisticsDTO(iterations, swaps, endTime-startTime);
	}
}
