package leetcode专题;

import java.util.ArrayList;

public class 第k小_逆康托展开 {
	public static void main(String[] args) {
		getPermutation(2,2);
	}
	
	public static String getPermutation(int n, int k) {
		if(n<=1) {
			return String.valueOf(n); 
		}
		int[] tired = new int[n];
		tired[n-1]=1;
		int term = 1;
		for(int i=n-2;i>=0;i--) {
			tired[i] = tired[i+1]*term;
			term++;
		}
		ArrayList<Integer> in = new ArrayList<Integer>();
		for(int i=1;i<=n;i++) {
			in.add(i);
		}
		String s = new String();
		k--;
		for(int i=0;i<n;i++) {
			int index = k / tired[i];
			k = k % tired[i]; 
			s += String.valueOf(in.get(index));
			in.remove(index);
		}
		System.out.println(s);
		return s;
    }
}
