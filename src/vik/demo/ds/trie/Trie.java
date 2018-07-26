package vik.demo.ds.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	public static void main(String[] args) throws Exception {
		String[] words = { "atom", 
							"attention",
							"attribute",
							"attrition",
							"attitude",
							"arrest",
							"argo",
							"errand",
							"attack",
							"error",
							"eradicate",
							"erroneous",
							"eat"
						};
	
		Trie tr = new Trie();
		TrieNode rootNode = tr.new TrieNode();
		
		System.out.println("Creating dictonary");
		for( int w = 0 ; w < words.length ; w++) {
			tr.insert(words[w], rootNode);
		}
		System.out.println(rootNode);
		
		System.out.println("Searching in dictionary for word");
		System.out.println("Any word starting with att ? " + tr.startsWith("att", rootNode));
		System.out.println("Any word starting with xyz ? " + tr.startsWith("xyz", rootNode));
		System.out.println("Any word starting with ate ? " + tr.startsWith("ate", rootNode));
		
		System.out.println("Word arrest exists ? " + tr.search("arrest", rootNode));
		System.out.println("Word arrested exists ? " + tr.search("arrested", rootNode));
		System.out.println("Word rambo exists ? " + tr.search("rambo", rootNode));
		System.out.println("Word eatery exists ? " + tr.search("eatery", rootNode));
		System.out.println("Word eat exists ? " + tr.search("eat", rootNode));
		
		System.out.println("Suggested Words for att ? " );
		tr.suggestedWords("att", rootNode);
	}
	
	private void insert(String word, TrieNode node) {
		TrieNode current = node;
		for (int i = 0 ; i < word.length() ; i++) {
			Character character = word.charAt(i);
			Map<Character, TrieNode> children = current.children;
			
			//If current node has no children, then create children
			children.putIfAbsent(character, new TrieNode());
			current = children.get(character);
		}
		current.endOfWord = true;
	}

	public boolean startsWith(String startsWithWord, TrieNode node) {
		
		boolean prefixExists = true;
		TrieNode current = node;
		
		for (int i = 0 ; i < startsWithWord.length() ; i++) {
			Map<Character, TrieNode> children = current.children;
			
			if (!children.containsKey(startsWithWord.charAt(i))) {
				prefixExists = false;
				break;
			}
			current = children.get(startsWithWord.charAt(i));
		}
		return prefixExists;
	}
	
	public boolean search(String word, TrieNode node) {
		
		boolean wordExists = true;
		TrieNode current = node;
		
		for (int i = 0 ; i < word.length() ; i++) {
			Map<Character, TrieNode> children = current.children;
			
			if (!children.containsKey(word.charAt(i))) {
				wordExists = false;
				break;
			}
			current = children.get(word.charAt(i));
		}
		
		//Ensures full word is matched and not partially
		wordExists = wordExists && current.endOfWord;
		return wordExists;
	}
	
	public void suggestedWords(String word, TrieNode node) throws Exception {
		boolean prefixExists = true;
		TrieNode current = node;
		
		for (int i = 0 ; i < word.length() ; i++) {
			Map<Character, TrieNode> children = current.children;
			
			if (!children.containsKey(word.charAt(i))) {
				prefixExists = false;
				break;
			}
			current = children.get(word.charAt(i));
		}
		
		if (prefixExists) {
			//for (Character c: current.children.keySet()) {
				recurse(word, current);
			//}
				
		} else {
			throw new Exception("No words found that potentially match");
		}
	}
	
	private void recurse(String word, TrieNode current) {
		if (current.endOfWord) {
			System.out.println(word);
			return;
		}
		
		for (Character c: current.children.keySet()) {
			recurse(word+c, current.children.get(c));
		}
	}
	
	class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;
		
		public TrieNode() {
			children = new HashMap<Character, TrieNode>();
			endOfWord = false;
		}
		
		public void addNode(Character c) {
			 TrieNode newNode = new TrieNode();
			 children.put(c, newNode);
		}
		
		@Override
		public String toString() {
			return children.toString();
		}
	}
}
