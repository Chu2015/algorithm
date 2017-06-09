package jianzhiOffer;

public class TwoDimensionalArryalSearch {
	
    public boolean Find(int target, int [][] array) {
    	int k=0;
    	int len = array.length;
    	//从最后一行开始
    	for(int i = len-1;i>=0;i--){
    		int len2 = array[i].length;
    		//从第k列开始
    		for(int j = k ; j<len2 ; j++){
    			if(array[i][j] == target){		//找到目标数，返回
        			return true;
        		}else if(array[i][j] > target){ //如果大于目标数，跳出这一行，到上一行	
        			k = j;						//保留跳出时的列数，使得下一次循环，仍从此列开始
        			break;
        		}						        //如果小于目标数，继续到下一列
    		}
    	}
		return false;
    }
}
