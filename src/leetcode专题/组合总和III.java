package leetcode专题;

import java.util.LinkedList;
import java.util.List;

public class 组合总和III {
	public static void main(String[] args) {
		combinationSum3(2,18);
		System.out.println();
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		LinkedList<List<Integer>> lists = new LinkedList<List<Integer>>();
		int[] list = new int[k];
		Perm(lists,list,0,k-1,n,0,1);
		return lists;
	}
	
	//k表示当前第几个数，m表示一共几个数，n表示总和，sum表示当前的总和,num表示当前最小值
	public static void Perm(List<List<Integer>> lists,int[] list,int k, int m,int n,int sum,int num) {
		if(k==m) {
			if(n-sum>=num&&n-sum<=9) {
				list[k]=n-sum;
				LinkedList<Integer> l = new LinkedList<Integer>();
				for(int i=0;i<=k;i++) {
					l.add(list[i]);
				}
//				System.out.println(list);	
				lists.add(l);
			}
		}else {
			for(int i=num;i<=9;i++) {
				if(sum+i<n) {
					list[k]=i;
					Perm(lists,list,k+1,m,n,sum+i,i+1);
				}else {
					break;
				}
			}
		}
	}
}
