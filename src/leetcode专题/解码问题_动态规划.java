package leetcode专题;

public class 解码问题_动态规划 {
	public static void main(String[] args) {
		System.out.println(numDecodings("110"));
	}

	public static int numDecodings(String s) {
		char[] ch = s.toCharArray();
		int[] num = new int[s.length()];
		if(s.charAt(0)=='0') {
			return 0;
		}else {
			num[0] = 1;
		}
		for(int i=1;i<num.length;i++) {
			if(ch[i]!='0'&&(ch[i-1]=='1'||ch[i-1]=='2'&&ch[i]<='6')) {
				if(i==1) {
					num[i] = 2;
				}else {
					num[i] = num[i-1] + num[i-2];
				}
			}else if(ch[i]=='0'){
				if(ch[i-1]>='3'||ch[i-1]=='0') {
					return 0;
				}else {
					if(i==1) {
						num[i]=1;
					}else {
						num[i] = num[i-2];
					}
				}
			}else {
				num[i] = num[i-1];
			}
		}
		return num[s.length()-1];
	}
}
