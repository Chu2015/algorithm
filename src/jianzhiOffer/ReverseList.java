package jianzhiOffer;

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
    	ListNode oldhead = head;
    	ListNode newhead = null;
    	while(oldhead!=null){
    		ListNode temp = oldhead.next;
    		oldhead.next = newhead;
    		newhead = oldhead;
    		oldhead = temp;
    	}
    	return newhead;
    }
}
