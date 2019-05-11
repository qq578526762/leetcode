package leetcode专题;

import java.util.Arrays;

public class 压缩字符串 {
	public static void main(String[] args) {
		char[] chars= {'a','a','a','b','b','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c'};
		System.out.println(compress(chars));
		System.out.println(Arrays.toString(chars));
	}

	public static int compress(char[] chars) {
		if(chars.length<=1) {
			return chars.length;
		}
		int len = 1;
		int count = 1;
		char ch = chars[0];
		for(int i=1;i<chars.length;i++) {
			if(chars[i]==ch) {
				count++;
			}else {
				chars[len-1] = ch;
				if(count>1) {
					char[] term = String.valueOf(count).toCharArray();
					for(int j=0;j<term.length;j++) {
						chars[len]= term[j];
						len++;
					}
				}
				ch = chars[i];
				len++;
				count = 1;
			}
		}
		int chLen = chars.length-1;
		if(chars[chLen]==chars[chLen-1]) {
			chars[len-1]=ch;
			char[] term = String.valueOf(count).toCharArray();
			for(int i=0;i<term.length;i++) {
				chars[len]= term[i];
				len++;
			}
			
		}else {
			chars[len-1] = chars[chLen];
		}
		return len;
	}
}
