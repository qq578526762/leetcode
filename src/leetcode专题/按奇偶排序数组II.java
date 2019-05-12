package leetcode专题;

import java.util.Arrays;

public class 按奇偶排序数组II {
	public static void main(String[] args) {
		int[] A = {4,2,5,7};
		System.out.println(Arrays.toString(sortArrayByParityII(A)));
	}

	public static int[] sortArrayByParityII(int[] A) {
		int[] nums = new int[A.length];
		int odd = 1;
		int even = 0;
		for(int i=0;i<A.length;i++) {
			if(A[i]%2==0) {  //表示为偶数
				nums[even] = A[i];
				even += 2;
			}else {
				nums[odd] = A[i];
				odd += 2;
			}
		}
		return nums;
	}
}
