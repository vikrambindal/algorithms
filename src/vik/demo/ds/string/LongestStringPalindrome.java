package vik.demo.ds.string;

public class LongestStringPalindrome {

	public static void main(String[] args) {
		LongestStringPalindrome lsp = new LongestStringPalindrome();
		
		String input = "aaabbaa";
		String largestWord = "";
		for (int i = 0 ; i < input.length() ; i++) {
			String word = input.substring(i, input.length());
			if(lsp.isPalindrome(word)) {
				largestWord = word;
				break;
			}
		}
		
		System.out.println("Largest Palindrome : " + (largestWord.isEmpty() ? " not found " : largestWord));
	}

	private boolean isPalindrome(String word) {
		String original = word;
		int start = 0;
		int end = word.length() -1;
		
		char[] chars = word.toCharArray();
		for (int i = 0; i < chars.length ; i++) {
			int src = chars[start];
			int dest = chars[end];
			
			if (start <= end) {
				src = src  + dest;
				dest = src - dest;
				src = src - dest;
				
				chars[start] = (char)src;
				chars[end] = (char)dest;
				
				start++;
				end--;
			}
		}
		
		
		return original.equals(new String(chars));
	}
}
