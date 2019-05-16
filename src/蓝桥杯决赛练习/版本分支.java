package 蓝桥杯决赛练习;

import java.util.Scanner;

public class 版本分支 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = sc.nextInt();
		int[] branch = new int[n + 1];
		branch[1] = 1;
		int[][] question = new int[count][2];
		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			branch[b] = a;
		}
		for (int i = 0; i < count; i++) {
			question[i][0] = sc.nextInt();
			question[i][1] = sc.nextInt();
		}
		for (int i = 0; i < count; i++) {
			boolean flag = false;
			int parent = question[i][0];
			int son = question[i][1];
			if (parent == 1) {
				flag = true;
			}
			while (branch[son] != 1) {
				if (branch[son] == parent) {
					flag = true;
					break;
				} else {
					son = branch[son];
				}
			}
			if(flag) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
