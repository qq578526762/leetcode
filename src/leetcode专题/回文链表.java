package leetcode专题;

import java.util.LinkedList;

import leetcode专题.对链表进行插入排序.ListNode;

public class 回文链表 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
//		ListNode node1 = new ListNode(2);
//		ListNode node2 = new ListNode(3);
//		ListNode node3 = new ListNode(5);
//		ListNode node4 = new ListNode(3);
//		ListNode node5 = new ListNode(2);
//		ListNode node6 = new ListNode(1);
//		ListNode node7 = new ListNode(3);
//		head.next=node1;
//		node1.next=node2;
//		node2.next=node3;
//		node3.next=node4;
//		node4.next=node5;
//		node5.next=node6;
////		node6.next=node7;
		System.out.println(isPalindrome(head));
//		String str = "12323321";
//		System.out.println(str.substring(0,str.length()/2));
	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		while(head!=null) {
			list.add(head.val);
			head=head.next;
		}
		while(list.size()!=1&&list.size()!=0) {
			int numOne = list.pollLast();
			int numTwo = list.poll();
			if(numOne!=numTwo) {
				return false;
			}
		}
		return true;
	}
}
