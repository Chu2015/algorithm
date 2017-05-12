package leetCode.linkedList;

public class RemoveDuplicatesfromSortedList {
	
    public ListNode deleteDuplicates2(ListNode head) {
    	ListNode left = head;
    	ListNode right = head;
    	while(right != null){
    		if(right.next == null){
    			return head;
    		}
    		while(right.next!=null && right.next.val == right.val){
    			right = right.next;
    		}
    		left.next = right.next;
    		left = left.next;
    		
    		right = right.next;
    	}
    	
        return head;
    }
	
  public ListNode deleteDuplicates(ListNode head) {
	ListNode right = head;
	if(right == null ){
		return null;
	}
	while(right.next!=null && right.next.val == right.val){
		right = right.next;
	}
	head.next = deleteDuplicates(right.next);
    return head;
 }
  public ListNode deleteDuplicates3(ListNode head) {
      ListNode list = head;
       
       while(list != null) {
      	 if (list.next == null) {
      		 break;
      	 }
      	 if (list.val == list.next.val) {
      		 list.next = list.next.next;
      	 } else {
      		 list = list.next;
      	 }
       }
       
       return head;
  }
    public static void main(String[] args){
    	RemoveDuplicatesfromSortedList r = new RemoveDuplicatesfromSortedList();
    	
    	ListNode l1 = new ListNode(1);
    	l1.next = new ListNode(1);
    	l1.next.next =  new ListNode(1);
    	l1.next.next.next = new ListNode(3);
    	l1.next.next.next.next = new ListNode(3);
    	
    	ListNode result = r.deleteDuplicates3(l1);
    	while(result != null){
        	System.out.println(result.val);
    		result = result.next;
    	}
    }
}
