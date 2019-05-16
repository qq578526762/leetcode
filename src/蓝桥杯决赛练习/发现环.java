package 蓝桥杯决赛练习;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class 发现环 {
	public static boolean flag = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		int[][] nums = new int[n][2];
		for(int i=0;i<n;i++) {
			nums[i][0] = sc.nextInt();
			nums[i][1] = sc.nextInt();
		}
		Arrays.sort(nums, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0]==0?o1[1]-o2[1]:o1[0]-o2[0];
			}
		});
		HashMap<Integer,int[]> map = new HashMap<Integer,int[]>();
		int start = 0;
		int end = 0;
		int num = nums[0][0];
		for(int i=1;i<n;i++) {
			if(i==n-1) {
				int[] o = new int[2];
				o[0] = start;
				o[1] = i;
				map.put(num, o);
				if(num<nums[i][0]) {
					o[0] = i;
					o[1] = i;
					map.put(nums[i][0], o);
				}
			}else if(num<nums[i][0]) {
				end=i;
				int[] o = new int[2];
				o[0] = start;
				o[1] = end-1;
				map.put(num, o);
				start = end;
				num = nums[i][0];
			}
		}
		System.out.println("123");
	}
	
}
