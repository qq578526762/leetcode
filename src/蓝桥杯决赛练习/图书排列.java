package 蓝桥杯决赛练习;

import java.util.Arrays;
import java.util.HashSet;

public class 图书排列 {
	private static int count = 0;
	public static void main(String[] args) {
		int[] num = new int[5];
		HashSet<Integer> set = new HashSet<Integer>();
		Perm(num,set,0,num.length);
		System.out.println(count);
	}
	
	public static void Perm(int[] num,HashSet<Integer> set,int k,int m) {
		if(k==m) {
			count++;
			System.out.println(Arrays.toString(num));
		}else {
			for(int i=1;i<=m;i++) {
				if(k==0) {
					num[k]=i;
					set.add(i);
					Perm(num,set,k+1,m);
					set.remove(i);
				}else if(!set.contains(i)&&Math.abs(num[k-1]-i)!=1){
					num[k]=i;
					set.add(i);
					Perm(num,set,k+1,m);
					set.remove(i);
				}
			}
		}
	}
}
