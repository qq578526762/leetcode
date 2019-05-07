package leetcode专题;

public class 移掉K位数字_贪心 {
	public static void main(String[] args) {
		String num = "1432219";
		System.out.println(removeKdigits(num, 3));
	}
	
	public static String removeKdigits(String num, int k) {
		if(num.length()==k) {
			return "0";
		}
		StringBuffer subNum = new StringBuffer(num);
		char[] ch = num.toCharArray();
		int index = 0;
		for(int i=subNum.length()-k;i<subNum.length();) {
			boolean flag = false;
			for(int j=0;j<num.length()-k;j++) {
				if(subNum.charAt(j)>subNum.charAt(j+1)) {
					subNum.delete(j, j+1);
					flag = true;
					break;
				}
			}
			if(!flag) {
				subNum.delete(i, i+1);
			}
		}
//		System.out.println(subNum.substring(0, num.length()-k));
		String result = subNum.substring(0, num.length()-k).replaceFirst("^0*", "");
        return result.equals("")?"0":result;
    }
}
