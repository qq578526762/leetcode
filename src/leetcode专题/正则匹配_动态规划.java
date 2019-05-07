package leetcode专题;

public class 正则匹配_动态规划 {
	public static void main(String[] args) {
		System.out.println(isMatch("aab","c*a*b"));
		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("aaa","a*b*a*c*a"));
		System.out.println(isMatch("aaa","ab*a*c*a"));
		System.out.println(isMatch("aab","b.*"));
		System.out.println(isMatch("abbabaaaaaaacaa","a*.*b.a.*c*b*a*c*"));
		System.out.println(isMatch("aabcbcbcaccbcaabc",".*a*aa*.*b*.c*.*a*"));
		System.out.println(isMatch("bab","..*"));
		System.out.println(isMatch("ab",".*"));
		System.out.println(isMatch("aasdfasdfasdfasdfas","aasdf.*asdf.*asdf.*asdf.*s"));
		System.out.println(isMatch("mississippi","mis*is*ip*."));
		System.out.println(isMatch("aaa","a*b*a*c*a"));
		System.out.println(isMatch("aaca","a*b*a*c*a"));
		System.out.println(isMatch("",""));
	}
	public static boolean isMatch(String s, String p) {
		if(p.isEmpty()&&!s.isEmpty()) {
			return false;
		}
		int start = s.length()-1;
		int pointS = s.length();
		int pointP = p.length();
		boolean[][] dp = new boolean [pointP][pointS];
		for(int i=pointP-1;i>=0;i--) {
			if(start < 0) {
				while(i>=1&&p.charAt(i)=='*') {
					i -= 2;
				}
				if(i>=0) {
					return false;
				}else {
					return true;
				}
			}
			int term = start;
			if(i<pointP-1) {
				dp[i]=dp[i+1].clone();
			}
			boolean flag = false;
			boolean move = false;
			while(term>=0) {
				char c = p.charAt(i);
				if(c=='*') {
					i--;
					dp[i]=dp[i+1].clone();
					c = p.charAt(i);
					if(c=='.') {
						int index = i-1;
						while(index>1&&p.charAt(index)=='*') {
							index-=2;
						}
						if(index<0) {
							return true;
						}
						while(term>=0&&p.charAt(index)!=s.charAt(term)) {
							dp[i][term] = true;
							term--;
						}
						if(!move&&p.charAt(index)!='.') {
							start = term;
							move = true;
						}
						while(term>=0) {
							dp[i][term] = true;
							term--;
						}
					}else{
						while(term>=0&&c==s.charAt(term)) {
							dp[i][term] = true;
							term--;
						}
						if(i==0||term>=0&&!move) {
							start = term;
						}
					}
				}else if(c=='.'||c==s.charAt(term)) {
					dp[i][term] = true;
					start--;
					if(i==0) {
						if(term-1<0||term-1>=0&&dp[i][term-1]==true) {
							flag=true;
							term--;
						}
					}
				}else if(dp[i][term]==false){
					return false;
				}else {
					term--;
				}
				if(!flag) {
					break;
				}
			}
			if(start>=0&&i==0) {
				return false;
			}
		}
		for(int i=0;i<pointS;i++) {
			if(dp[0][i]==false) {
				return false;
			}
		}
		return true;
    }
}
