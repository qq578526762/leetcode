package leetcode专题;

import java.util.ArrayList;
import java.util.List;

public class 单词拆分_动态规划 {
	public static void main(String[] args) {
		String s = "applepenapple";
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
//		wordDict.add("d");
//		wordDict.add("cd");
		System.out.println(wordBreak(s,wordDict));
	}
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		return wordBreak(s,wordDict,0);
    }
	
	public static boolean wordBreak(String s, List<String> wordDict,int index) {
		boolean success = false;
		boolean flag = false;
		for(String word:wordDict) {
			if(success) {
				break;
			}
			if(word.length()+index<=s.length()) {
				String subS = s.substring(index, index+word.length());
				if(subS.equals(word)) {
					if(index+word.length()==s.length()) {
						success = true;
						flag = true;
						break;
					}else {
						success = wordBreak(s,wordDict,index+word.length());
					}
					
					flag = true;
				}
			}
		}
		if(!flag) {
			return false;
		}
		return success;
    }
}
