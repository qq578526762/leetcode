package leetcode专题;

public class 打家劫舍II_动态规划 {
	public static void main(String[] args) {
		int[] nums = {2,1,1,2};
		System.out.println(rob(nums));
	}
	
	public static int rob(int[] nums) {
		if(nums.length==0) {
			return 0;
		}
		int[] sum = nums.clone();
		if(nums.length<=3) {
			return max(nums);
		}else {
			sum[2] = nums[2]+sum[0];
			for(int i=3;i<nums.length-1;i++) {
				sum[i] = nums[i] + Math.max(sum[i-3], sum[i-2]);
			}
			int[] subSum = nums.clone();
			subSum[0] = 0;
			for(int i=3;i<nums.length;i++) {
				subSum[i] = nums[i] + Math.max(subSum[i-3], subSum[i-2]);
			}
			sum[nums.length-1]=subSum[nums.length-1];
			return Math.max(Math.max(sum[nums.length-1], sum[nums.length-2]), sum[nums.length-3]);
		}
    }
	public static int max(int[] nums) {
		int max = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>max) {
				max=nums[i];
			}
		}
		return max;
	}
}
