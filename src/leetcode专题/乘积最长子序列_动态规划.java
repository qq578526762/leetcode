package leetcode专题;

public class 乘积最长子序列_动态规划 {
	public static void main(String[] args) {
		int[] nums = {2,3,-2,-4};
		System.out.println(maxProduct(nums));
	}

	public static int maxProduct(int[] nums) {
		int[][] sum = new int[nums.length][2];  //0放最大值，1放最小值
		sum[0][0] = nums[0];
		sum[0][1] = nums[0];
		for(int i=1;i<nums.length;i++) {
			int numOne = nums[i]*sum[i-1][0];
			int numTwo = nums[i]*sum[i-1][1];
			sum[i][0] = max(numOne,numTwo,nums[i]);
			sum[i][1] = min(numOne,numTwo,nums[i]);
		}
		int max = -1000000;
		for(int i=0;i<sum.length;i++) {
			if(sum[i][0]>max) {
				max = sum[i][0];
			}
		}
		return max;
	}
	
	public static int max(int a,int b,int c) {
		int num = a>b?a:b;
		return num>c?num:c;
	}
	public static int min(int a,int b,int c) {
		int num = a<b?a:b;
		return num<c?num:c;
	}
}
