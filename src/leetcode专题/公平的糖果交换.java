package leetcode专题;

import java.util.Arrays;

public class 公平的糖果交换 {
	public static void main(String[] args) {
		int[] A = {1,2,5};
		int[] B = {2,4};
		System.out.println(Arrays.toString(fairCandySwap(A, B)));
	}

	public static int[] fairCandySwap(int[] A, int[] B) {
		int[] result = new int[2];
		int sumA = sum(A);
		int sumB = sum(B);
		int sub = sumA-sumB;
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<B.length;j++) {
				int numA = sumA - A[i] + B[j];
				int numB = sumB + A[i] - B[j];
				if(numA==numB) {
					result[0] = A[i];
					result[1] = B[j];
					return result;
				}
			}
		}
		return result;
	}
	
	public static int sum(int... A) {
		int sum =0;
		for(int i=0;i<A.length;i++) {
			sum += A[i];
		}
		return sum;
	}
}
