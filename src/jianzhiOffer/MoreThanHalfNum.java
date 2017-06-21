package jianzhiOffer;

import java.util.HashMap;

public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
    	if(array==null || array.length==0){
    		return 0;
    	}
    	if(array.length==1){
    		return array[0];
    	}
    	
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i=0;i<array.length;i++){
        	if(!map.containsKey(array[i])){
        		map.put(array[i], 1);
        	}else if(map.get(array[i])==array.length/2){
        		return array[i];
        	}else{
        		map.put(array[i], map.get(array[i])+1);
        	}
        }
		return 0;
    }
    
    public static void main(String[] args){
    	MoreThanHalfNum m = new MoreThanHalfNum();
    	int[] a = {1,2,3,2,2,2,5,4,2};
    	System.out.println(m.MoreThanHalfNum_Solution(a));
    }
}
