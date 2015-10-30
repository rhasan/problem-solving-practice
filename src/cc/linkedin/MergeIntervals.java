package cc.linkedin;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
/**
 * http://www.careercup.com/question?id=5766696197423104
 * @author rakebulh
 *
 */
public class MergeIntervals {
	static class Interval implements Comparable<Interval> {

		int start;
		int end;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Interval o) {
			return start - o.start;
		}
		@Override
		public String toString() {
			
			return "["+start+", "+end+"]";
		}
		
	}
	
	public static void main(String[] args) {
		SortedSet<Interval> intervals = new TreeSet<Interval>();
		intervals.add(new Interval(0, 2));
		intervals.add(new Interval(6, 9));
		intervals.add(new Interval(10, 12));
		intervals.add(new Interval(14, 15));
		intervals.add(new Interval(16, 18));
		System.out.println("Input intervals:");
		for(Interval in:intervals) {
			System.out.println(in);
		}		
		
		Interval newInerval = new Interval(1,17);
		System.out.println("Inserting interval:"+newInerval);
		
		
		SortedSet<Interval> mergedIntervals = mergeIntervals(intervals,newInerval);
		System.out.println("Result:");
		for(Interval in:mergedIntervals) {
			System.out.println(in);
		}
		
	}

	private static SortedSet<Interval> mergeIntervals(SortedSet<Interval> intervals, Interval newInerval) {
		SortedSet<Interval> headSet = new TreeSet<Interval>(intervals.headSet(newInerval));
		SortedSet<Interval> endSortedIntervals = new TreeSet<Interval>(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.end - o2.end;
			}
		});
		endSortedIntervals.addAll(intervals);
		SortedSet<Interval> tailSet = new TreeSet<Interval>(endSortedIntervals.tailSet(newInerval));

		if(headSet.size()>0 && headSet.last().end >= newInerval.start) {
			newInerval.start = headSet.last().start;
			headSet.remove(headSet.last());
		}
		
		if(tailSet.size() > 0 && tailSet.first().start <= newInerval.end) {
			newInerval.end = tailSet.first().end;
			tailSet.remove(tailSet.first());
		}
		SortedSet<Interval> result = new TreeSet<Interval>(headSet);
		result.addAll(tailSet);
		result.add(newInerval);
		return result;
	}
}
