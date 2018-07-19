package vik.demo.sort;

import java.util.Arrays;

public class InsertionSort {
	
	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		
		int[] data = {5, 9, 3, 1, 2, 8, 4, 7, 6, 0};  
		
		System.out.println("Before: ");
		is.printData(data);
		
		is.sort(data);
		
		System.out.println("\nAfter: ");
		is.printData(data);
	}
	
	private void printData(int[] data) {
		Arrays.stream(data).forEach(System.out::print);
	}
	
	public void sort(int[] data) {
		int iterations = 0;
		int swaps = 0;
		
		for ( int i = 0 ; i < data.length ; i++ ) {
			
		}
		
		System.out.println(String.format("\n[Iterations=%s Swaps=%s]", iterations, swaps));
	}
}
