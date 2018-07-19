package vik.demo.sort;

import java.util.Arrays;

public class SelectionSort implements Sort {

	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();
		
		int[] data = {5, 9, 3, 1, 2, 8, 4, 7, 6, 0};  
		
		System.out.println("Before: ");
		ss.printData(data);
		
		ss.sort(data);
		
		System.out.println("\nAfter: ");
		ss.printData(data);
	}
	
	private void printData(int[] data) {
		Arrays.stream(data).forEach(System.out::print);
	}
	
	public StatisticsDTO sort(int[] data) {
		int iterations = 0;
		int swaps = 0;
		
		long startTime =  System.nanoTime();
		
		for ( int i = 0 ; i < data.length ; i++ ) {
			int minIdx = i;
			iterations++;
			for ( int j = i+1; j < data.length ; j++) {
				iterations++;
				
				if (data[j] < data[minIdx]) {
					minIdx = j;
				}
			}
			
			int temp = data[minIdx];
			data[minIdx] = data[i];
			data[i] =  temp;
			swaps++;
		}
		long endTime =  System.nanoTime();
		return new StatisticsDTO(iterations, swaps, endTime-startTime);
	}
}
