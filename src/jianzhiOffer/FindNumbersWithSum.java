package jianzhiOffer;

import java.util.ArrayList;

public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    	ArrayList<Integer> list  = new ArrayList<Integer>();
    	if(array==null || array.length==0){
    		return list;
    	}
        int i = 0;
        int j = array.length-1;
        while(i<j){
        	int add  = array[i]+array[j];
        	if(add==sum){
        		list.add(array[i]);
        		list.add(array[j]);
        		return list; //只需要返回一组
        	}else if(add<sum){
        		i++;
        	}else {
        		j--;
        	}	
        }
        return list;
    }
    
    
}
