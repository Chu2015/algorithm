package leetCode.stack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

	Queue<Integer> q1 = new ArrayDeque<Integer>();
	Queue<Integer> q2 = new ArrayDeque<Integer>();
	
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	int i = 0,j = 0;
        while(q1.peek()!=null){
        	i = q1.poll();
        	if(q1.peek()!=null){
            	q2.add(i);
        	}
        }
        while(q2.peek()!=null){
        	j = q2.poll();
        	q1.add(j);
        }
        return i;
    }
    
    /** Get the top element. */
    public int top() {
    	int i = 0,j = 0;
        while(q1.peek()!=null){
        	i = q1.poll();
        	q2.add(i);
        }
        while(q2.peek()!=null){
        	j = q2.poll();
        	q1.add(j);
        }
        return i;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
    
    //使用1个队列
    class MyStack2 {

    	//one Queue solution
    	private Queue<Integer> q = new LinkedList<Integer>();

    	// Push element x onto stack.
    	public void push(int x) {
    	    q.add(x);
    	    for(int i = 1; i < q.size(); i ++) { //rotate the queue to make the tail be the head
    	        q.add(q.poll());
    	    }
    	}

    	// Removes the element on top of the stack.
    	public void pop() {
    	    q.poll();
    	}

    	// Get the top element.
    	public int top() {
    	    return q.peek();        
    	}

    	// Return whether the stack is empty.
    	public boolean empty() {
    	    return q.isEmpty();
    	}
    	}
}
