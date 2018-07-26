package vik.demo.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort msort = new MergeSort();
		int[] data = {5, 9, 3, 1, 2, 8, 4, 7, 6, 0}; 
		
		System.out.println("Before");
		System.out.println("Left : " + Arrays.toString(data));
		
		msort.sort(data);
		
		System.out.println("After");
		System.out.println("Left : " + Arrays.toString(data));
	}
	
	public void sort(int[] data) {
		
		if (data.length == 1) {
			return;
		}
		
		int middleIndex = (int) Math.floor((data.length)/2);
		int [] leftSide = Arrays.copyOfRange(data, 0, middleIndex);
		int [] rightSide = Arrays.copyOfRange(data, middleIndex, data.length);
		
		//Split items recursively in left
		sort(leftSide);
		//Split items recursively in right
		sort(rightSide);
		
		//When the items are broken down to length of 1 merge them
		merge( leftSide, rightSide, data );
		
	}
	
	private void merge(int[] leftSide, int[] rightSide, int[] data) {
		//System.out.println("Left : " + Arrays.toString(leftSide));
		//System.out.println("Right : " + Arrays.toString(rightSide));
		
		int numOfLeftElements = leftSide.length;
		int numOfRightElements = rightSide.length;
		
		int leftIdx = 0 , rightIdx = 0, dataIdx = 0;
		
		while (leftIdx < numOfLeftElements && rightIdx < numOfRightElements) {
			
			int dataLeft = leftSide[leftIdx];
			int dataRight = rightSide[rightIdx];
			if (dataLeft > dataRight) {
				data[dataIdx] = rightSide[rightIdx];
				rightIdx++;
			} else {
				data[dataIdx] = leftSide[leftIdx];
				leftIdx++;
			}
			dataIdx++;
		}
		
		//fill the remainders that couldnt be processed
		while (leftIdx < numOfLeftElements) {
			data[dataIdx] = leftSide[leftIdx];
			leftIdx++;
			dataIdx++;
		}
		
		while (rightIdx < numOfRightElements) {
			data[dataIdx] = rightSide[rightIdx];
			rightIdx++;
			dataIdx++;
		}
		
		//System.out.println("Merged : " + Arrays.toString(data));
	}
}
