package leetcode专题;

public class 到最近的人的最大距离 {
	public static void main(String[] args) {
		int[] seats = {1,0,0,0,0};
		System.out.println(maxDistToClosest(seats));
	}

	public static int maxDistToClosest(int[] seats) {
		int max = 0;
		int start = 0;
		int end =0;
		int count = 0;
		for(int i=0;i<seats.length;i++) {
			if(seats[i]==1) {
				if(count==0) {
					start = i;
					int distance = start - 0;
					max = max<distance?distance:max;
					end = start;
					count++;
				}else {
					end = i;
					int distance = (end-start)/2;
					max = max<distance?distance:max;
					start = end;
				}
			}
		}
		int distance = seats.length-1-end;
		max = max<distance?distance:max;
		return max;
	}
}
