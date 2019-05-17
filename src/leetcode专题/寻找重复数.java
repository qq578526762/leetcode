package leetcode专题;

public class 寻找重复数 {
	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2};
		System.out.println(findDuplicate(nums));
	}

	public static int findDuplicate(int[] nums) {
		int fast = 0;
		int slow = 0;
		while(true) {
			fast = nums[nums[fast]];
			slow = nums[slow];
			if(fast==slow) {
				fast = 0;
				while(true) {
					if(nums[fast]==nums[slow]) {
						return nums[fast];
					}else {
						fast = nums[fast];
						slow = nums[slow];
					}
				}
			}
		}
	}
}
