package jianzhiOffer;

public class N15_FineNthNodeFromTheEnd {
    public ListNode FindKthToTail(ListNode head,int k) {
    	if(k<=0 || head==null){
    		return null;
    	}
    	ListNode left = head;
    	ListNode right = head;
    	while(--k>0 && right!=null){
    		right = right.next;
    	}
    	if(right==null){
    		return null;
    	}
    	while(right.next!=null){
    		left = left.next;
    		right = right.next;
    	}
		return left;
    }
}
