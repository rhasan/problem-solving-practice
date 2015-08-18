package uva.numbertheory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Prob543 {
	public void solution(InputStream inStream) {
		Scanner in = new Scanner(inStream);
		
		
		SieveArray sieve = new SieveArray(1000000);
		
		
		while(in.hasNext()) {
			int n = in.nextInt();
			if(n == 0) break;
			if(n%2!=0) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
			List<Integer> primes = new ArrayList<Integer>();
			for(int i = 0; sieve.getIthPrime(i)<=n;i++) {
				primes.add(sieve.getIthPrime(i));
			}
			boolean soln = false;

			int j=primes.size()-1;
			int b=primes.get(j);
			
			while(b >=primes.get(0) && j>=0) {
				int a = n-b;
				if(sieve.isPrime(a)) {
					if(n == a+b) {
						System.out.println(n+" = "+a+" + "+b);
						soln = true;
						break;
					}
				}
				j--;
				if(j<0)break;
				b=primes.get(j);
				
			}
			
			if(soln==false)
				System.out.println("Goldbach's conjecture is wrong.");
			
		}
	}

	
//	public static void main(String[] args) throws FileNotFoundException {
//		Prob543 sol = new Prob543();
//
//		FileInputStream fis = new FileInputStream("input/543.txt");
//		sol.solution(fis);
//
//	}		
}

class SieveArray {
	
	private final int MAX_LIMIT;
	private boolean[] composite;
	private List<Integer> primes;
	
	public SieveArray(int max_limit) {
		MAX_LIMIT = max_limit;
		composite = new boolean[MAX_LIMIT+1];
		composite[0] = true;
		composite[1] = true;
		
		for(int i = 2+2; i <= MAX_LIMIT; i+=2) {
			composite[i] = true;
		}
		for(long i = 3; i*i <= MAX_LIMIT; i+=2) {
			if(composite[(int)i] == false) {
				for(int j = (int) (i + i); j <= MAX_LIMIT; j += i) {
					composite[j] = true;
				}
			}
		}
		primes = new ArrayList<Integer>();
		
		for(int i = 1; i <= MAX_LIMIT; i++) {
			if(isPrime(i)) primes.add(i);
		}
	}
	
	public boolean isPrime(long x) {
		
		if(x <= MAX_LIMIT)	return !composite[(int)x];
			
		assert x > MAX_LIMIT;
		
		
		long lastPrime = primes.get(primes.size()-1);
		//if( x > lastPrime * lastPrime) throw new LimitExceededException("Maximum value can be:" + (lastPrime * lastPrime));
		assert x <= lastPrime * lastPrime;
		
		for(int i= 0 ; i < primes.size(); i++) {
			if(x % primes.get(i) == 0) return false;
		}
		return true;
	}
	
	public int getIthPrime(int i) {
		return primes.get(i);
	}
	
	

}



class Main {

	public static void main(String[] args) {
		Prob543 sol = new Prob543();

		sol.solution(System.in);

	}
}