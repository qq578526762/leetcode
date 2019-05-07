package leetcode专题;

import java.util.HashSet;

public class 无重复字符的最长子串 {
	public static void main(String[] args) {
		String s = "abcbbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		if(s.length()==0) {
			return 0;
		}
		int max=1;
		HashSet<Character> set = new HashSet<Character>();
		char[] ch = s.toCharArray();
		int len = 0;
		for(int i=0;i<ch.length;i++) {
			if(!set.contains(ch[i])) {
				len++;
				set.add(ch[i]);
			}else {
				if(len>max)
					max = len;
				set.clear();
				set.add(ch[i]);
				len = 1;
				int term = i-1;
				while(term>=0) {
					if(!set.contains(ch[term])) {
						set.add(ch[term]);
						len++;
						term--;
					}else {
						break;
					}
				}
			}
		}
        return max>len?max:len;
    }
}
