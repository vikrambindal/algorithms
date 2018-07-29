package vik.demo.graph;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class GraphTraversal {

	public static void main(String[] args) {
		GraphTraversal gt = new GraphTraversal();
		
		Node root = gt.new Node("a");
		Node l1Left = root.addLeft(gt.new Node("b"));
		Node l1Right = root.addRight(gt.new Node("k"));
		
		Node l2Left = l1Left.addLeft(gt.new Node("c"));
		l1Left.addRight(gt.new Node("h"));
		
		Node l3Left = l2Left.addLeft(gt.new Node("d"));
		l2Left.addRight(gt.new Node("g"));
		Node l4Right = l3Left.addRight(gt.new Node("f"));
		l4Right.addRight(gt.new Node("e"));
		
		l1Right.addLeft(gt.new Node("d"));
		Node rightOfK = l1Right.addRight(gt.new Node("l"));
		rightOfK.addLeft(gt.new Node("m"));
		rightOfK.addRight(gt.new Node("n"));
		
		System.out.println("Left : ");
		gt.leftTraversal(root);
		
		System.out.println("\nRight : ");
		gt.rightTraversal(root);
		
		System.out.println("\nLeaf : ");
		gt.leafTraversal(root);
		
		System.out.println("\nLevel order : ");
		gt.levelOrderTraversal(root);
		
		System.out.println("\nVertical order : ");
		gt.verticalOrderTraversal(root);
		
		System.out.println("\nTopView bottom up : ");
		gt.topViewBottomUp(root);
		
		System.out.println("\nMaximum Depth of Vertical node : ");
		gt.maximumVerticalDepth(root);
		
		System.out.println("Height of tree : " + gt.heightOfTree(root));
		System.out.println("Size of tree: " +  gt.sizeOfTree(root));
	}
	
	private void leftTraversal(Node n) {
		if (n ==  null) {
			return;
		}
		if (n.left != null) {
			printNode(n);
			leftTraversal(n.left);
		} else if (n.right != null) {
			printNode(n);
			leftTraversal(n.right);
		}
	}
	
	private void rightTraversal(Node n) {
		if (n ==  null) {
			return;
		}
		if (n.right != null) {
			printNode(n);
			rightTraversal(n.right);
		} else if (n.left != null) {
			printNode(n);
			rightTraversal(n.left);
		}
	}
	
	private void leafTraversal(Node n) {
		if (n == null) {
			return;
		}
		
		if (n.left == null && n.right == null) {
			printNode(n);
		}
		leafTraversal(n.left);
		leafTraversal(n.right);
	}
	
	private void levelOrderTraversal(Node n) {
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(n);
		
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			printNode(node);
			if (node.left != null) {
				queue.add(node.left);
			}
			
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}
	
	private void verticalOrderTraversal(Node n) {
		
		Queue<Node> queue = new LinkedList<>();
		Map<Integer, String> distanceToNodeMap = new Hashtable<>();
		
		queue.add(n);
		distanceToNodeMap.put(n.distance, n.value);
		
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			if (node.left != null) {
				node.left.distance = node.distance - 1;
				
				String value = distanceToNodeMap.containsKey(node.left.distance) ? 
								distanceToNodeMap.get(node.left.distance)  +  " " + node.left.value
								: node.left.value;
					distanceToNodeMap.put(node.left.distance, value);
				queue.add(node.left);
			}
			
			if (node.right != null) {
				node.right.distance = node.distance + 1;
				
				String value = distanceToNodeMap.containsKey(node.right.distance) ? 
						distanceToNodeMap.get(node.right.distance) +  " " + node.right.value 
						: node.right.value;
				distanceToNodeMap.put(node.right.distance, value);
				queue.add(node.right);
			}
		}
		
		System.out.println(distanceToNodeMap);
	}
	
	private void topViewBottomUp(Node n) {
		Queue<Node> queue = new LinkedList<>();
		Map<Integer, String> distanceToNodeMap = new TreeMap<>();
		
		queue.add(n);
		distanceToNodeMap.put(n.distance, n.value);
		
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			if (node.left != null) {
				node.left.distance = node.distance - 1;
				
				String value = distanceToNodeMap.containsKey(node.left.distance) ? 
								distanceToNodeMap.get(node.left.distance)
								: node.left.value;
					distanceToNodeMap.put(node.left.distance, value);
				queue.add(node.left);
			}
			
			if (node.right != null) {
				node.right.distance = node.distance + 1;
				
				String value = distanceToNodeMap.containsKey(node.right.distance) ? 
						distanceToNodeMap.get(node.right.distance)
						: node.right.value;
				distanceToNodeMap.put(node.right.distance, value);
				queue.add(node.right);
			}
		}
		
		System.out.println(distanceToNodeMap);
	}
	
	private void maximumVerticalDepth(Node n) {
		Queue<Node> queue = new LinkedList<>();
		Map<Integer, Integer> distanceToNodeCountMap = new Hashtable<>();
		
		int maximum = 1;
		queue.add(n);
		distanceToNodeCountMap.put(n.distance, maximum);
		
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			if (node.left != null) {
				node.left.distance = node.distance - 1;
				
				int value = distanceToNodeCountMap.containsKey(node.left.distance) ? 
								distanceToNodeCountMap.get(node.left.distance)
								: 0;
				++value;
				if (value > maximum) {
					maximum = value;
				}
				distanceToNodeCountMap.put(node.left.distance, value);
				queue.add(node.left);
			}
			
			if (node.right != null) {
				node.right.distance = node.distance + 1;
				
				int value = distanceToNodeCountMap.containsKey(node.right.distance) ? 
						distanceToNodeCountMap.get(node.right.distance)
						: 0;
				++value;
				if (value > maximum) {
					maximum = value;
				}
				distanceToNodeCountMap.put(node.right.distance, value);
				queue.add(node.right);
			}
		}
		
		System.out.println(maximum);
		System.out.println(distanceToNodeCountMap);
	}
	
	private int heightOfTree(Node n) {
		if (n == null) {
			return 0;
		}
		
		int heightLeft = heightOfTree(n.left);
		int heightRight = heightOfTree(n.right);
		int height = 1 +  Math.max(heightLeft, heightRight);
		return height;
	}
	
	private int sizeOfTree(Node n) {
		if (n == null) {
			return 0;
		}
		
		int heightLeft = sizeOfTree(n.left);
		int heightRight = sizeOfTree(n.right);
		int height = 1 +  heightLeft + heightRight;
		return height;
	}
	
	private void printNode(Node n) {
		System.out.print(" " + n + " ");
	}

	class Node {
		
		Node left;
		Node right;
		String value;
		int distance;
		
		public Node(String string) {
			value = string;
		}
		
		public Node addLeft(Node n) {
			left = n;
			return left;
		}
		
		public Node addRight(Node n) {
			right = n;
			return right;
		}
		
		@Override
		public String toString() {
			return value;
		}
	}
}
