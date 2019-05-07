package leetcode专题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class 三重循环 {
	public static void main(String[] args) {
		int[] nums = {-1,0,1,0};
		int a=1;
		int b = 2;
		List<List<Integer>> lists = threeSum(nums);
		for(List<Integer> list:lists) {
			System.out.println(list);
		}
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		HashSet<String> set = new HashSet<String>();
		for(int i=0;i<nums.length-2;i++) {
			int numOne = nums[i];
			for(int j=i+1;j<nums.length-1;j++) {
				int numTwo = nums[j];
				int numThree = 0 - numOne - numTwo; 
				for(int k=j+1;k<nums.length;k++) {
					if(nums[k]==numThree) {
						if(!set.contains(numOne+" "+numTwo+" "+numThree)) {
							set.add(numOne+" "+numTwo+" "+numThree);
							ArrayList<Integer> list = new ArrayList<Integer>();
							list.add(numOne);
							list.add(numTwo);
							list.add(numThree);
							lists.add(list);
						}
						break;
					}
				}
			}
		}
		return lists;
	}
}
