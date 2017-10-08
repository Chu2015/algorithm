package cc150;

import java.util.*;

public class Parenthesis {
	
    public boolean chkParenthesis(String A, int n) {
    	if(A==null || A.length()==0){
    		return false;
    	}
        int count=0;
        char[] c = A.toCharArray();
        for(int i=0;i<A.length();i++) {
        	if(c[i]=='(') {
        		count++;
        	}else if(c[i]==')') {
        		if(count==0) {
        			return false;
        		}else {
        			count--;
        		}
        	}else {
        		return false;
        	}
        }
        return count==0;
    }
}
