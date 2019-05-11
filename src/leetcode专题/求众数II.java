package leetcode专题;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 求众数II {
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		System.out.println(majorityElement(nums));
	}

	public static List<Integer> majorityElement(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		int len = (int) Math.floor(nums.length/3.0)+1;
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				int time = map.get(nums[i])+1;
				if(time==len) {
					list.add(nums[i]);
				}
				map.put(nums[i], time);
			}else {
				map.put(nums[i], 1);
				if(len==1) {
					list.add(nums[i]);
				}
			}
		}
		return list;
	}
}
