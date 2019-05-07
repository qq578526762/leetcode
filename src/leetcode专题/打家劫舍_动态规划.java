package leetcode专题;

public class 打家劫舍_动态规划 {
	public static void main(String[] args) {
		
	}
	public static int rob(int[] nums) {
		if(nums.length==0) {
			return 0;
		}else {
			if(nums.length<3) {
				return max(nums);
			}
			int[] sum =nums.clone();
			sum[2] = sum[2]+sum[0];
			for(int i=3;i<nums.length;i++) {
				sum[i] = nums[i] + Math.max(sum[i-3], sum[i-2]);
			}
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
