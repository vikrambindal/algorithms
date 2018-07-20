package vik.demo.sort;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		
		int[] data = {5, 9, 3, 1, 2, 8, 4, 7, 6, 0};  
		
		System.out.println("Before: ");
		ms.printData(data);
		
		System.out.println();
		ms.sort(data);
		
		System.out.println("\nAfter: ");
		ms.printData(data);
	}
	
	private void printData(int[] data) {
		Arrays.stream(data).forEach(System.out::print);
	}
	
	public void sort(int[] data) {
		
		if (data.length == 1) {
			return;
		}
		
		int[] leftSide = slice(data, 0, data.length/2, data.length/2);
		int[] rightSide = slice(data, (data.length/2), data.length, data.length - data.length/2);
		
		sort(leftSide);
		sort(rightSide);
		
		merge(leftSide, rightSide, data);
	}
	
	private void merge(int[] leftSide, int[] rightSide, int[] data) {
		
		int numOfElementsLeft = leftSide.length;
		int numOfElementsRight = rightSide.length;
		int i= 0,j = 0, k=0;
		
		while ( i < numOfElementsLeft && j < numOfElementsRight) {
			
			if (leftSide[i] < rightSide[j]) {
				data[k] = leftSide[i];
				++i;
			} else {
				data[k] = rightSide[j];
				++j;
			}
			++k;
		}
		
		//fill leftovers from left
		while( i< numOfElementsLeft) {
			data[k] = leftSide[i];
			++i;
			++k;
		}

		//fill leftovers from right
		while( j < numOfElementsRight) {
			data[k] = rightSide[j];
			++j;
			++k;
		}
	}
	
	private int[] slice(int[] data, int start, int end, int arraySize) {
		int [] slicedArray = new int[arraySize];
		
		for (int i = 0 ; i < arraySize ; i++ ) {
			slicedArray[i] = data[start+i];
		}
		return slicedArray;
	}
}