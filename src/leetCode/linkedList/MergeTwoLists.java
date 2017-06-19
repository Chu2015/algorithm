package leetCode.linkedList;

public class MergeTwoLists {
	//recursively
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		    //boundary condition
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
	   public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
	        if(list1 == null){
	            return list2;
	        }
	        if(list2 == null){
	            return list1;
	        }
	        
	        ListNode mergeHead= new ListNode(0);
	        ListNode mergeTail = mergeHead;
	        while(list1!=null && list2!=null){
	        	if(list1.val<list2.val){
	        		mergeTail.next = list1;
	        		mergeTail = mergeTail.next;
	        		list1 = list1.next;
	        	}else{
	        		mergeTail.next = list2;
	        		mergeTail = mergeTail.next;
	        		list2 = list2.next;
	        	}
	        }
	        if(list2!=null){
	        	mergeTail.next = list2;
        		mergeTail = mergeTail.next;
        		list2 = list2.next;
	        }
	        if(list1!=null){
	        	mergeTail.next = list1;
        		mergeTail = mergeTail.next;
        		list1 = list1.next;
	        }
	        return mergeHead.next;
	   }
	 
}
