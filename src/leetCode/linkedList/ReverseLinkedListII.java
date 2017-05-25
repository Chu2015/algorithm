package leetCode.linkedList;

public class ReverseLinkedListII {
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode dummy = new ListNode(0);
    	ListNode dummy2 = dummy;
    	ListNode dummy3 = dummy;

    	dummy.next = head;
    	while(--m >0){
    		dummy2 = dummy2.next;
    	}
    	for(int i=n+1;i>0;i--){
    		dummy3 = dummy3.next;
    	}
    	
    	ListNode move = dummy3;
    	ListNode move2 = dummy2.next;
    	while(move2 != dummy3){
    		ListNode temp = move2.next;
    		move2.next = move;
    		move = move2;
    		move2 = temp;
    	}
    	dummy2.next = move;
    	return dummy.next;
    }
    public static void main(String[] args){
    	ReverseLinkedListII rl = new ReverseLinkedListII();
    	
    	ListNode l1 = new ListNode(1);
    	l1.next = new ListNode(2);
    	l1.next.next =  new ListNode(3);
    	l1.next.next.next = new ListNode(4);
    	
    	ListNode result = rl.reverseBetween(l1, 2, 3);
    	while(result != null){
        	System.out.println(result.val);
    		result = result.next;
    	}
    }
}
