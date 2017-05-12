package leetCode.linkedList;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode fixed = new ListNode(0);
        ListNode move = fixed;
        fixed.next = head;
        head = fixed;
        
        int mark;
        
        while(move.next !=null && move.next.next!=null){
            while(move.next.next.val == move.next.val){
            	mark = move.next.val;
            	while( move.next.val ==mark ){
            		move = move.next;
            		if(move.next == null){
            			fixed.next = move.next;
            			return head.next;
            		}
            	}  
            	if(move.next.next == null){
            		break;
        		}
            }
            fixed.next = move.next;
            fixed = fixed.next;
            move = move.next;
        }

    	return head.next;
    }
    public ListNode deleteDuplicates2(ListNode head) {
    	if(head == null){
    		return null;
    	}
    	if(head.next == null){
    		return head;
    	}
    	ListNode move = new ListNode(0);
    	move.next = head;
    	head = move;
    	
    	while(move.next.next.val == move.next.val){
    		int mark = move.next.val;
        	while( move.next.val ==mark ){
        		move = move.next;
        		if(move.next == null){
        			head.next = null;
        			break;
        		}
        	}  
        	if(move.next.next == null){
        		break;
    		}
    	}
    	head.next = move.next;
    	head.next.next = deleteDuplicates2(head.next.next);
  
    	return head.next;
    }
    public static void main(String[] args){
    	RemoveDuplicatesfromSortedListII r = new RemoveDuplicatesfromSortedListII();
    	
    	ListNode l1 = new ListNode(1);
    	l1.next = new ListNode(1);
    	l1.next.next =  new ListNode(1);
    	l1.next.next.next = new ListNode(3);
//    	l1.next.next.next.next = new ListNode(3);
    	
    	ListNode result = r.deleteDuplicates2(l1);
    	while(result != null){
        	System.out.println(result.val);
    		result = result.next;
    	}
    }
}
