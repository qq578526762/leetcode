package leetcode专题;

import java.util.LinkedList;

public class 最短的桥 {
	public static int height;
	public static int width;

	public static void main(String[] args) {

		String str = "[[0,1,0],[0,0,0],[0,0,1]";
		System.out.println(str.replace("[", "{").replace("]", "}"));
		int[][] A = {{0,1,0},{0,0,0},{0,0,1}};
		System.out.println(shortestBridge(A));
	}

	public static int shortestBridge(int[][] A) {
		int len = 1;
		height = A.length;
		width = A[0].length;
		boolean[][] visited = new boolean[height][width];
		LinkedList<int[]> list = new LinkedList<int[]>();
		boolean flag = false;
		for (int i = 0; i < A.length; i++) {
			if(flag) {
				break;
			}
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					visited[i][j]=true;
					int[] point = {i,j,0};
					list.add(point);
					dfs(A, visited, i, j, list);
					flag=true;
					break;
				}
			}
		}
		int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		while(!list.isEmpty()) {
			int[] point = list.pollFirst();
			for(int i=0;i<4;i++) {
				int x = point[0]+dir[i][0];
				int y = point[1]+dir[i][1];
				if(isValid(x, y)&&!visited[x][y]) {
					if(A[x][y]==1) {
						return point[2];
					}else {
						int[] newPoint = new int[3];
						newPoint[0] = x;
						newPoint[1] = y;
						visited[x][y]=true;
						newPoint[2] = point[2]+1;
						list.add(newPoint);
					}
				}
			}
		}
		return len;
	}

	public static void dfs(int[][] A, boolean[][] visited, int start_x, int start_y, LinkedList<int[]> list) {
		int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		for (int i = 0; i < 4; i++) {
			int x = start_x + dir[i][0];
			int y = start_y + dir[i][1];
			if (isValid(x, y) && !visited[x][y] && A[x][y] == 1) {
				int[] point = { x, y, 0 };
				visited[x][y] = true;
				list.add(point);
				dfs(A, visited, x, y, list);
			}
		}
	}

	public static boolean isValid(int x, int y) {
		if (x >= 0 && x < height && y >= 0 && y < width) {
			return true;
		} else {
			return false;
		}
	}
}
