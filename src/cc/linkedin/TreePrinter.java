package cc.linkedin;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * http://www.careercup.com/question?id=5765154941698048
 * @author rakebulh
 *
 */

public class TreePrinter {
	public static int INF = Integer.MAX_VALUE;
	enum Color {
		WHITE, GRAY, BLACK
	}
	class Node {
		int value;
		Node left;
		Node right;
		int dist;
		Color color; 
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
			this.dist = INF;
			this.color = Color.WHITE;
		}
		
	}
	
	public void printTree(Node root) {
		if(root == null) return;
		
		Queue<Node> Q = new ArrayDeque<Node>();
		Q.add(root);
		root.dist = 0;
		root.color = Color.GRAY;
		int lastPritedDist = root.dist;
		while(Q.isEmpty() == false) {
			Node u = Q.poll();
			if(lastPritedDist < u.dist) {
				System.out.println();
			}
			System.out.print(u.value);
			lastPritedDist = u.dist;
			if(u.left != null) {
				Node v1 = u.left;
				v1.dist = u.dist + 1;
				v1.color = Color.GRAY;
				Q.add(v1);
			}
			if(u.right != null) {
				Node v2 = u.right;
				v2.dist = u.dist + 1;
				v2.color = Color.GRAY;
				Q.add(v2);
			}
			u.color = Color.BLACK;
		}
	}
	
	public void processTree() {
		Node root = new Node(1, null, null);
		Node l1 = new Node(3, null, null);
		Node r1 = new Node(5, null, null);
		root.left = l1;
		root.right = r1;
		Node l1l2 = new Node(2, null, null);
		Node l1r2 = new Node(4, null, null);
		Node r1r2 = new Node(7, null, null);
		l1.left = l1l2;
		l1.right = l1r2;
		r1.right = r1r2;
		Node l1l2l3 = new Node(9, null, null);
		Node l1l2r3 = new Node(6, null, null);
		Node l1r2r3 = new Node(8, null, null);
		l1l2.left = l1l2l3;
		l1l2.right = l1l2r3;
		l1r2.right = l1r2r3;
		
		printTree(root);
		
	}
	
	public static void main(String[] args) {
		TreePrinter tp = new TreePrinter();
		tp.processTree();
	}
}
