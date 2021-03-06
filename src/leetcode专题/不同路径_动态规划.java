package leetcode专题;

public class 不同路径_动态规划 {
	public static void main(String[] args) {
		System.out.println(uniquePaths(7,3));
	}

	public static int uniquePaths(int m, int n) {
		int[][] record = new int[n][m];
		for(int i=0;i<m;i++) {
			record[0][i]=1;
		}
		for(int i=0;i<n;i++) {
			record[i][0]=1;
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				record[i][j] = record[i-1][j]+record[i][j-1];
			}
		}
		return record[n-1][m-1];
	}
}
