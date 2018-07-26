package vik.demo.ds.string;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseEntireString {

	public static void main(String[] args) {
		String test1 = "i.like.this.program.very.much";
		String test2 = "pgr.mno";

		ReverseEntireString res = new ReverseEntireString();
		System.out.println("Reversing " + test1 + ": " +  res.reverse(test1));
		System.out.println("Reversing " + test2 + ": " +  res.reverse(test2));
	};
	
	private String reverse(String input) {
		
		StringTokenizer strToken = new StringTokenizer(input, ".");
		Stack<String> temp = new Stack<>();
		while(strToken.hasMoreTokens()) {
			temp.add(strToken.nextToken());
		}
		
		input = "";
		while (!temp.isEmpty()) {
			input += temp.pop();
			input += ".";
		}
		
		return input.substring(0, input.length()-1);
	}

}
