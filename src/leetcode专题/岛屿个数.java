package leetcode专题;

import java.util.LinkedList;

public class 岛屿个数 {
	public static int width=0;
	public static int height=0;
//	11000
//	11000
//	00100
//	00011
	public static void main(String[] args) {
		String[] str = {"10111","10101","11101"};
		char[][] grid = new char[str.length][str[0].length()];
		for(int i=0;i<str.length;i++) {
			grid[i] = str[i].toCharArray();
		}
		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {
		if(grid.length==0) {
			return 0;
		}
		width = grid[0].length;
		height = grid.length;
		int count = 0;
		int visitedNum = 0;
		int total =0;
		int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]=='1') {
					total++;
				}
			}
		}
		while(visitedNum<total) {
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					if(!visited[i][j]&&grid[i][j]=='1') {
						count++;
						visitedNum++;
						LinkedList<int[]> list = new LinkedList<int[]>();
						int[] point = {i,j};
						list.add(point);
						visited[i][j]=true;
						while(!list.isEmpty()) {
							int[] head = list.pollFirst();
							for(int k=0;k<4;k++) {
								int x = head[0]+dir[k][0];
								int y = head[1]+dir[k][1];
								if(isValid(x,y)&&!visited[x][y]&&grid[x][y]=='1') {
									int[] newPoint = {x,y};
									visitedNum++;
									visited[x][y]=true;
									list.add(newPoint);
								}
							}
						}
						break;
					}
				}
			}
		}
		return count;
	}
	
	public static boolean isValid(int x,int y) {
    	if(x>=0&&x<height&&y>=0&&y<width) {
    		return true;
    	}else {
    		return false;
    	}
    }
}
