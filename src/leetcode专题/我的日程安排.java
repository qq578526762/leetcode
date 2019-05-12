package leetcode专题;

import java.util.LinkedList;

public class 我的日程安排 {
	class MyCalendar {
		LinkedList<int[]> schedule = new LinkedList<int[]>();	
	    public MyCalendar() {
	        
	    }
	    
	    public boolean book(int start, int end) {
	    	if(schedule.size()==0) {
	    		int[] time = {start,end};
	    		schedule.add(time);
	    		return true;
	    	}else {
	    		int index = 0;
	    		boolean flag = true;
	    		int[] order = {start,end};
	    		for(int[] time:schedule) {
	    			if(order[1]<=time[0]&&flag) {
	    				schedule.add(index, order);
	    				return true;
	    			}else{
	    				if(order[0]>=time[1]) {
	    					flag = true;
	    				}else {
	    					flag = false;
	    				}
	    					
	    			}
	    			index++;
	    		}
	    		if(flag) {
	    			schedule.add(order);
	    			return true;
	    		}else {
	    			return false;
	    		}
	    	}
	    }
	}
	public static void main(String[] args) {
		MyCalendar obj = new 我的日程安排().new MyCalendar();
		System.out.println(obj.book(10, 20)); // returns true
		System.out.println(obj.book(15, 25)); // returns false
		System.out.println(obj.book(25, 30)); // returns true
		System.out.println(obj.book(20, 25)); // returns true
		
	}
}
