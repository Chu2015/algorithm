package leetCode.linkedList;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class LinkedList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0;
        ListNode newLinkedList = new ListNode(0);
        ListNode head = newLinkedList;
        while(l1 != null && l2 !=null){
            int sum = l1.val + l2.val + a;
            a = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            head.next = new ListNode(sum % 10);   
            head = head.next;

        }
        while(l1 != null){
            int sum = l1.val + a;
            a = sum / 10;
            l1 = l1.next;
            head.next = new ListNode(sum % 10);   
            head = head.next;
        }
         while(l2 != null){
            int sum = l2.val + a;
            a = sum / 10;
            l2 = l2.next;
            head.next = new ListNode(sum % 10);   
            head = head.next;
        }
        if(a != 0){
        	 head.next = new ListNode(a);   
             head = head.next; 
        }
        return newLinkedList.next;
    }
	
	//
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode back = head;
        ListNode front = head;
        while(--n >=0){
            if(back.next == null){
                head = head.next;
                return head;
            }
            back = back.next;
        }
        while(back.next != null){
            back = back.next;
            front = front.next;
        }
        front.next = front.next.next;
        return head;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
    
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode newListHead = newList;
        ListNode head1 = l1;
        ListNode head2 = l2;
        while(head1 != null && head2!= null){
            if(head1.val > head2.val){
                newListHead.next = new ListNode(head2.val);
                newListHead = newListHead.next;
                head2 = head2.next;
            }else{
                newListHead.next = new ListNode(head1.val);
                newListHead = newListHead.next;
                head1 = head1.next;
            }
        }
        while(head1 != null){
            newListHead.next = new ListNode(head1.val);
            newListHead = newListHead.next;
            head1 = head1.next;
        }
        while(head2 != null){
            newListHead.next = new ListNode(head2.val);
            newListHead = newListHead.next;
            head2 = head2.next;
        }
        return newList.next;
    }
    
    
    public static void main(String[] args){
    	SwapPairs a2n = new SwapPairs();
    	
    	ListNode l1 = new ListNode(1);
    	l1.next = new ListNode(2);
    	l1.next.next =  new ListNode(3);
    	l1.next.next.next = new ListNode(4);
    	
     	ListNode l2 = new ListNode(4);
    	l2.next = new ListNode(5);
    	l2.next.next =  new ListNode(6);
    	
    	ListNode result = a2n.swapPairs(l1);
    	while(result != null){
        	System.out.println(result.val);
    		result = result.next;
    	}
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}