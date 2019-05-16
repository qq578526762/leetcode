package 蓝桥杯决赛练习;

import java.util.LinkedList;
import java.util.Scanner;

public class 找路2 {
	public static int n = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		char[][] ch = new char[n][n];
		for(int i=0;i<n;i++) {
			String content = sc.nextLine();
			ch[i] = content.replaceAll("[ ]+", "").toCharArray();
		}
		int x = 0;
		int y = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(ch[i][j]=='A') {
					x=i;
					y=j;
					break;
				}
			}
		}
//        char[][] ch ={{'A','+','-','+','-'},
//            {'-','+','-','-','+'},
//            {'+','-','+','+','-'},
//            {'+','+','+','-','+'},
//            {'B','+','+','+','-'}};
        System.out.println(dns(ch,0,0));
    }

    public static int dns(char[][] ch,int start_x,int start_y){
        LinkedList<int[]> list = new LinkedList<int[]>();
        int[] term = new int[4];  //term[2] 表示次数  term[3]==-1表示为-,1表示为+ 
        boolean[][] visited = new boolean[ch.length][ch.length];
        term[0] = start_x;
        term[1] = start_y;
        term[2] = 0;
        term[3] = 0;
        visited[start_x][start_y]=true;
        list.add(term);
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
        while(!list.isEmpty()){
            int[] point = list.pollFirst();
            //左右移动
//            System.out.println("x:"+point[0]+",y:"+point[1]+",statue:"+point[3]);
            for(int i=0;i<4;i++) {
            	int x = point[0]+dir[i][0];
            	int y = point[1]+dir[i][1];
            	if(isValid(x,y)&&!visited[x][y]) {
            		int[] newPoint = new int[4];
            		newPoint[0] = x;
            		newPoint[1] = y;
            		newPoint[2] = point[2]+1;
            		if(ch[x][y]=='B') {
        				return point[2]+1;
        			}
            		if(point[3]==0) {
            			if(ch[x][y]=='+') {
            				newPoint[3] = 1;
            			}else {
            				newPoint[3] = -1;
            			}
            			visited[x][y]=true;
            			list.add(newPoint);
            		}else if(point[3]==1&&ch[x][y]=='-') {
            			newPoint[3] = -1;
            			visited[x][y]=true;
            			list.add(newPoint);
            		}else if(point[3]==-1&&ch[x][y]=='+'){
            			newPoint[3] = 1;
            			visited[x][y]=true;
            			list.add(newPoint);
            		}
            	}
            }
        }
        return -1;
    }
    
    public static boolean isValid(int x,int y) {
    	if(x>=0&&x<n&&y>=0&&y<n) {
    		return true;
    	}else {
    		return false;
    	}
    }
}
