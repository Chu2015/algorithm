package leetCode.linkedList;

public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head == null || head.next == null || k==1){
    		return head;
    	}
        ListNode move = new ListNode(0);
        move.next = head;
        int a = k;
        
        //��move�ƶ�����K��������������С��K�������ر�ͷ
        while(k-->0){
        	move = move.next;
        	if(move == null){
        		return head;
        	}
        }
        
        ListNode left = new ListNode(0);
        left.next = head;
        ListNode right  = head;
        
        k = a;
        while(--k>0){
        	ListNode temp = right.next;
        	right.next = temp.next;
        	temp.next = left.next;
        	left.next = temp;
        }
        
        //�ݹ�
        right.next = reverseKGroup(right.next,a);
        
		return left.next;
    }
    public static void main(String[] args){
    	ReverseNodesinkGroup r = new ReverseNodesinkGroup();
    	ListNode l1 = new ListNode(1);
    	l1.next = new ListNode(2);
    	l1.next.next =  new ListNode(3);
    	l1.next.next.next = new ListNode(4);
    	
    	ListNode result = r.reverseKGroup(l1, 4);
    	while(result != null){
        	System.out.println(result.val);
    		result = result.next;
    	}
    }
}
