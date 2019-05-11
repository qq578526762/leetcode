package leetcode专题;

public class 有效的山脉数组 {
	public static void main(String[] args) {
		int[] A = {14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3};
		System.out.println(validMountainArray(A));
	}

	public static boolean validMountainArray(int[] A) {
		if(A.length<3) {
			return false;
		}else {
			boolean change = A[1]<A[0];
			boolean state = true;
			for(int i=1;i<A.length-1;i++) {
				if(A[i]<=A[i+1]!=state) {
					if(A[i]==A[i+1]||change) {
						return false;
					}else {
						change = true;
						state = !state;
					}
				}
			}
			return change;
		}
	}
}
