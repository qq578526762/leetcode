package leetcode专题;

import java.util.ArrayList;
import java.util.List;

public class 三角形最小路径和_动态规划 {
	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		List<Integer> list4 = new ArrayList<Integer>();
		list1.add(2);
		list2.add(3);
		list2.add(4);
		list3.add(6);
		list3.add(5);
		list3.add(7);
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		lists.add(list4);
		System.out.println(minimumTotal(lists));
		
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		for(int i=1;i<triangle.size();i++) {
			List<Integer> list = triangle.get(i);
			System.out.println(list);
			for(int j=0;j<list.size();j++) {
				if(j==0) {
					triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j));
				}else if(j==list.size()-1){
					triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j-1));
				}else {
					int minNum= triangle.get(i-1).get(j)>triangle.get(i-1).get(j-1)?triangle.get(i-1).get(j-1):triangle.get(i-1).get(j);
					triangle.get(i).set(j,triangle.get(i).get(j)+minNum);
				}
			}
			list =triangle.get(i);
			System.out.println(list);
		}
		List<Integer> list = triangle.get(triangle.size()-1);
		int min=1000000;
		for(Integer num:list) {
			if(num<min) {
				min=num;
			}
		}
		return min;
    }
}	
