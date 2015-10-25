package sedgewick.sorting;

import java.util.Comparator;

public class Insertion {
	private Insertion() {
	}
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 0; i < N; i++) {
			for(int j = i; j > 0 ; j--) {
				if(less(a[j], a[j-1])) {
					exch(a, j, j-1);
				}
				else break;
			}
		}
	}
	public static void sort(Object[] a, Comparator cmp) {
		int N = a.length;
		for(int i = 0; i < N; i++) {
			for(int j = i; j > 0 ; j--) {
				if(less(cmp, a[j], a[j-1])) {
					exch(a, j, j-1);
				}
				else break;
			}
		}
	}

	/***************************************************************************
	 *  Helper sorting functions.
	 ***************************************************************************/

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	// is v < w ?
	private static boolean less(Comparator c, Object v, Object w) {
		return c.compare(v, w) < 0;
	}


	// exchange a[i] and a[j]
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}


	/***************************************************************************
	 *  Check if array is sorted - useful for debugging.
	 ***************************************************************************/

	// is the array a[] sorted?
	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	// is the array sorted from a[lo] to a[hi]
	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i-1])) return false;
		return true;
	}

	// is the array a[] sorted?
	private static boolean isSorted(Object[] a, Comparator c) {
		return isSorted(a, c, 0, a.length - 1);
	}

	// is the array sorted from a[lo] to a[hi]
	private static boolean isSorted(Object[] a, Comparator c, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(c, a[i], a[i-1])) return false;
		return true;
	}	
}
