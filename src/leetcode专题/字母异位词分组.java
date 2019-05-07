package leetcode专题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 字母异位词分组 {
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> lists = groupAnagrams(strs);
		for(List<String> list:lists) {
			System.out.println(list);
		}
		
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new LinkedList<List<String>>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int count = 0;
        for(int i=0;i<strs.length;i++) {
        	boolean flag = false;
        	char[] ch = strs[i].toCharArray();
        	Arrays.sort(ch);
        	if(map.containsKey(Arrays.toString(ch))) {
        		int index = map.get(Arrays.toString(ch));
        		List<String> list = lists.get(index);
        		list.add(strs[i]);
        		lists.set(index, list);
        	}else {
        		map.put(Arrays.toString(ch), count++);
        		LinkedList<String> list = new LinkedList<String>();
        		list.add(strs[i]);
        		lists.add(list);
        	}
        }
        return lists;
    }
}
