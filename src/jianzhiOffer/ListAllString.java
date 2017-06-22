package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

public class ListAllString {
    public ArrayList<String> Permutation(String str) {
    	if(str==null || str.length()==0){
    		return null;
    	}
    	ArrayList<String> list = new ArrayList<String>();
    	char[] newc = str.toCharArray();
    	
    	list.add(String.valueOf(newc));
    	for(int i=0;i<newc.length;i++){
    		for(int j=i+1;j<newc.length;j++){
        		if(newc[j]!=newc[i]){
        			exc(newc,i,j);
        			list.add(String.valueOf(newc));
        		}
        		newc = str.toCharArray();
    		}
    	}
    	
		return list;
        
    }
    
    private void exc(char[] c,int i,int j){
    	char temp = c[i];
    	c[i] = c[j];
    	c[j] = temp;
    }
    
    public static void main(String[] args){
    	ListAllString l = new ListAllString();
    	ArrayList<String> list =l.Permutation("abcd");
    	for(String s :list){
        	System.out.println(s+",");
    	}

    }
}
