package leetcode专题;

import java.util.Arrays;

public class 下一个排序 {
	public static void main(String[] args) {
//		int[] nums = {6,2,7,3,2,1};
		int[] nums = {3,2,1};
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
	public static void nextPermutation(int[] nums) {
		int[] subNum = new int[nums.length];
		subNum[0] = nums[nums.length-1];
		int total = 1;
//		boolean flag = false;
		for(int i=nums.length-2;i>=0;i--) {
			if(nums[i]>=subNum[total-1]) {
				subNum[total++]=nums[i];
			}else {
				for(int y=total-1;y>=0;y--) {
					if(y==0||(nums[i]<subNum[y]&&nums[i]>=subNum[y-1])) {
						int term = subNum[y];
						subNum[y] = nums[i];
						nums[i] = term; 
						for(int k=0;k<total;k++) {
							nums[k+i+1]=subNum[k];
						}
						return;
					}
				}
			}
		}
//		System.out.print("[");
//		for(int i=nums.length-1;i>0;i--) {
//			System.out.print(nums[i]+",");
//		}
//		System.out.println(nums[0]+"]");
		for(int i=0;i<nums.length;i++) {
			nums[i] = subNum[i];
		}
		return;
	}
}
