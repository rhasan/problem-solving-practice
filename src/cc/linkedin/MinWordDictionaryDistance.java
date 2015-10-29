package cc.linkedin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class MinWordDictionaryDistance {
	public static int INF = Integer.MAX_VALUE;
	enum Color {
		WHITE, GRAY, BLACK
	}	
	class Node {
		String word;
		Color color;
		int bfsDistance;
		Node bfsParent;
		List<Node> adjacent;
	}
	List<Node> nodes = new ArrayList<Node>();
	
	
	Set<String> dict;
	public MinWordDictionaryDistance() throws FileNotFoundException {
		dict = new HashSet<String>();
		loadDictionary();
	}
	
	public void loadDictionary() throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new FileInputStream("input/words3.txt"));
		while(scanner.hasNext()) {
			String word = scanner.next().trim();
			dict.add(word);
			//System.out.println(word);
		}
		scanner.close();
	}
	
	public int substituteEditDistance(String a, String b) {
		assert a.length() == b.length();
		int len = a.length();
		//int[] dp = new int[len+1];
		
		//dp[0] = 0;
		//we just need to count the number of substitutions
		int sCount = 0;
		for(int l = 0; l <len; l++) {
			if(a.charAt(l) != b.charAt(l)) {
				sCount++;
			}
		}
		return sCount;
	}
	public void preprocess() {
		for(String word:dict) {
			Node n = new Node();
			n.word = word;
			n.color = Color.WHITE;
			n.bfsDistance = INF;
			n.bfsParent = null;
			nodes.add(n);
		}
		for(Node n: nodes) {
			n.adjacent = getAdjacents(n);
		}
	}
	
	public void bfs(String a, String b) {

		Node start = null;
		Node end = null;
		for(Node n: nodes) {
			n.color = Color.WHITE;
			n.bfsDistance = INF;
			n.bfsParent = null;
			if(n.word.equals(a))
				start = n;
			if(n.word.equals(b))
				end = n;
		}
		assert start !=null && end != null;
		System.out.println("Start: " + start.word + ", End: "+ end.word);
		
		Queue<Node> Q = new ArrayDeque<Node>();
		
		start.color = Color.GRAY;
		start.bfsDistance = 0;
		start.bfsParent = null;
		Q.add(start);
		while(Q.isEmpty() == false) {
			Node u = Q.poll();
			if(u == end) {
				break;
			}
			for(Node v: u.adjacent) {
				if(v.color == Color.WHITE) {
					v.color = Color.GRAY;
					v.bfsDistance = u.bfsDistance + 1;
					v.bfsParent = u;
					Q.add(v);
				}
			}
			u.color = Color.BLACK;
		}
		printPath(start, end);
	}
	
	private void printPath(Node start, Node end) {
		if(start == end) {
			System.out.println(start.word);
		} else if(end.bfsParent == null) {
			System.out.println("No path from "+start.word+" to "+end.word+" exists");
		}
		else {
			printPath(start, end.bfsParent);
			System.out.println(end.word);
		}
	}
	
	private List<Node> getAdjacents(Node u) {
		List<Node> adjacents = new ArrayList<Node>();
		//System.out.print("Node "+u.word);
		//System.out.print(", Adj: ");
		for(Node v: nodes) {
			
			if(substituteEditDistance(u.word, v.word) == 1) {
				adjacents.add(v);
				//System.out.print(v.word+" ");
			}
		}
		//System.out.println();		
		return adjacents;
	}	


	public void solution(String a, String b) {
		preprocess();
		bfs(a, b);
		//System.out.println(substituteEditDistance(a, b));
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		MinWordDictionaryDistance sol = new MinWordDictionaryDistance();
		sol.solution("cat","dog");
		
	}

}
