package sedgewick.sorting;

import java.util.Comparator;

public class Shell {

	private Shell() {
	}
	public static void sort(Comparable[] a) {
		int N = a.length;
		
		int h = 1;
		while(h < N/3) h = 3*h + 1;
		
		while(h >= 1) {
			for(int i = h; i < N; i++) {
				for(int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
					exch(a, j, j-h);
				}
			}
			assert isHsorted(a, h);
			h = h/3;
		}
		assert isSorted(a);
	}

	public static void sort(Object[] a, Comparator cmp) {
		int N = a.length;
		
		int h = 1;
		while(h < N/3) h = 3*h + 1;
		
		while(h >= 1) {
			for(int i = h; i < N; i++) {
				for(int j = i; j >= h && less(cmp, a[j], a[j-h]); j -= h) {
					exch(a, j, j-h);
				}
			}
			assert isHsorted(a, cmp, h);
			h = h/3;
		}
		assert isSorted(a, cmp);
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

    // is the array h-sorted?
    private static boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++)
            if (less(a[i], a[i-h])) return false;
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
    // is the array h-sorted?
    private static boolean isHsorted(Object[] a, Comparator c, int h) {
        for (int i = h; i < a.length; i++)
            if (less(c, a[i], a[i-h])) return false;
        return true;
    }
}
