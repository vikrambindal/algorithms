package vik.demo.ds.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenthesisChecker {

	public static void main(String[] args) {

		String balancedTest =  "[()]{}{[()()]()}";
		String unbalancedTest = "“[(])";
		
		ParenthesisChecker pc = new ParenthesisChecker();
		System.out.println(balancedTest + " balanced ? " + pc.testString(balancedTest));
		System.out.println(unbalancedTest + " unbalanced ? " + pc.testString(unbalancedTest));
	}
	
	private boolean testString(String word) {
		Stack<Character> st = new Stack<>();
		Map<Character, Character> memoized = new HashMap<>();
		memoized.put('}', '{');
		memoized.put(']', '[');
		memoized.put(')', '(');
		
		for ( int i = 0 ; i < word.length() ; i++ ) {
			Character currentChar = word.charAt(i);
			
			//check if stack is empty or not
			//else check if the last element inserted contains its reverse
			//if it does pop it
			//else push the new item
			if ( st.isEmpty() ) {
				st.push(currentChar);
			} else {
				Character lastInsertedItem = st.peek();
				if (memoized.get(currentChar) == lastInsertedItem) {
					st.pop();
				} else {
					st.push(currentChar);
				}
			}
		}
		return st.isEmpty();
	}

}
