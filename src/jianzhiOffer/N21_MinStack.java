package jianzhiOffer;

import java.util.Stack;

public class N21_MinStack {

	
	
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> stackhelper = new Stack<Integer>();
	
    public void push(int node) {
        stack.push(node);
        if(stackhelper.isEmpty() || stackhelper.peek()>node){
        	stackhelper.push(node);
        }else{
        	stackhelper.push(stackhelper.peek());
        }
        
    }
    
    public void pop() {
    	stack.pop();
    	stackhelper.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return stackhelper.peek();
    }
    
    public static void main(String[] args){
    	N21_MinStack n = new N21_MinStack();
    	
    }
}
