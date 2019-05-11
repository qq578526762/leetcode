package leetcode专题;

import java.util.Arrays;

public class 字符的最短距离 {
	public static void main(String[] args) {
		String S =  "baaa";
		char C = 'b';
		shortestToChar(S, C);
	}

	public static int[] shortestToChar(String S, char C) {
		int[] nums = new int[S.length()];
		char[] ch = S.toCharArray();
		boolean[] flag = new boolean[ch.length];  //false表示向后找，true表示向前找
		for(int i=0;i<ch.length;i++) {
			if(i==0) {
				if(ch[i]!=C) {
					flag[i]=true;
					for(int j=1;j<ch.length;j++) {
						if(ch[j]==C) {
							nums[i] = j-i;
							break;
						}
					}
				}
			}else if(i==ch.length-1){
				if(ch[i]!=C) {
					nums[i]=nums[i-1]+1;
				}
			}else if(ch[i]==C) {
				continue;
			}else if(flag[i-1]) {
				nums[i] = nums[i-1]-1;
			}else {
				boolean move = false;
				for(int j=i+1;j<nums.length;j++) {
					if(ch[j]==C) {
						int len = j-i;
						if(len<=nums[i-1]) {
							nums[i]=len;
							flag[i]=true;
						}else {
							nums[i]=nums[i-1]+1;
						}
						move = true;
						break;
					}
				}
				if(!move) {
					nums[i]=nums[i-1]+1;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
	
}
