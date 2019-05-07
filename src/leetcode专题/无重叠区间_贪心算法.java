package leetcode专题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class 无重叠区间_贪心算法 {
	public static void main(String[] args) {
//		int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
		int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
		System.out.println(eraseOverlapIntervals(intervals));;
	}

	public static int eraseOverlapIntervals(int[][] intervals) {
		if(intervals.length==0) {
			return 0;
		}
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
			}
		});
		LinkedList<int[]> list =new LinkedList<int[]>();
		list.add(intervals[0]);
		for(int i=1;i<intervals.length;i++) {
			int[] val = list.getLast();
			if(val[0]!=intervals[i][0]) {
				if(val[1]<=intervals[i][0]) {
					list.add(intervals[i]);
				}else if(val[1]>intervals[i][1]){
					list.removeLast();
					list.add(intervals[i]);
				}
			}
		}
		return intervals.length-list.size();
	}
}
