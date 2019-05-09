package leetcode专题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class 单词接龙 {
	public static void main(String[] args) {
//		String beginWord = "hit";
//		String endWord = "cog";
		String beginWord = "a";
		String endWord = "c";
		ArrayList<String> wordList = new ArrayList<String>();
//		wordList.add("hot");
//		wordList.add("dot");
//		wordList.add("dog");
//		wordList.add("lot");
//		wordList.add("log");
//		wordList.add("cog");
		wordList.add("a");
		wordList.add("b");
		wordList.add("c");
		System.out.println(ladderLength(beginWord,endWord,wordList));;
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(!wordList.contains(endWord)) {
			return 0;
		}
		LinkedList<String> list = new LinkedList<String>();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put(beginWord,1);
		list.add(beginWord);
		while(!wordList.isEmpty()&&!list.isEmpty()) {
			String word = list.pollFirst();
			for(int i=0;i<wordList.size();i++) {
				String s = wordList.get(i);
				if(check(word,s)) {
					if(s.equals(endWord)) {
						return map.get(word)+1;
					}else {
						list.addLast(s);
						map.put(s,map.get(word)+1);
						wordList.remove(i);
						i--;
					}
				}
			}
			
		}
		return 0;
	}
	
	public static boolean check(String a,String b) {
		char[] chA  = a.toCharArray();
		char[] chB = b.toCharArray();
		int count = 0;
		for(int i=0;i<a.length();i++) {
			if(chA[i]!=chB[i]) {
				count++;
			}
			if(count>1) {
				return false;
			}
		}
		if(count==1) {
			return true;
		}else {
			return false;
		}
	}
}
