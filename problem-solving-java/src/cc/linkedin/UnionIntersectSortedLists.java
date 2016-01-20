package cc.linkedin;

import java.util.ArrayList;
import java.util.List;

/**
 * Give two sorted lists List<Integer> a and List<Integer> b. 
 * Find 
 * - the Union of these two lists -> the union list should also be sorted 
 * - the Intersection of these two lists -> Intersection list should also be sorted.
 * @author Rakebul
 *
 */
public class UnionIntersectSortedLists {
	public static List<Integer> intersect(List<Integer> a, List<Integer> b) {
		List<Integer> result = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		int N = a.size()+b.size();
		for(int k = 0; k < N; k++) {
			if(i >= a.size() || j >= b.size()) break;
			else if(a.get(i) < b.get(j)) i++;
			else if(a.get(i) > b.get(j)) j++;
			else {
				result.add(a.get(i++));
				j++;
				N--;
			}
		}
		
		return result;
	}
	public static List<Integer> union(List<Integer> a, List<Integer> b) {
		
		List<Integer> result = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		int N = a.size()+b.size();
		for(int k = 0; k < N; k++) {
			if(i >= a.size()) result.add(b.get(j++));
			else if(j >= b.size()) result.add(a.get(i++));
			else if(a.get(i) < b.get(j)) result.add(a.get(i++));
			else if(a.get(i) > b.get(j)) result.add(b.get(j++));
			else {
				result.add(a.get(i++));
				j++;
				N--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(15);
		a.add(20);
		a.add(120);
		System.out.println("List a:");
		show(a);
		
		b.add(4);
		b.add(5);
		b.add(8);
		b.add(9);
		b.add(10);
		b.add(15);
		b.add(16);
		System.out.println("List b:");
		show(b);
		
		System.out.println("List a union b:");
		show(union(a, b));

		System.out.println("List a intersect b:");
		show(intersect(a, b));

	}
	public static void show(List<Integer> l) {
		for(int x:l) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
