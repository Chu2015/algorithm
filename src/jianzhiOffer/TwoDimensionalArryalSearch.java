package jianzhiOffer;

public class TwoDimensionalArryalSearch {
	
	
    public boolean Find(int target, int [][] array) {
    	int k=0;
    	int len = array.length;
    	for(int i = len-1;i>=0;i--){
    		int len2 = array[i].length;
    		for(int j = k ; j<len2 ; j++){
    			if(array[i][j] == target){
        			return true;
        		}else if(array[i][j] > target){
        			k = j;
        			break;
        		}else if(array[i][j] < target){
        				
        		}
    		}
    	}
		return false;
    }
}
