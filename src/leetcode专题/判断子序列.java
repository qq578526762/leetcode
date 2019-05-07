package leetcode专题;

public class 判断子序列 {
	public static void main(String[] args) {
		String s = "";
		String t = "ahbgdc";
		System.out.println(isSubsequence(s,t));;
	}

	public static boolean isSubsequence(String s, String t) {
		if(s.length()==0) {
			return true;
		}
		if(t.length()==0) {
			return false;
		}
		char[] chs = s.toCharArray();
		char[] cht = t.toCharArray();
		int start = 0;
		for(int i=0;i<cht.length;i++) {
			if(chs[start]==cht[i]) {
				start++;
				if(start==s.length()) {
					return true;
				}
			}
		}
		return false;
	}
}
