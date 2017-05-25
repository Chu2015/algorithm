package leetCode.linkedList;

public class PartitionList {
    public ListNode partition2(ListNode head, int x) {
    	if(head == null){
    		return null;
    	}
    	ListNode move = new ListNode(0);
    	move.next = head;
    	while(move.next !=null && move.next.val >= x){
    		move = move.next;
    	}
    	if(move.next==null){
    		return head;
    	}else if(move.next == head){
    		head.next = partition2(head.next,x);
    		return head;
    	}else{
    		ListNode temp = move.next;
    		move.next = temp.next;
    		temp.next = head;
    		temp.next = partition2(temp.next,x);
    		return temp;
    	}
    }
//	while(move.next !=null && move.next.val < x){
//	move = move.next;
//}
//if(move.next == null){
//	return head;
//}else if(move.next != head){
//	move.next = partition(move.next,x);
//	return head;
//}
    public ListNode partition(ListNode head, int x) {
    	ListNode dummySt = new ListNode(0);
    	ListNode dummyGe = new ListNode(0);
    	ListNode moveSt = dummySt;
    	ListNode moveGe = dummyGe;
    	while(head != null){
    		if(head.val < x){
    			moveSt.next = head;
    			moveSt = head;
    		}else{
    			moveGe.next = head;
    			moveGe = head;
    		}
    		head = head.next;
    	}
    	moveGe.next = null;
    	moveSt.next = dummyGe.next;
    	return dummySt.next;
    }
    public static void main(String[] args){
    	PartitionList r = new PartitionList();
    	ListNode l1 = new ListNode(2);
    	l1.next = new ListNode(1);
//    	l1.next.next =  new ListNode(3);
//    	l1.next.next.next = new ListNode(3);
    	
    	ListNode result = r.partition(l1, 2);
    	while(result != null){
        	System.out.println(result.val);
    		result = result.next;
    	}
    }
}
