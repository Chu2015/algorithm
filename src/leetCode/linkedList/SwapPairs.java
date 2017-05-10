package leetCode.linkedList;

public class SwapPairs {
	

    public ListNode swapPairs2(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    public ListNode swapPairs(ListNode head) {
    	
        if(head == null || head.next == null){
            return head ;
        }
        ListNode result = head.next;
        
        //extraNode作为标记链表末尾是否添加节点
        boolean extraNode = false;
        ListNode low = new ListNode(0);
        low.next = head;
        ListNode high = head.next.next;
        
        
        if(high == null){
        	high = new ListNode(0);
        	extraNode = true;
        }
        
        while( low!=null && high!=null ){
            ListNode left = low.next;
            ListNode right = low.next.next;
            low.next = right;
            right.next = left;
            left.next = high;
            
            if(high.next == null){//链表节点数奇数个
            	break;
            }else if(high.next.next == null){//链表节点数偶数个
            	high.next.next = new ListNode(0);
            	extraNode = true;
            }
            low = low.next.next;
        	high = high.next.next;
        }
        if(extraNode){ //删除添加节点
        	low.next.next.next = null;
        }
        return result;
    }
    public static void main(String[] args){
    	SwapPairs a2n = new SwapPairs();
    	
    	ListNode l1 = new ListNode(1);
    	l1.next = new ListNode(2);
//    	l1.next.next =  new ListNode(3);
//    	l1.next.next.next = new ListNode(4);
    	
    	ListNode result = a2n.swapPairs(l1);
    	while(result != null){
        	System.out.println(result.val);
    		result = result.next;
    	}
    }
}
