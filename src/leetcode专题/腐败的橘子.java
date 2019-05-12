package leetcode专题;

import java.util.LinkedList;

public class 腐败的橘子 {
	public static void main(String[] args) {
		String str = "[2,1,1],[0,1,1],[1,0,1]";
		System.out.println(str.replace("[", "{").replace("]","}"));
		int[][] grid = {{0,2}};
		System.out.println(orangesRotting(grid));
	}

	public static int orangesRotting(int[][] grid) {
		if(grid.length==0) {
			return 0;
		}
		LinkedList<int[]> list = new LinkedList<int[]>();
		int width = grid[0].length;
		int count = 0;
		int total = 0;
		int len = grid.length;
		for(int i=0;i<len;i++) {
			for(int j=0;j<width;j++) {
				if(grid[i][j]==2) {
					int[] bad = {i,j};
					list.add(bad);
				}else if(grid[i][j]==1) {
					count++;
				}
			}
		}
		int time = 0;
		while(!list.isEmpty()) {
			LinkedList<int[]> newList = new LinkedList<int[]>();
			while(!list.isEmpty()) {
				int[] bad=list.poll();
				if(bad[0]-1>=0&&grid[bad[0]-1][bad[1]]==1) {
					count--;
					grid[bad[0]-1][bad[1]]=2;
					int[] newBad = {bad[0]-1,bad[1]};
					newList.add(newBad);
				}
				if(bad[0]+1<len&&grid[bad[0]+1][bad[1]]==1) {
					count--;
					grid[bad[0]+1][bad[1]]=2;
					int[] newBad = {bad[0]+1,bad[1]};
					newList.add(newBad);
				}
				if(bad[1]-1>=0&&grid[bad[0]][bad[1]-1]==1) {
					count--;
					grid[bad[0]][bad[1]-1]=2;
					int[] newBad = {bad[0],bad[1]-1};
					newList.add(newBad);
				}
				if(bad[1]+1<width&&grid[bad[0]][bad[1]+1]==1) {
					count--;
					grid[bad[0]][bad[1]+1]=2;
					int[] newBad = {bad[0],bad[1]+1};
					newList.add(newBad);
				}
			}
			if(newList.size()!=0) {
				time++;
				for(int[] newBad:newList) {
					list.add(newBad);
				}
			}
			
		}
		if(count!=0) {
			return -1;
		}else {
			return time;
		}
	}
}
