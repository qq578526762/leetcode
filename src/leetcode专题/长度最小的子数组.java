package leetcode专题;

public class 长度最小的子数组 {
	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7,null));
	}

	public static  int minSubArrayLen(int s, int[] nums) {
		if(nums==null) {
			return 0;
		}
		int min = nums.length;
		int sum=0;
		int start = 0;
		int end = 0;
		boolean flag = false;
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			end = i;
			if(sum>=s) {
				flag = true;
				while(sum-nums[start]>=s) {
					sum = sum-nums[start];
					start++;
				}	
				if(end-start<min) {
					min = end-start+1;
				}
			}
			
		}
		return flag?min:0;
	}
}
