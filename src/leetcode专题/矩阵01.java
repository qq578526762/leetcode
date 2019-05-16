package leetcode专题;

import java.util.LinkedList;

public class 矩阵01 {
	public static int height;
	public static int width;
//	0 0 0
//	0 1 0
//	0 0 0
	public static void main(String[] args) {
		int[][] matrix= {{0,0,0},{0,1,0},{1,1,1}};
		int[][] result= updateMatrix(matrix);
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static int[][] updateMatrix(int[][] matrix) {
		height = matrix.length;
		width = matrix[0].length;
		int[][] result = new int[height][width];
		boolean[][] visited = new boolean[height][width];
		LinkedList<int[]> list = new LinkedList<int[]>();
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				if(matrix[i][j]==0) {
					int[] point = new int[3];
					point[0]=i;
					point[1]=j;
					visited[i][j]=true;
					list.add(point);
				}
			}
		}
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		while(!list.isEmpty()) {
			int[] point = list.pollFirst();
			for(int i=0;i<4;i++) {
				int x = point[0]+dir[i][0];
				int y = point[1]+dir[i][1];
				if(isValid(x,y)&&!visited[x][y]) {
					int[] newPoint = new int[3];
					newPoint[0] = x;
					newPoint[1] = y;
					newPoint[2] = point[2]+1;
					result[x][y]= point[2]+1;
					visited[x][y] = true;
					list.add(newPoint);
				}
			}
		}
		return result;
	}
	
	public static boolean isValid(int x,int y) {
    	if(x>=0&&x<height&&y>=0&&y<width) {
    		return true;
    	}else {
    		return false;
    	}
    }
}
