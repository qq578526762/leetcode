package leetcode专题;

import java.util.ArrayList;
import java.util.List;

public class 复原IP地址 {
	public static void main(String[] args) {
		String s = "010010";
		restoreIpAddresses(s);
	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<String>();
		Perm(s,new String(),0,s.length(),0,list);
		return list;
	}

	public static void Perm(String s,String subS, int k, int m, int point, List<String> list) {
		if (point == 3) {
			if(m-k>=2&&m-k<=3) {
				int num = Integer.parseInt(s.substring(k));
				if(!s.substring(k,k+1).equals("0")&&num<=255) {
					subS+=s.substring(k);
					System.out.println(subS);
					list.add(subS);
				}
			}else if(m-k==1){
				subS+=s.substring(k);
				System.out.println(subS);
				list.add(subS);
			}
		} else if(k<=m){
			// 取一位
			if (m-k-1>0&&m - k -1<= (3-point) * 3) {
				Perm(s,subS+s.substring(k, k+1)+".",k+1,m,point+1,list);
			}
			// 取两位
			if (m-k-2>0&&m - k - 2 <= (3-point) * 3&&!s.substring(k,k+1).equals("0")) {
				Perm(s,subS+s.substring(k, k+2)+".",k+2,m,point+1,list);
			}
			// 取三位
			if (m-k-3>0&&m - k - 3 <= (3-point) * 3&&!s.substring(k,k+1).equals("0")) {
				int num = Integer.parseInt(s.substring(k, k+3));
				if(num<=255) {
					Perm(s,subS+s.substring(k, k+3)+".",k+3,m,point+1,list);
				}
			}
		}
	}
}
