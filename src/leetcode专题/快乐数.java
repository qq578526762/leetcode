package leetcode专题;

import java.util.HashSet;

public class 快乐数 {
	public static void main(String[] args) {
		System.out.println(isHappy(20));
	}

	public static boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		while(!set.contains(n)) {
			set.add(n);
			System.out.println(n);
			int total = 0;
			do {
				int num = n%10;
				total += Math.pow(num, 2);
				n = n/10;
			}while(n!=0);
			if(total==1) {
				return true;
			}
			n = total;
		}
		return false;
	}
}
