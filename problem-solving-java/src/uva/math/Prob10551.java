package uva.math;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.Scanner;


class Prob10551 {

	public void solution(InputStream in) {
		Scanner sc = new Scanner(in);
		while(true) {
			int b =  sc.nextInt();
			if(b == 0) break;
			
			String p = sc.next();
			String m = sc.next();
			
			BigInteger res = (new BigInteger(p, b)).mod((new BigInteger(m, b)));
			System.out.println(res.toString(b));
		}
		
	}

}


//class Main {
//
//	public static void main(String[] args) throws FileNotFoundException {
//		Prob10551 sol = new Prob10551();
//
//		sol.solution(new FileInputStream("input/10551.in"));
//		
//
//	}
//}

/** 
 * submit main
 */
class Main {

	public static void main(String[] args)  {
		Prob10551 sol = new Prob10551();
		sol.solution(System.in);

	}
}