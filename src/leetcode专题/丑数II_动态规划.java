package leetcode专题;

import java.util.ArrayList;
import java.util.HashSet;

public class 丑数II_动态规划 {
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(10));
	}
	public static int nthUglyNumber(int n) {
		int[] nums = new int[n];
		nums[0] = 1;
		int p2 =0;
		int p3=0;
		int p5 =0;
		for(int i=1;i<n;i++) {
			nums[i] = Math.min(Math.min(nums[p2]*2, nums[p3]*3), nums[p5]*5);
			if(nums[i]==nums[p2]*2) p2++;
			if(nums[i]==nums[p3]*3) p3++;
			if(nums[i]==nums[p5]*5) p5++;
		}
		return nums[n-1];
	}

}
