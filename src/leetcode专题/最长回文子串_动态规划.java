package leetcode专题;

public class 最长回文子串_动态规划 {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("abc"));;
	}

	public static String longestPalindrome(String s) {
		if(s.isEmpty()) {
			return s;
		}
		int len = s.length();
		int left = 0;
		int right = 0;
		boolean[][] dp = new boolean[len][len];
		for (int i = len - 2; i >= 0; i--) {
			dp[i][i] = true;
			for (int j = i + 1; j < len; j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
				if (dp[i][j] && right - left < j - i) {
					right = j;
					left = i;
				}
			}
		}
		return s.substring(left, right+1);
	}
}
