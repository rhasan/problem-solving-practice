package uva.array;

import java.io.InputStream;
import java.util.Scanner;



import java.io.FileInputStream;
import java.io.FileNotFoundException;


class Prob591 {

	public void solution(InputStream inStream) {
		
		Scanner in = new Scanner(inStream);
		int tc = 1;
		while(true) {
			int n = in.nextInt();
			if(n == 0) break;
			int[] stack = new int[n];
			int sum = 0;
			for(int i = 0; i < n; i++) {
				int x = in.nextInt();
				sum += x;
				stack[i] = x;
			}
			
			assert sum % n == 0;
			
			int avg = sum / n;
			
			int moves = 0;
			for(int i = 0; i < n; i++) {
				if(stack[i] > avg) moves += (stack[i]-avg);
			}
			System.out.println("Set #"+tc);
			System.out.println("The minimum number of moves is "+moves+".");
			System.out.println("");
			
			tc++;
		}
		
	}

}




class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Prob591 sol = new Prob591();

		sol.solution(new FileInputStream("input/591.txt"));
		

	}
}

//class Main {
//
//	public static void main(String[] args) /*throws FileNotFoundException*/ {
//		Prob591 sol = new Prob591();
//
//		//sol.solution(new FileInputStream("input/591.txt"));
//		sol.solution(System.in);
//
//	}
//}