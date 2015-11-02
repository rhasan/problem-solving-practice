package cc.linkedin;

import java.util.Random;

/**
 * http://www.careercup.com/question?id=6211592599371776
 * @author rakebulh
 *
 */
public class ArrayShuffle {

	public static int uniform(int n) {
		Random rand = new Random();
		return rand.nextInt(n);
	}
	
	public static void shuffle(Object[] a) {
		for(int i = 0; i < a.length; i++) {
			int ri = uniform(i+1);
			exch(a, i, ri);
		}
	}
	
	private static void exch(Object[] a, int i, int ri) {
		Object t = a[i];
		a[i] = a[ri];
		a[ri] = t;
	}
	
	public static void printArray(Object[] a) {
		for(Object o:a) {
			System.out.print(o+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] a = {1,2,3,4,5,6,7,8,9,10};
		System.out.println("Before shuffle:");
		printArray(a);
		shuffle(a);
		System.out.println("After shuffle:");
		printArray(a);
	}
}
