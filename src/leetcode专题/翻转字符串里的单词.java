package leetcode专题;

import java.util.Collections;

public class 翻转字符串里的单词 {
	public static void main(String[] args) {
		reverseWords("a good   example");
	}
	
	public static String reverseWords(String s) {
		String[] subS = s.trim().split("[ ]+");
		StringBuffer result = new StringBuffer();
		for(int i=subS.length-1;i>=0;i--) {
			result.append(subS[i]+" ") ;
		}
		result.delete(result.length()-1, result.length());
		System.out.println(result.toString());
        return result.toString();
    }
}
