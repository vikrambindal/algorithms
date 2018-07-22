package vik.demo.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		
		int[] data = {5, 9, 3, 1, 2, 8, 4, 7, 6, 0};  
		
		System.out.println("Before: ");
		qs.printData(data);
		
		System.out.println();
		qs.sort(data);
		
		System.out.println("\nAfter: ");
		qs.printData(data);
	}
	
	private void printData(int[] data) {
		Arrays.stream(data).forEach(System.out::print);
	}
	
	public void sort(int[] data) {
		quickSort(data, 0, data.length-1);
	}
	
	private void quickSort(int[] data, int start, int end) {
		
		if (start < end) {
			int pivotIndex = partition(data, start, end);
			quickSort(data, start, pivotIndex-1);
			quickSort(data, pivotIndex+1, end);
		}
	}
	
	//this method is responsible for 
	//1. getting pivot
	//2. numbers smaller to pivot are on right
	//3. number greater to pivot are on left
	private int partition( int[] data, int start, int end) {
		
		int pivot = data[end];
		int partitionIndex = start;

		for ( int i = start ; i <= end-1 ; i++) {
			//Ensure small numbers come to the right of the pivot
			if (data[i] <= pivot) {
				int temp = data[i];
				data[i] = data[partitionIndex];
				data[partitionIndex] = temp;
				partitionIndex++;
			}
		}
		//swap the partition index data with pivot
		int temp = data[partitionIndex];
		data[partitionIndex] = data[end];
		data[end] = temp;
		
		return partitionIndex;
	}
}