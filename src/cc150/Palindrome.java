package cc150;

import java.util.Stack;

public class Palindrome {
	//
    public boolean isPalindrome(ListNode pHead) {
    	if(pHead==null) {
    		return false;
    	}
    	if(pHead.next==null ) {
    		return true;
    	}
    	if(pHead.next.next==null ) {
    		return pHead.val == pHead.next.val;
    	}
    	
    	ListNode slow = pHead;
    	ListNode fast = pHead;
    	Stack<Integer> s = new Stack();
    	
    	while(fast.next!=null && fast.next.next!=null) {
    		s.push(slow.val);
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	s.push(slow.val);
    	//Å¼Êý
    	if(fast.next!=null) {
    		slow = slow.next;
    	}
    	
		while(slow!=null) {
			if(slow.val!=s.pop()) {
				return false;
			}
			slow = slow.next;
		}
    	
		return true;
    }
    public static void main(String[] args) {
    	Palindrome p = new Palindrome();
    	ListNode pHead = new ListNode(1);
    	pHead.next = new ListNode(2);
    	pHead.next.next = new ListNode(3);
    	pHead.next.next.next = new ListNode(4);
    	pHead.next.next.next.next = new ListNode(2);
    	pHead.next.next.next.next.next = new ListNode(1);
    	System.out.println(p.isPalindrome(pHead));
	}
}
