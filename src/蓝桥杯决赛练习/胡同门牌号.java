package 蓝桥杯决赛练习;

public class 胡同门牌号 {
	public static void main(String[] args) {
		boolean flag = false;
		for(int i=1;i<100;i++) {
			int sum = i;
			int count = 0;
			for(int j=i+1;;j++) {
				count++;
				sum = sum+j;
				if(sum-count==100&&count>i&&count<j) {
					System.out.println(i+" "+j+" "+count);
					break;
				}
				if(sum-count>100) {
					break;
				}
			}
		}
		int sum = 0;
		for(int i=5;i<=15;i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
