package test;

import leetCode.ListNode;

public class LinkedListTest {
	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		ListNode n1 = new ListNode(12);
		ListNode n2 = new ListNode(13);
		ListNode n3 = new ListNode(14);
		ListNode n4 = new ListNode(15);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		ListNode temp = head;
		while(temp!=null){
			System.out.println(temp.val);
			if(temp.val == 12){
				temp.next = null;
				temp = temp.next;
			}else{
				temp = temp.next;
			}
		}
		System.out.println("*****");
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}

}
