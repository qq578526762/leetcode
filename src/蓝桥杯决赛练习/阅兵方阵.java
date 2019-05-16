package 蓝桥杯决赛练习;

public class 阅兵方阵 {
	public static void main(String[] args) {
//		for(int i=1105;i<100000;i++) {
//			int count = 0;
//			int sum = i;
//			int start = (int)Math.sqrt(sum);
//			int end = start/2;
//			for(int j=start;j>=end;j--) {
//				double o = sum - Math.pow(j, 2);
//				if(Math.sqrt(o)%1==0) {
//					count++;
//				}
//			}
//			if(count==12) {
//				System.out.println(i);
//				break;
//			}
//		}
		int sum = 27625;
		int start = (int)Math.sqrt(sum);
		int end = start/2;
		for(int j=start;j>=end;j--) {
			double o = sum - Math.pow(j, 2);
			if(Math.sqrt(o)%1==0) {
				System.out.println(sum+"="+j+"*"+j+"+"+(int)Math.sqrt(o)+"*"+(int)Math.sqrt(o));
			}
		}
	}
}
