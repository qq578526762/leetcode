package leetcode专题;

import java.util.Arrays;
import java.util.Comparator;

public class 用最少数量的箭引爆气球_贪心 {
	public static void main(String[] args) {
//		int[][] points = {{10,16}, {2,8}, {1,6},{7,12}}; 
		int[][] points = {{1,2}, {3,4}, {5,6},{7,8}}; 
		System.out.println(findMinArrowShots(points));
	}

	public static int findMinArrowShots(int[][] points) {
		if(points.length==0) {
			return 0;
		}
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
			}
		});
		int len = 1;
		int start = points[0][0];
		int end = points[0][1];
		for(int i=1;i<points.length;i++) {
			if(points[i][0]<=end) {
				start = points[i][0];
				end = Math.min(end, points[i][1]);
			}else {
				len++;
				start = points[i][0];
				end = points[i][1];
			}
		}
		return len;
	}
}
