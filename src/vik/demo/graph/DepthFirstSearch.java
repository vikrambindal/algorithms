package vik.demo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

	public static void main(String[] args) {
		
		DepthFirstSearch dfs = new DepthFirstSearch();
		
		Node rootNode = dfs.new Node(1);
			Node cn1 = dfs.new Node(11);
				Node cn11 = dfs.new Node(111);
					Node cn111 = dfs.new Node(1111);
				Node cn12 = dfs.new Node(112);
				Node cn13 = dfs.new Node(113);
			Node cn2 = dfs.new Node(21);
				Node cn21 = dfs.new Node(211);
				Node cn22 = dfs.new Node(221);
					Node cn221 = dfs.new Node(2211);
				Node cn23 = dfs.new Node(231);
			Node cn3 = dfs.new Node(31);
				Node cn31 = dfs.new Node(311);
					Node cn311 = dfs.new Node(3111);
				Node cn32 = dfs.new Node(321);
				Node cn33 = dfs.new Node(331);
					Node cn331 = dfs.new Node(3311);
		
		cn11.addNodes(Arrays.asList(cn111));
		cn22.addNodes(Arrays.asList(cn221));
		cn31.addNodes(Arrays.asList(cn311));
		cn33.addNodes(Arrays.asList(cn331));
		cn1.addNodes(Arrays.asList(cn11, cn12, cn13));
		cn2.addNodes(Arrays.asList(cn21, cn22, cn23));
		cn3.addNodes(Arrays.asList(cn31, cn32, cn33));
		rootNode.addNodes(Arrays.asList(cn1, cn2, cn3));
		
		System.out.println("Traversing:");
		dfs.traverse(rootNode);
		System.out.println("\nSearching for existing node: ");
		dfs.searchForNode(rootNode, cn311);
		System.out.println("\nSearching for random node: ");
		dfs.searchForNode(rootNode, dfs.new Node(999));
	}

	public void traverse(Node startNode) {
		
		Stack<Node> stack = new Stack<>();
		
		startNode.getChildNodes().forEach(childNode -> stack.add(childNode));
		
		System.out.print(startNode);
		
		while (!stack.isEmpty()) {
			Node currentNode = stack.pop();
			
			System.out.print(currentNode);
			
			if (!currentNode.getChildNodes().isEmpty()) {
				stack.addAll(currentNode.getChildNodes());
			}
		}
	}
	
	public boolean searchForNode(Node startNode, Node searchNode) {
		int iterations = 0;
		boolean found = false;
		
		if (startNode.equals(searchNode)) {
			found = true;
		}
		
		Stack<Node> stack = new Stack<>();
		
		startNode.getChildNodes().forEach(childNode -> stack.add(childNode));

		while (!stack.isEmpty()) {
			iterations++;
			Node currentNode = stack.pop();
			
			if (currentNode.equals(searchNode)) {
				found = true;
				break;
			}
			
			if (!currentNode.getChildNodes().isEmpty()) {
				stack.addAll(currentNode.getChildNodes());
			}
		}
		
		System.out.println("Found: " + found + " , Iterations: " + iterations);
		return found;
	}
	
	class Node {
		
		int value;
		List<Node> childNodes = new ArrayList<>();
		
		public Node(int value) {
			this.value = value;
		}

		public void addNodes(List<Node> nodes) {
			childNodes.addAll(nodes);
		}
		
		public List<Node> getChildNodes() {
			return childNodes;
		}

		@Override
		public String toString() {
			return " [ " + value + " ] ";
		}
	}
}
