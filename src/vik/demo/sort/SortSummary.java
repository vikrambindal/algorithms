package vik.demo.sort;

public class SortSummary {

	public static void main(String[] args) {

		SortSummary summary = new SortSummary();
		
		Sort bs = new BubbleSort();
		Sort ss = new SelectionSort();
		Sort is = new InsertionSort();
		
		System.out.println("BubbleSort\t" + bs.sort(summary.getTestData()));
		System.out.println("SelectionSort\t" + ss.sort(summary.getTestData()));
		System.out.println("InsertionSort\t" + is.sort(summary.getTestData()));
	}

	public int[] getTestData() {
		int[] data = {5, 9, 3, 1, 2, 8, 4, 7, 6, 0};  
		return data;
	}
}
