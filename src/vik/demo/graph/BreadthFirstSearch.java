package vik.demo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

	public static void main(String[] args) {
		
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		
		Node rootNode = bfs.new Node(1);
			Node cn1 = bfs.new Node(11);
				Node cn11 = bfs.new Node(111);
					Node cn111 = bfs.new Node(1111);
				Node cn12 = bfs.new Node(112);
				Node cn13 = bfs.new Node(113);
			Node cn2 = bfs.new Node(21);
				Node cn21 = bfs.new Node(211);
				Node cn22 = bfs.new Node(221);
					Node cn221 = bfs.new Node(2211);
				Node cn23 = bfs.new Node(231);
			Node cn3 = bfs.new Node(31);
				Node cn31 = bfs.new Node(311);
					Node cn311 = bfs.new Node(3111);
				Node cn32 = bfs.new Node(321);
				Node cn33 = bfs.new Node(331);
					Node cn331 = bfs.new Node(3311);
		
		cn11.addNodes(Arrays.asList(cn111));
		cn22.addNodes(Arrays.asList(cn221));
		cn31.addNodes(Arrays.asList(cn311));
		cn33.addNodes(Arrays.asList(cn331));
		cn1.addNodes(Arrays.asList(cn11, cn12, cn13));
		cn2.addNodes(Arrays.asList(cn21, cn22, cn23));
		cn3.addNodes(Arrays.asList(cn31, cn32, cn33));
		rootNode.addNodes(Arrays.asList(cn1, cn2, cn3));
		
		System.out.println("Traversing:");
		bfs.traverse(rootNode);
		System.out.println("\nSearching for existing node: ");
		bfs.searchForNode(rootNode, cn311);
		System.out.println("\nSearching for random node: ");
		bfs.searchForNode(rootNode, bfs.new Node(999));
	}

	public void traverse(Node startNode) {
		
		Queue<Node> queue = new LinkedList<>();
		
		startNode.getChildNodes().forEach(childNode -> queue.add(childNode));
		
		System.out.print(startNode);
		
		while (!queue.isEmpty()) {
			Node currentNode = queue.remove();
			
			System.out.print(currentNode);
			
			if (!currentNode.getChildNodes().isEmpty()) {
				queue.addAll(currentNode.getChildNodes());
			}
		}
	}
	
	public boolean searchForNode(Node startNode, Node searchNode) {
		int iterations = 0;
		boolean found = false;
		
		if (startNode.equals(searchNode)) {
			found = true;
		}
		
		Queue<Node> queue = new LinkedList<>();
		
		startNode.getChildNodes().forEach(childNode -> queue.add(childNode));

		while (!queue.isEmpty()) {
			iterations++;
			//This will retrieve not remove
			Node currentNode = queue.remove();
			
			if (currentNode.equals(searchNode)) {
				found = true;
				break;
			}
			
			if (!currentNode.getChildNodes().isEmpty()) {
				queue.addAll(currentNode.getChildNodes());
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
