package leetcode专题;

import java.util.Arrays;

public class 加油站_贪心 {
	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		System.out.println(canCompleteCircuit(gas, cost));
	}
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		for(int i=0;i<gas.length;i++) {
			boolean flag = true;
			int oil = gas[i];
			for(int index = i+1,k=0;k<gas.length;index++,k++) {
				if(oil-cost[(index-1)%gas.length]<0) {
					flag = false;
					break;
				}else {
					oil = oil-cost[(index-1)%gas.length]+gas[index%gas.length];
				}
			}
			if(flag) {
				return i;
			}
		}
		return -1;
    }
}
