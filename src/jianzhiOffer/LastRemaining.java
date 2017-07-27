package jianzhiOffer;

public class LastRemaining {

	//递归
    public int LastRemaining_Solution(int n, int m) {
    	if(n<=1 || m<=0){
    		return -1;
    	}
    	
    	//构造一个链表环
    	Node head = new Node(0);
    	Node tail = head;
        for(int i=1;i<n;i++){
        	tail.next = new Node(i);
        	tail = tail.next;
        }
        tail.next = head;
    	
        --m;
        int k=m;
        while(head.next!=head){
            while(--k>0){
            	head = head.next;
            }
            head.next = head.next.next;
            head = head.next;
            k = m;
        }
        
        return head.val;

    }
    
    class Node{
    	Node(int val){
    		this.val = val;
    	}
    	int val;
    	Node next;
    }
    
    //不用递归
    public int LastRemaining_Solution2(int n, int m) {
    	if(n<=1 || m<=0){
    		return -1;
    	}
    	
    	int result = 0;
    	for(int i=1;i<=n;i++){
    		result =( result +m)%n;
    	}
    	return result;
    }
    
    public static void main(String[] args){
    	LastRemaining l = new LastRemaining();
    	System.out.println(l.LastRemaining_Solution(6,7));
    }
}
