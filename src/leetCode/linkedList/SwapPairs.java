package leetCode.linkedList;

public class SwapPairs {
	
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head ;
        }
        ListNode result = head.next;
        ListNode low = head;
        ListNode high = head.next;
        
        low = high.next.next;
        low.next.next = high.next;
        high.next = low;
        
        while( low!=null && high!=null ){
            
            low.next = high.next;
            high.next = low;

            high = low.next;
            
            if(low.next != null){
                low = low.next.next;
            }
            if(high.next != null){
                high = high.next.next;
            }
        }
        return result;
    }
}
