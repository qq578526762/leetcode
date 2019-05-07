package leetcode专题;

public class 摆动序列 {
	public static void main(String[] args) {
		int[] nums = {33,53,12,64,50,41,45,21,97,35,47,92,39,0,93,55,40,46,69,42,6,95,51,68,72,9,32,84,34,64,6,2,26,98,3,43,30,60,3,68,82,9,97,19,27,98,99,4,30,96,37,9,78,43,64,4,65,30,84,90,87,64,18,50,60,1,40,32,48,50,76,100,57,29,63,53,46,57,93,98,42,80,82,9,41,55,69,84,82,79,30,79,18,97,67,23,52,38,74,15};
		System.out.println(wiggleMaxLength(nums));
	}

	public static int wiggleMaxLength(int[] nums) {
		if(nums.length==0) {
			return 0;
		}
		int len = 1;
		boolean startRecord = false; // 表示开始与否
		int record = 0; // 0表示此次应该为负，下一次应该为正
		for (int start = 0; start < nums.length-1;) {
			int end = start + 1;
			if (!startRecord) {
				if(nums[start] != nums[end]) {
					if (nums[start] - nums[end] > 0) {
						record = 0;
					} else {
						record = 1;
					}
					startRecord = true;
					len++;
				}
			} else {
				if (record == 1) {
					while (end < nums.length) {
						if(nums[end-1]>nums[end]) {
							len++;
							record=0;
							break;
						}else {
							end++;
						}
					}
				
				}else {
					while (end < nums.length) {
						if(nums[end-1]<nums[end]) {
							len++;
							record=1;
							break;
						}else {
							end++;
						}
					}
				}
			}
			start = end;
		}
		return len;
	}
}
