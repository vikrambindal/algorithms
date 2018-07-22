package vik.demo.sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		
		HeapSort hs = new HeapSort();
		
		int[] data = {3, 19, 1, 14, 8, 7};
		
		System.out.println("Before");
		hs.printData(data);
		
		hs.sort(data);
		
		System.out.println("\nAfter");
		hs.printData(data);
	}

	private void printData(int[] data) {
		Arrays.stream(data).forEach(d -> System.out.print("[" + d + "]"));
	}
	
	private void sort(int[] data) {
		
		int heapSize = data.length -1;
		//This will ensure our root node at index 0 is highest value and last node at length is smallest
		buildMaxHeap(data);
		while (heapSize != 0) {
			swap(data, 0, heapSize);
			heapify(data, 0, heapSize);
			//we decrease heapSize as every iteration last nodes would contain highest value
			heapSize--;
		}
	}
	
	private void buildMaxHeap(int[] data) {
		int i = (int)Math.floor((data.length-1)/2);
		
		for( ; i >= 0 ; i--) {
			heapify(data, i, data.length);
		}
	}
	
	private void heapify(int[] data, int i, int heapSize) {
		int leftIndex = 2*i + 1;
		int rightIndex = 2*i + 2;
		int largest;
		
		//Compare children with parent, i.e if left is bigger than parent
		if(leftIndex < heapSize && data[leftIndex] > data[i]) {
			largest = leftIndex;
		} else {
			largest = i;
		}
		
		//Compare children with parent, i.e if right is bigger than parent
		if(rightIndex < heapSize && data[rightIndex] > data[largest]) {
			largest = rightIndex;
		}
		
		//If largest isn't current node
		if (largest != i) {
			swap(data, i, largest);
			heapify(data, largest, heapSize);
		}
	}
	
	private void swap(int[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
}
