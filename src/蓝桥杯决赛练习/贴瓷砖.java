package 蓝桥杯决赛练习;

import java.util.Arrays;

public class 贴瓷砖 {
	public static int count = 0;
	public static void main(String[] args) {
		int[][] wall = new int[3][10];
		Perm(wall, 0, 0, wall.length - 1, wall[0].length - 1);
		System.out.println(count);
	}

	// 1表示橙色，2表示红色
	public static void Perm(int[][] wall,int x,int y,int end_x,int end_y) {
		if(x==end_x&&y==end_y) {
			count++;
			for(int i=0;i<=x;i++) {
				System.out.println(Arrays.toString(wall[i]));
			}
			System.out.println();
		}else {
			if(y>end_y) {
				y=0;
				x = x+1>end_x?x:x+1;
			}
			if(wall[x][y]==0) {
				//向右边边
				if(y+1<=end_y&&wall[x][y+1]==0) {
					if(x-1<0||(x-1>=0&&(wall[x-1][y]!=1||wall[x-1][y+1]!=1))) {
						wall[x][y] = 1;
						wall[x][y+1]=1;
						Perm(wall,x,y+2,end_x,end_y);
						wall[x][y] = 0;
						wall[x][y+1]=0;
					}
					if(x-1<0||(x-1>=0&&(wall[x-1][y]!=2||wall[x-1][y+1]!=2))) {
						wall[x][y] = 2;
						wall[x][y+1]=2;
						Perm(wall,x,y+2,end_x,end_y);
						wall[x][y] = 0;
						wall[x][y+1]=0;
					}
				}
				//向下边
				if(x+1<=end_x&&wall[x+1][y]==0) {
					if(y-1<0||(y-1>=0&&(wall[x][y-1]!=1||wall[x+1][y-1]!=1))) {
						wall[x][y] = 1;
						wall[x+1][y]=1;
						Perm(wall,x,y+1,end_x,end_y);
						wall[x][y] = 0;
						wall[x+1][y]=0;
					}
					if(y-1<0||(y-1>=0&&(wall[x][y-1]!=2||wall[x+1][y-1]!=2))) {
						wall[x][y] = 2;
						wall[x+1][y]=2;
						Perm(wall,x,y+1,end_x,end_y);
						wall[x][y] = 0;
						wall[x+1][y]=0;
					}
				}
			}else {
				Perm(wall,x,y+1,end_x,end_y);
			}
		}
	}
}
