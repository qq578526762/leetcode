package leetcode专题;

public class 最短路径和_动态规划 {
	public static void main(String[] args) {
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {
		for (int i = 1; i < grid[0].length; i++) {
			grid[0][i] += grid[0][i - 1];
		}
		for (int i = 1; i < grid.length; i++) {
			grid[i][0] += grid[i - 1][0];
		}
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				grid[i][j] += grid[i-1][j]<grid[i][j-1]?grid[i-1][j]:grid[i][j-1];
			}
		}
		return grid[grid.length-1][grid[0].length-1];
	}
}
