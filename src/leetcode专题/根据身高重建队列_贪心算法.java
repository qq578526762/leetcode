package leetcode专题;

import java.util.ArrayList;
import java.util.LinkedList;

public class 根据身高重建队列_贪心算法 {
	public static void main(String[] args) {
//		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int[][] people = {{7,0}};
		reconstructQueue(people);
	}
	
	public static int[][] reconstructQueue(int[][] people) {
		if(people.length==0) {
			return people;
		}
		for(int i=0;i<people.length-1;i++) {
			for(int j=i+1;j<people.length;j++) {
				if(people[i][1]>people[j][1]||(people[i][1]==people[j][1]&&people[i][0]>people[j][0])) {
					int[] term = people[i];
					people[i] = people[j];
					people[j] = term;
				}
			}
		}
		LinkedList<int[]> lists = new LinkedList<int[]>();
		lists.add(people[0]);
//		Integer[] a = {1,2,3};
//		list.add(a);
		for(int i=1;i<people.length;i++) {
			int index = 0;
			int count = people[i][1];
			int num = people[i][0];
			boolean flag = false;
			for(int[] list:lists) {
				if(count==0&&list[0]>=num) {
					flag = true;
					lists.add(index,people[i]);
					break;
				}else if(count>0&&list[0]>=num){
					count--;
				}
				index++;
			}
			if(!flag) {
				lists.add(people[i]);
			}
		}
		int[][] result = new int[people.length][2];
		int i = 0;
		for(int[] list:lists) {
			result[i] = list;
			i++;
		}
        return result;
    }
}
