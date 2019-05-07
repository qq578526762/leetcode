package leetcode专题;

import java.util.Arrays;
import java.util.HashMap;

public class 两数之和 {
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		System.out.println(Arrays.toString(twoSum(nums,26)));
	}
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], i);
		}
		int[] result = new int[2];
		for(int i=0;i<nums.length;i++) {
			int num = target-nums[i];
			if(map.containsKey(num)) {
				if(map.get(num)!=i) {
					result[0] = i;
					result[1] = map.get(num);
					return result;
				}
			}
		}
		return null;
	}
}
