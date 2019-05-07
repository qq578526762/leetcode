package leetcode专题;

public class 比较版本号 {
	public static void main(String[] args) {
		System.out.println(compareVersion("1.0","1.2"));
		
	}

	public static int compareVersion(String version1, String version2) {
		String[] subOne = version1.split("[.]");
		String[] subTwo = version2.split("[.]");
		int len = subOne.length > subTwo.length ? subOne.length : subTwo.length;
		int[] numOne = new int[len];
		int[] numTwo = new int[len];
		for (int i = 0; i < subOne.length; i++) {
			numOne[i] = Integer.parseInt(subOne[i]);
		}
		for (int i = 0; i < subTwo.length; i++) {
			numTwo[i] = Integer.parseInt(subTwo[i]);
		}
		for(int i = 0;i<len;i++) {
			if(numOne[i]!=numTwo[i]) {
				return numOne[i]-numTwo[i]>=0?1:-1;
			}
		}
		return 0;
	}
}
