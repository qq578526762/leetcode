package 蓝桥杯决赛练习;

import java.util.LinkedList;

public class 找路 {
	public static void main(String[] args) {
        char[][] ch ={{'A','+','-','+','-'},
            {'-','+','-','-','+'},
            {'+','-','+','+','-'},
            {'+','+','+','-','+'},
            {'B','-','+','+','-'}};
        System.out.println(dns(ch,0,0));
    }

    public static int dns(char[][] ch,int start_x,int start_y){
        LinkedList<int[]> list = new LinkedList<int[]>();
        int[] term = new int[4]; 
        boolean[][] visited = new boolean[ch.length][ch.length];
        term[0] = start_x;
        term[1] = start_y;
        term[2] = 0;
        term[3] = 0;
        visited[start_x][start_y]=true;
        list.add(term);
        while(!list.isEmpty()){
            int[] point = list.pollFirst();
            System.out.println("x:"+point[0]+",y:"+point[1]+",statue:"+point[2]);
            //左右移动
            int x = point[0];
            int y = point[1];
            if(point[2]==0){
                //向左边
               
                if(y-1>=0){
                	int[] newPoint = new int[4];
                    if(ch[x][y=1]=='B'){
                        return point[3]+1;
                    }else if(ch[x][y-1]=='+'){
                        newPoint[2] = 1;
                    }else{
                        newPoint[2] = -1;
                    }
                    newPoint[0] = x;
                    newPoint[1] = y-1;
                    newPoint[3] = point[3]+1;
                    visited[x][y-1]=true;
                    list.add(newPoint);
                }
                if(y+1<ch.length){
                	int[] newPoint = new int[4];
                    if(ch[x][y+1]=='B'){
                        return point[3]+1;
                    }else if(ch[x][y+1]=='+'){
                        newPoint[2] = 1;
                    }else{
                        newPoint[2] = -1;
                    }
                    newPoint[0] = x;
                    newPoint[1] = y+1;
                    newPoint[3] = point[3]+1;
                    visited[x][y+1]=true;
                    list.add(newPoint);
                }
                if(x-1>=0){
                	int[] newPoint = new int[4];
                    if(ch[x-1][y]=='B'){
                        return point[3]+1;
                    }else if(ch[x-1][y]=='+'){
                        newPoint[2] = 1;
                    }else{
                        newPoint[2] = -1;
                    }
                    newPoint[0] = x-1;
                    newPoint[1] = y;
                    newPoint[3] = point[3]+1;
                    visited[x-1][y]=true;
                    list.add(newPoint);
                }
                if(x+1<ch.length){
                	int[] newPoint = new int[4];
                    if(ch[x+1][y]=='B'){
                        return point[3]+1;
                    }else if(ch[x+1][y]=='+'){
                        newPoint[2] = 1;
                    }else{
                        newPoint[2] = -1;
                    }
                    newPoint[0] = x+1;
                    newPoint[1] = y;
                    newPoint[3] = point[3]+1;
                    visited[x+1][y]=true;
                    list.add(newPoint);
                }
            }else if(point[2]==1){
                
                if(y-1>=0&&ch[x][y-1]!='+'&&!visited[x][y-1]){
                	int[] newPoint = new int[4];
                    if(ch[x][y-1]=='B'){
                        return point[3]+1;
                    }else{
                        newPoint[2] = -1;
                    }
                    newPoint[0] = x;
                    newPoint[1] = y-1;
                    newPoint[3] = point[3]+1;
                    visited[x][y-1]=true;
                    list.add(newPoint);
                }
                if(y+1<ch.length&&ch[x][y+1]!='+'&&!visited[x][y+1]){
                	int[] newPoint = new int[4];
                    if(ch[x][y+1]=='B'){
                        return point[3]+1;
                    }else{
                        newPoint[2] = -1;
                    }
                    newPoint[0] = x;
                    newPoint[1] = y+1;
                    newPoint[3] = point[3]+1;
                    visited[x][y+1]=true;
                    list.add(newPoint);
                }
                if(x-1>=0&&ch[x-1][y]!='+'&&!visited[x-1][y]){
                	int[] newPoint = new int[4];
                    if(ch[x-1][y]=='B'){
                        return point[3]+1;
                    }else{
                        newPoint[2] = -1;
                    }
                    newPoint[0] = x-1;
                    newPoint[1] = y;
                    newPoint[3] = point[3]+1;
                    visited[x-1][y] = true;
                    list.add(newPoint);
                }
                if(x+1<ch[0].length&&ch[x+1][y]!='+'&&!visited[x+1][y]) {
                	int[] newPoint = new int[5];
                    if (ch[x+1][y] == 'B') {
                        return point[3] + 1;
                    } else {
                        newPoint[2] = -1;
                    }
                    newPoint[0] = x+1;
                    newPoint[1] = y;
                    newPoint[3] = point[3] + 1;
                    visited[x+1][y]=true;
                    list.add(newPoint);
                }
            }else if(point[2]==-1){
                if(y-1>=0&&ch[x][y-1]!='-'&&!visited[x][y-1]){
                	int[] newPoint = new int[5];
                    if(ch[x][y-1]=='B'){
                        return point[3]+1;
                    }else{
                        newPoint[2] = 1;
                    }
                    newPoint[0] = x;
                    newPoint[1] = y-1;
                    newPoint[3] = point[3]+1;
                    visited[x][y-1]=true;
                    list.add(newPoint);
                }
                if(y+1<ch.length&&ch[y][y+1]!='-'&&!visited[x][y+1]){
                	int[] newPoint = new int[5];
                    if(ch[x][y+1]=='B'){
                        return point[3]+1;
                    }else{
                        newPoint[2] = 1;
                    }
                    newPoint[0] = x;
                    newPoint[1] = y+1;
                    newPoint[3] = point[3]+1;
                    visited[x][y+1]=true;
                    list.add(newPoint);
                }
                if(x-1>=0&&ch[x-1][y]!='-'&&!visited[x-1][y]){
                	int[] newPoint = new int[5];
                    if(ch[x-1][y]=='B'){
                        return point[3]+1;
                    }else{
                        newPoint[2] = 1;
                    }
                    newPoint[0] = x-1;
                    newPoint[1] = y;
                    newPoint[3] = point[3]+1;
                    visited[x-1][y]=true;
                    list.add(newPoint);
                }
                if(x+1<ch[0].length&&ch[x+1][y]!='-'&&!visited[x+1][y]) {
                	int[] newPoint = new int[5];
                    if (ch[x+1][y] == 'B') {
                        return point[3] + 1;
                    } else {
                        newPoint[2] = 1;
                    }
                    newPoint[0] = x+1;
                    newPoint[1] = y;
                    newPoint[3] = point[3] + 1;
                    visited[x+1][y]=true;
                    list.add(newPoint);
                }
            }
        }
        return -1;
    }
}
