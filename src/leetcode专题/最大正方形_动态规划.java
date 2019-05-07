package leetcode专题;

public class 最大正方形_动态规划 {
	public static void main(String[] args) {
//		char[][] mat = {{'1','0','1','0','0'},
//						{'1','0','1','1','1'},
//						{'1','1','1','1','1'},
//						{'1','0','1','1','1'}};
		char[][] mat = {{'0'}};
		System.out.println(maximalSquare(mat));
	}	

		public static int maximalSquare(char[][] matrix) {
			if(matrix.length==0) {
				return 0;
			}
			int max = 0;
			int[][] nums = new int[matrix.length][matrix[0].length];
			// 初始化
			for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j < nums[0].length; j++) {
					if(matrix[i][j]=='0') {
						nums[i][j] = 0;
					}else {
						nums[i][j] = 1;
						max = 1;
					}
				}
			}
			for (int i = 1; i < nums.length; i++) {
				for (int j = 1; j < nums[0].length; j++) {
					if(matrix[i][j]=='1') {
						nums[i][j] = Math.min(Math.min(nums[i - 1][j - 1], nums[i - 1][j]), nums[i][j - 1]) + 1;
						if (nums[i][j] > max) {
							max = nums[i][j];
						}
					}
				}
			}
			return (int)Math.pow(max,2);
		}
	
		public static boolean isSame(char[][] matrix, int i, int j) {
			if (matrix[i][j] != matrix[i - 1][j])
				return false;
			if (matrix[i][j] != matrix[i - 1][j - 1])
				return false;
			if (matrix[i][j] != matrix[i][j - 1])
				return false;
			return true;
		}
}
