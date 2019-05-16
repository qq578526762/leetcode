package 蓝桥杯决赛练习;

public class 三角形面积 {
	public static void main(String[] args) {
		double[] A = {2.3,2.5};
		double[] B = {6.4,3.1};
		double[] C = {5.1,7.2};
		double squartWidth = 6.4-2.3;
		double squartHeight = 7.2-2.5;
		double small1 = (6.4-2.3)*(3.1-2.5)/2;
		double small2 = (7.2-2.5)*(5.1-2.3)/2;
		double small3 = (7.2-3.1)*(6.4-5.1)/2;
		double area = squartWidth*squartHeight-small1-small2-small3;
		System.out.printf("%.3f",area);
		
	}
}
