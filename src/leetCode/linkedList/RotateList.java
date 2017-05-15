package leetCode.linkedList;

public class RotateList {
	
    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null ||head.next == null){
    		return head;
    	}
        ListNode left = head;
        ListNode right = head;
        
        int size = 1;
        while(right.next != null){
        	right = right.next;
        	size++;
        }
        k = k%size;
        if(k == 0){
        	return head;
        }
        int leftnum = size-k;
        while(--leftnum >0){
        	left = left.next;
        }

        ListNode newHead = left.next;
        right.next = head;
        left.next = null;
		return newHead;
    }
	
    public static void main(String[] args){
    	RotateList rl = new RotateList();
    	
    	ListNode l1 = new ListNode(1);
    	l1.next = new ListNode(2);
    	l1.next.next =  new ListNode(3);
    	l1.next.next.next = new ListNode(4);
    	
    	ListNode result = rl.rotateRight(l1, 2);
    	while(result != null){
        	System.out.println(result.val);
    		result = result.next;
    	}
    }
}
