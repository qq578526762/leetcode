package leetcode专题;

public class 对链表进行插入排序 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(6);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(8);
		ListNode node5 = new ListNode(7);
		ListNode node6 = new ListNode(1);
		ListNode node7 = new ListNode(2);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
		insertionSortList(null);
	}

	public static ListNode insertionSortList(ListNode head) {
		if(head==null) {
			return null;
		}
		ListNode term = head.next;
		ListNode tail = head;
		while(term!=null) {
			ListNode font = null;
			ListNode back = head;
			boolean flag = false;
			while(back!=term) {
				if(back.val>term.val) {
					ListNode node = term.next;
					if(font==null) {
						term.next=back;
						head = term;
					}else {
						font.next=term;
						term.next=back;
					}
					term = node;
					flag = true;
					break;
				}else {
					font = back;
					back = back.next;
				}
			}
			if(!flag) {
				term = term.next;
				tail = tail.next;;
			}else {
				tail.next = term;
			}
		}
		System.out.println("123");
		return head;
	}
}
