package jianzhiOffer;

public class N03_TwoDimensionalArryalSearch {
	
    public boolean Find(int target, int [][] array) {
    	int k=0;
    	int len = array.length;
    	//从左下角开始
    	for(int i = len-1;i>=0;i--){
    		int len2 = array[i].length;
    		//浠庣k鍒楀紑濮?
    		for(int j = k ; j<len2 ; j++){
    			if(array[i][j] == target){		//得到目标数
        			return true;
        		}else if(array[i][j] > target){ //大于目标数，跳出这一行	
        			k = j;						//标记当前所在列数
        			break;
        		}						        //小于目标数，到下一列
    		}
    	}
		return false;
    }
}
