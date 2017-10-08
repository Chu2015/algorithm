package cc150;

import java.util.*;

public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
    	ArrayList<Integer> result = new ArrayList<Integer>(numbers.length);
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	int index = numbers.length - 1;
    	for (int i = index; i >= 0; i--) {
    		stack.push(numbers[i]);
    	}
    	
    	Stack<Integer> resultStack = new Stack<Integer>();//额外的栈
    	resultStack.push(stack.pop());
    	
    	while (!stack.empty()) {
    		int a = stack.pop();
    		int b = resultStack.pop();
    		if (a < b) {
				int count=1;
				stack.push(b);
				while (!resultStack.empty() && a < (b = resultStack.peek())) {
					count++;
					stack.push(b);
				}
				resultStack.push(a);
				while(count-->0) {
					resultStack.push(stack.pop());
				}
			}else if (a >= b) {
				resultStack.push(b);
				resultStack.push(a);
			}
    	}
        while (!resultStack.empty()) {
            result.add(resultStack.pop());
        }
        return result;
    }
    public static void main(String[] args) {
    	TwoStacks ts = new TwoStacks();
    	ts.twoStacksSort(new int[] {5,4,1,3,2});
	}
}
