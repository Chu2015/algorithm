package jianzhiOffer;

public class FirstDuplicate {
	
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	if(numbers==null ||numbers.length == 0 || length<1){
    		return false;
    	}
    	
        for(int i=0;i<numbers.length;i++){
        	int value = numbers[i];
        	
        	if(value>=length){
        		value = value - length;
        	}    	
    		if(numbers[value]<length){
    			numbers[value] += length;
    		}else{
    			duplication[0] = value;
    			return true;
    		}
        }
        duplication[0] = -1;
    	return false;
    }
    
    
}
