package jianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListFromTailToHead {
	
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	if(listNode==null){
    		return null;
    	}
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Stack<Integer> stack = new Stack<Integer>();
    	while(listNode!=null){
    		stack.push(listNode.val);
    		listNode = listNode.next;
    	}
    	
    	while(!stack.isEmpty()){
    		list.add(stack.pop());
    	}
		return list;
        
    }
    
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
		return printListFromTailToHead2(listNode,list);
        
    }
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode ,ArrayList<Integer> list){
    	if(listNode==null){
    		return null;
    	}
    	list = printListFromTailToHead2(listNode.next , list);
    	list.add(listNode.val);
		return list;
    	
    }
    
    public static void main(String[] args){
    	
    	PrintListFromTailToHead plfth = new PrintListFromTailToHead();
    	ListNode  node  = new ListNode(48);
    	node.next = new ListNode(44);
    	node.next.next = new ListNode(3);
    	node.next.next.next = new ListNode(4);
    	ArrayList list = plfth.printListFromTailToHead(node);
    	
    }
}

class ListNode {
	int val;
	ListNode next = null;

    ListNode(int val) {
    	this.val = val;
    }
}