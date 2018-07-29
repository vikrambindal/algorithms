package vik.demo.dp;

public class Fibonaci {

	public static void main(String[] args) {
		Fibonaci f = new Fibonaci();
		System.out.println("Traditional : " + f.traditionalFibonaci(5));
	}
	
	private int traditionalFibonaci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			int sum = traditionalFibonaci(n-1) + traditionalFibonaci(n-2);
			return sum;
		}
	}

}
