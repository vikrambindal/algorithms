package vik.demo.ds.string;


public class StringPermutation {

	public static void main(String[] args) {
		String permutation = "ABC";
		StringPermutation sp = new StringPermutation();
		
		System.out.println("Permultations for ABC : ");
		sp.printPermutation(permutation);
	}

	public void printPermutation(String input) {
		
		char[] characters = input.toCharArray();
		int[] count = new int[characters.length];
		char[] output = new char[characters.length];
		
		for (int i = 0 ; i < characters.length ; i++) {
			count[i] = 1;
			characters[i] = input.charAt(i);
		}
		
		recurse(output, characters, count, 0);
	}
	
	private void recurse(char[] output, char[] characters, int[] count, int index) {
		
		if (index == characters.length) {
			System.out.println(output);
			return;
		}
		
		for (int i = 0 ; i < characters.length ; i++) {
			if (count[i] == 0) {
				//If the record has been processed skip then
				continue;
			}
			count[i]--;
			output[index] = characters[i];
			recurse(output, characters, count, index+1);
			count[i]++;
		}
	}
}