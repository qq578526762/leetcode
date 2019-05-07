package leetcode专题;

public class 跳跃游戏 {
	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(canJump(nums));
	}
	
	public static boolean canJump(int[] nums) {
		if(nums.length==0) {
			return false;
		}
//		HashSet<Integer> set = new HashSet<Integer>()
		boolean[] dp = new boolean[nums.length];
		dp[nums.length-1]=true;
		for(int i=nums.length-2;i>=0;i--) {
			int total = i+nums[i];
			total = total>nums.length-1?nums.length-1:total;
			for(int y=total;y>i;y--) {
				if(dp[y]) {
					dp[i]=true;
					break;
				}
			}
		}
		return dp[0];
    }
}
