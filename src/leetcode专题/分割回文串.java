package leetcode专题;

import java.util.LinkedList;
import java.util.List;

public class 分割回文串 {
	public static void main(String[] args) {
		String s = "abba";
		partition(s);
	}
	
	public static List<List<String>> partition(String s) {
		if(s.isEmpty()) {
			return null;
		}
		LinkedList<List<String>> lists = new LinkedList<List<String>>();
		Perm(lists,s,new String(),0,s.length()-1);
        return lists;
    }
	
	public static void Perm(List<List<String>> lists,String s,String subS,int k,int m) {
		if(k>m) {
			String[] sub = subS.trim().split(" ");
			LinkedList<String> list = new LinkedList<String>();
			for(String su:sub) {
				list.add(su);
			}
			lists.add(list);
//			System.out.println(subS);
		}else {
			for(int i=k;i<=m;i++) {
				if(check(s.substring(k,i+1))) {
					Perm(lists,s,subS+s.substring(k,i+1)+" ",i+1,m);
				}
			}
		}
	}
	
	public static boolean check(String s) {
		char[] ch = s.toCharArray();
		for(int i=0,j=s.length()-1;i<=j;i++,j--) {
			if(ch[i]!=ch[j]) {
				return false;
			}
		}
		return true;
	}
}
