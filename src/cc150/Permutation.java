package cc150;

import java.util.*;

public class Permutation {
    public ArrayList<String> getPermutation(String A) {
    	ArrayList<String> result = new ArrayList<String>();
    	Qpl( A.toCharArray(), 0, result);
    	Collections.sort(result);
    	Collections.reverse(result);
    	return result;
    }
    
    public void Qpl(char[] a, int index, ArrayList<String> result) {
    	if(index == a.length-1) {
    		result.add(String.valueOf(a));
    	}
    	
    	for(int i=index;i<a.length;i++) {
    		exch(a,index,i);
    		Qpl(a, index+1, result);
    		exch(a,index,i);
    	}
    }
    
    
	private void exch(char[] a, int j, int i) {
		// TODO Auto-generated method stub
		char temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
    

}
