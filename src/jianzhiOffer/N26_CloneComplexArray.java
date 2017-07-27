package jianzhiOffer;

import java.util.HashMap;

public class N26_CloneComplexArray {
	//my O(n^2)
    public RandomListNode Clone1(RandomListNode pHead){
    	if(pHead==null){
    		return null;
    	}
    	
    	RandomListNode tail = pHead;
    	RandomListNode move = pHead;
    	RandomListNode newHead = new RandomListNode(0);
    	RandomListNode newTail = newHead;
    	RandomListNode newmove = newHead.next;

    	while(tail!=null){
    		newTail.next  = new RandomListNode(tail.label);
        	newTail = newTail.next;
        	while(newmove!=null){
        		if(tail.random==move){
        			newTail.random = newmove ;
        		}else if(move.random ==tail){
        			newmove.random = newTail;
        		}
        		newmove = newmove.next;
        		move = move.next;
        	}
        	
        	newmove = newHead.next;
    		move = pHead;
    		tail = tail.next;
    	}

		return newHead.next;
    
    }
    
    //using hashMap O(N)
    public RandomListNode Clone2(RandomListNode pHead){
    	if(pHead==null){
    		return null;
    	}
    	
    	RandomListNode tail = pHead;
    	RandomListNode newHead = new RandomListNode(0);
    	RandomListNode newTail = newHead;
    	HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
    	
    	while(tail!=null){
    		newTail.next  = new RandomListNode(tail.label);
    		newTail = newTail.next;
    		map.put(tail, newTail);
    		tail = tail.next;
    	}
    	
    	tail = pHead;
    	newTail = newHead.next;
    	
    	while(tail!=null){
    		if(tail.random!=null){
    			newTail.random = map.get(tail.random);
    		}
    		tail = tail.next;
    		newTail = newTail.next;
    	}
    	
		return newHead.next;
    
    }
    
    public RandomListNode Clone(RandomListNode pHead){
    	if(pHead==null){
    		return null;
    	}
    	
    	RandomListNode tail = pHead;
    	RandomListNode newHead = null;
    	RandomListNode newTail = newHead;
    	
    	//copy each node after each
    	while(tail!=null){
    		RandomListNode temp = tail.next;
    		RandomListNode newNode = new RandomListNode(tail.label);
    		tail.next = newNode;
    		newNode.next = temp;
    		tail = temp;
    	}
   
    	//copy the random of each node
    	tail = pHead;
    	while(tail!=null){
    		if(tail.random!=null){
    			tail.next.random=tail.random.next;
    		}
    		tail=tail.next.next;
    	}
    	
    	//seperate the new linkedlist
    	newHead = pHead.next;
    	newTail = newHead;
    	while(newTail.next!=null){
    		newTail.next = newTail.next.next;
    		newTail = newTail.next;
    	}
    	
		return newHead;

    }
    public static void main(String[] args){
    	RandomListNode A = new RandomListNode(1);
    	A.next = new RandomListNode(2);
    	A.next.next = new RandomListNode(3);
    	A.next.next.next = new RandomListNode(4);
    	A.next.next.next.next = new RandomListNode(5);
    	A.random = A.next.next;
    	A.next.next.next.random = A.next;
    	A.next.random = A.next.next.next.next;
    	
    	N26_CloneComplexArray c = new N26_CloneComplexArray();
    	RandomListNode  r = c.Clone(A);
    	
    	while(r!=null){
    		System.out.println(r.label+",");
    		r = r.next;
    	}
    }
    
    
}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
