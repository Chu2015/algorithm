package leetCode.stack;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        char[] charArray = path.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i = charArray.length-2;i>= 0;i++){
        	if(charArray[i] == '/'){
        		break;
        	}else{
        		stack.push(charArray[i]);
        	}
        }
        char[] newArray = new char[stack.size()];
        
        
    }
}
