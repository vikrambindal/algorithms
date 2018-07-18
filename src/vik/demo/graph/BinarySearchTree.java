package vik.demo.graph;

public class BinarySearchTree {

	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		Node rootNode = bst.new Node(50);
		Node nodeD = bst.new Node(45);
		Node nodeK = bst.new Node(55);
		
		Node nodeB = bst.new Node(40);
		Node nodeE = bst.new Node(46);
		Node nodeA = bst.new Node(35);
		Node nodeC = bst.new Node(41);
		Node nodeG = bst.new Node(54);
		Node nodeL = bst.new Node(56);
		Node nodeH = bst.new Node(53);
		Node nodeJ = bst.new Node(57);

										rootNode.addNode(nodeD, nodeK);
					nodeD.addNode(nodeB, nodeE);	nodeK.addNode(nodeG, nodeL);
		nodeB.addNode(nodeA, nodeC);			nodeG.addNode(nodeH, nodeJ);
														
		
		System.out.println("Pre-order:");
		bst.preorder(rootNode);
		System.out.println("\nIn-order:");
		bst.inorder(rootNode);
		System.out.println("\nPostorder:");
		bst.postorder(rootNode);
		
		System.out.println("\nSearch existing Node:");
		boolean found = bst.searchNode(rootNode, nodeC);
		if (found) {
			System.out.println("Match found");
		} else {
			System.out.println("No match found");
		}
		
		System.out.println("\nSearch random Node:");
		found = bst.searchNode(rootNode, bst.new Node(99));
		if (found) {
			System.out.println("Match found");
		} else {
			System.out.println("No match found");
		}
	}
	
	//This follows DLR
	public void preorder(Node startNode) {
		if (startNode == null) {
			return;
		}
		System.out.print(startNode);
		preorder(startNode.left);
		preorder(startNode.right);
	}
	
	//This follows LDR
	public void inorder(Node startNode) {
		if (startNode == null) {
			return;
		}
		inorder(startNode.left);
		System.out.print(startNode);
		inorder(startNode.right);
	}
	
	//This follows LRD
	public void postorder(Node startNode) {
		if (startNode == null) {
			return;
		}
		postorder(startNode.left);
		postorder(startNode.right);
		System.out.print(startNode);
	}
	
	public boolean searchNode(Node startNode, Node searchNode) {
		boolean found = false;
		if (startNode == null) {
			return false;
		} else {
			System.out.println(startNode);
			if (startNode.data == searchNode.data) {
				return true;
			}
			
			if (searchNode.data < startNode.data) {
				found = searchNode(startNode.left, searchNode);
			} else {
				found = searchNode(startNode.right, searchNode);
			}
		}
		
		return found;
	}
	
	class Node {
		
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}

		public void addNode(Node left, Node right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return " " + data + " ";
		}
	}
}
