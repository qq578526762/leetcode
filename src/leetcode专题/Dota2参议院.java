package leetcode专题;

import java.sql.PreparedStatement;
import java.util.LinkedList;

public class Dota2参议院 {
	public static void main(String[] args) {	
		String senate = "RRRDDDDR";
		System.out.println(predictPartyVictory(senate));
	}

	public static String predictPartyVictory(String senate) {
		char[] ch = senate.toCharArray();
		boolean[] flag = new boolean[ch.length];
		char c = '0';
		int countR = 0;
		int countD = 0;
		for(int i=0;i<ch.length;i++) {
			if(ch[i]=='R') {
				countR++;
			}else {
				countD++;
			}
		}
		while(countR>0&&countD>0) {
			for(int i=0;i<ch.length;i++) {
				boolean move = false;
				if(!flag[i]) {
					for(int j=i+1;j<ch.length;j++) {
						if(ch[j]!=ch[i]&&!flag[j]) {
							flag[j]=true;
							move=true;
							if(ch[i]=='R') {
								countD--;
							}else {
								countR--;
							}
							break;
						}
					}
					if(!move) {
						for(int j=0;j<i;j++) {
							if(ch[j]!=ch[i]&&!flag[j]) {
								flag[j]=true;
								move=true;
								if(ch[i]=='R') {
									countD--;
								}else {
									countR--;
								}
								break;
							}
						}
					}
				}
			}
		}
		return countR<=0?"Dire":"Radiant";
	}
}
