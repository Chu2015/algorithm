package jianzhiOffer;

public class N16_ReverseList {
	
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
    
    //µÝ¹é°æ±¾
    public ListNode ReverseList2(ListNode head) {
    	if(head==null){
    		return null;
    	}
        if(head.next==null){
            return head;
        }
		
    	ListNode h = ReverseList2(head.next);
        ListNode newhead = h;
        while(h.next!=null){
            h = h.next;
        }
    	h.next = head;
    	head.next = null;
    	return newhead;
    }
}
