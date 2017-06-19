package jianzhiOffer;

import java.util.HashMap;

public class IsPopOrder {
	
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	HashMap<Integer,Integer> map = new HashMap();
    	int [] popB = new int[popA.length];
    	for(int i=0;i<pushA.length;i++){
    		map.put(pushA[i], i+1);
    	}
    	for(int i=0;i<popA.length;i++){
    		popB[i] = map.get(popA[i]);
    	}
    	for(int i=0;i<popA.length;i++){
    		for(int j=i+1;j<popA.length;j++){
        		if(popA[j]>popA[i]){
        			continue;
        		}else{
        			
        		}
        	}
    	}
    	
    	
    	
    	
    	
    	
    	
		return false;
        
    }
    
    
}
