package leetcode专题;

public class 不同路径II_动态规划 {
	public static void main(String[] args) {
//		int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
//		int[][] grid = {{1,0}};
		int[][] grid = {{0},{1}};
		System.out.println(uniquePathsWithObstacles(grid));
		
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];
		if(obstacleGrid[0][0]==0) {
			grid[0][0]=1;
		}
		for(int i=1;i<grid[0].length;i++) {
			if(obstacleGrid[0][i]==0) {
				grid[0][i]=grid[0][i-1];
			}
		}
		for(int i=1;i<grid.length;i++) {
			if(obstacleGrid[i][0]==0) {
				grid[i][0]=grid[i-1][0];
			}
		}
		for(int i=1;i<grid.length;i++) {
			for(int j=1;j<grid[0].length;j++) {
				if(obstacleGrid[i][j]==0) {
					grid[i][j] = grid[i-1][j]+grid[i][j-1];
				}
			}
		}
		return grid[grid.length-1][grid[0].length-1];
	}
}
