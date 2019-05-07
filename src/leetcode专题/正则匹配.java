package leetcode专题;

public class 正则匹配 {
	public static void main(String[] args) {
		System.out.println(isMatch("aaa","ab*a*c*a"));
	}
	public static boolean isMatch(String s, String p) {
		if(s.isEmpty()) {
			return true;
		}else if(p.isEmpty()) {
			return false;
		}
		int pointS = s.length()-1;
		int pointP = p.length()-1;
		for(int i=pointP;i>=0;i--) {
			if(pointS < 0) {
				while(i>=1&&p.charAt(i)=='*') {
					i -= 2;
				}
				if(i>=0) {
					return false;
				}else {
					return true;
				}
			}
			char c = p.charAt(i);
			if(c=='*') {
				i--;
				c = p.charAt(i);
				if(c=='.') {
					return true;
				}else {
					while(pointS>=0&&s.charAt(pointS)==c) {
						pointS--;
					}
				}
			}else if(c=='.'){
				pointS--;
			}else {
				if(s.charAt(pointS)==p.charAt(i)) {
					pointS--;
				}else {
					return false;
				}
			}
		}
		if(pointS<0) {
			return true;
		}else {
			return false;
		}
    }
}
