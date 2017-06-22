package jianzhiOffer;

import java.util.HashMap;

public class IsPopOrder {
	
	//worst complexity O(N^2)
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	if(pushA==null || popA==null || pushA.length!=popA.length){
    		return false;
    	}
    	
    	HashMap<Integer,Integer> map = new HashMap();
    	int [] popB = new int[popA.length];
    	for(int i=0;i<pushA.length;i++){
    		map.put(pushA[i], i+1);
    	}
    	for(int i=0;i<popA.length;i++){
    		if(map.get(popA[i])==null){
    			return false;
    		}
    		popB[i] = map.get(popA[i]);
    	}
    	
    	for(int i=0;i<popB.length;i++){
    		int mark = popB[i];
    		for(int j=i+1;j<popB.length;j++){
        		if(popB[j]>popB[i]){
        			continue;
        		}
    			if(popB[j]>mark){
    				return false;
    			}else{
        			mark = popB[j];
    			}
        	}
    	}
    	
		return true;
    }
    
    
    
}
