package leetcode专题;

public class 复数乘法 {
	public static void main(String[] args) {
		System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
	}

	public static String complexNumberMultiply(String a, String b) {
		String[] numA = a.split("[+i]");
		String[] numB = b.split("[+i]");
		int numOne = Integer.parseInt(numA[0])*Integer.parseInt(numB[0])-Integer.parseInt(numA[1])*Integer.parseInt(numB[1]);
		int numTwo = Integer.parseInt(numA[1])*Integer.parseInt(numB[0])+Integer.parseInt(numA[0])*Integer.parseInt(numB[1]);
		String result = String.valueOf(numOne)+"+"+String.valueOf(numTwo)+"i";
		return result;
	}
}
