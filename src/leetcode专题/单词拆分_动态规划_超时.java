package leetcode专题;

import java.util.ArrayList;
import java.util.List;

public class 单词拆分_动态规划_超时 {
	public static void main(String[] args) {
		String s = "abcd";
		List<String> wordDict = new ArrayList<String>();
//		wordDict.add("cats");
//		wordDict.add("dog");
//		wordDict.add("sand");
//		wordDict.add("and");
//		wordDict.add("cat");
		wordDict.add("apple");
		wordDict.add("pen");
		wordDict.add("a");
		wordDict.add("abc");
		wordDict.add("d");
		wordDict.add("cd");
		System.out.println(wordBreak(s,wordDict));
	}
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for(int i=1;i<=s.length();i++) {
			for(int j=0;j<i;j++) {
				if(dp[j]&&wordDict.contains(s.substring(j,i))) {
					System.out.println(s.substring(j,i));
					dp[i]=true;
				}
			}
		}
		return dp[s.length()];
    }
	
}
