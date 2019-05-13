package leetcode专题;

import java.util.Arrays;

public class 按奇偶排序数组 {
	public static void main(String[] args) {
		int[] A = {3,1,2,4};
		System.out.println(Arrays.toString(sortArrayByParity(A)));
	}

	public static int[] sortArrayByParity(int[] A) {
		int start = 0;
		int end = A.length-1;
		int[] result = new int[A.length];
		for(int i=0;i<A.length;i++) {
			if(A[i]%2==0) {
				result[start++] = A[i];
			}else {
				result[end--] = A[i];
			}
		}
		return result;
	}
}
