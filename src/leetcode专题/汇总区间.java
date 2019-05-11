package leetcode专题;

import java.awt.font.NumericShaper;
import java.util.LinkedList;
import java.util.List;

public class 汇总区间 {
	public static void main(String[] args) {
		int[] nums = {0,1,2,4,5,7};
		List<String> list= summaryRanges(nums);
		for(String s:list) {
			System.out.println(s);
		}
	}

	public static List<String> summaryRanges(int[] nums) {
		LinkedList<String> list = new LinkedList<String>();
		if(nums.length==0) {
			return list;
		}
		String str = ""+nums[0];
		boolean[] flag = new boolean[nums.length];
		flag[0] = true;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]-nums[i-1]!=1) {
				if(!flag[i-1]) {
					str += "->"+nums[i-1];
				}
				list.add(str);
				str =""+nums[i];
				flag[i] = true;
			}else if(nums[i]-nums[i-1]==1&&i==nums.length-1) {
				str += "->"+nums[i];
			}
		}
		list.add(str);
		return list;
	}
}
