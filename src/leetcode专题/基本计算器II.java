package leetcode专题;

import java.util.LinkedList;

public class 基本计算器II {
	public static void main(String[] args) {
		String s = new String(" 5*5/5+1 ");
		System.out.println(calculate(s));;
	}

	public static int calculate(String s) {
		if(s.isEmpty()) {
			return 0;
		}
		s = s.replaceAll("[ ]+","");
		String[] subS = s.split("");
		LinkedList<String> list = new LinkedList<String>();
		String numOne;
		String numTwo;
		for(int i=0;i<subS.length;i++) {
			numOne = new String();
			if(!subS[i].equals("+")&&!subS[i].equals("-")&&!subS[i].equals("*")&&!subS[i].equals("/")) {
				while(i<subS.length&&!subS[i].equals("+")&&!subS[i].equals("-")&&!subS[i].equals("*")&&!subS[i].equals("/")) {
					numOne += subS[i];
					i++;
				}
				list.add(numOne);
			}
			if(i<subS.length&&subS[i].equals("*")) {
				i++;
				numTwo = new String();
				while(i<subS.length&&!subS[i].equals("+")&&!subS[i].equals("-")&&!subS[i].equals("*")&&!subS[i].equals("/")) {
					numTwo+=subS[i];
					i++;
				}
				i--;
				list.add(String.valueOf(Integer.parseInt(list.pollLast())*Integer.parseInt(numTwo)));
			}else if(i<subS.length&&subS[i].equals("/")) {
				i++;
				numTwo = new String();
				while(i<subS.length&&!subS[i].equals("+")&&!subS[i].equals("-")&&!subS[i].equals("*")&&!subS[i].equals("/")) {
					numTwo+=subS[i];
					i++;
				}
				i--;
				list.add(String.valueOf(Integer.parseInt(list.pollLast())/Integer.parseInt(numTwo)));
			}else if(i<subS.length){
				list.add(subS[i]);
			}
		}
		while(!list.isEmpty()) {
			int num1 = Integer.parseInt(list.pollFirst());
			if(list.isEmpty()) {
				return num1;
			}else {
				String operation = list.pollFirst();
				int num2 = Integer.parseInt(list.pollFirst());
				if(operation.equals("+")) {
					list.addFirst(String.valueOf(num1+num2));
				}else {
					list.addFirst(String.valueOf(num1-num2));
				}
			}
		}
		return 0;
	}
}
