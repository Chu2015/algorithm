package cc150;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Partition {
//    public ListNode partition(ListNode pHead, int x) {
//    	if(pHead==null || pHead.next==null) {
//    		return pHead;
//    	}
//    	ListNode temp = pHead;
//    	ListNode small = new ListNode(0);
//    	ListNode smallhead = small;
//    	ListNode smalltail = small;
//    	ListNode big = new ListNode(0);
//    	ListNode bighead = big;
//    	ListNode bigtail = big;
//
//    	if(pHead.val<x) {
//    		smallhead = pHead;
//    		while(pHead.next!=null && pHead.next.val<x) {
//    			pHead = pHead.next;
//    		}
//    		smalltail = pHead;
//    		bighead = pHead.next;
//    		bigtail = pHead.next;
//    	}else{
//    		bighead = pHead;
//    		while(pHead.next!=null && pHead.next.val>=x) {
//    			pHead = pHead.next;
//    		}
//    		bigtail = pHead;
//    		smallhead = pHead.next;
//    		smalltail = pHead.next;
//    	}
//    	if(bighead==null || smallhead==null) {
//    		return temp;
//    	}
//    	
//    	while(pHead!=null) {
//    		while(pHead.next!=null && pHead.next.val<x) {
//    			pHead = pHead.next;
//    		}
//    		smalltail.next = pHead;
//    		while(pHead.next!=null && pHead.next.val>=x) {
//    			pHead = pHead.next;
//    		}
//    		bigtail = pHead;
//    		pHead = pHead.next;
//    	}
//    	small.next = bighead.next;
//    	
//		return smallhead.next;
//    	
//    }
	 public ListNode partition(ListNode pHead, int x) {
	    	if(pHead==null || pHead.next==null) {
	    		return pHead;
	    	}
	    	//small和big为移动的指针
	    	ListNode small = new ListNode(0);
	    	ListNode smallhead = small;
	    	ListNode big = new ListNode(0);
	    	ListNode bighead = big;
	    	
	    	//
	    	while(pHead!=null) {
	    		if(pHead.val<x) {
	    			small.next = pHead;
	    			small = pHead;
	    		}else {
	    			big.next = pHead;
	    			big = pHead;
	    		}
	    		pHead = pHead.next;
	    	}
	    	
	    	//
	    	big.next = null;
	    	small.next = bighead.next;
	    	
			return smallhead.next;
	    	
	    }
    public static void main(String[] args) {
    	Partition p = new Partition();
    	ListNode l1 = new ListNode(6);
    	l1.next = new ListNode(2);
    	l1.next.next = new ListNode(8);
    	p.partition(l1, 6);
	}
}
