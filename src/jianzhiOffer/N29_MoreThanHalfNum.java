package jianzhiOffer;

import java.util.HashMap;

public class N29_MoreThanHalfNum {
	//需要额外的存储空间
    public int MoreThanHalfNum_Solution2(int [] array) {
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
    
    //
    public int MoreThanHalfNum_Solution(int [] array) {
    	if(array==null || array.length==0){
    		return 0;
    	}
    	int len = array.length;
    	if(len==1){
    		return array[0];
    	}
    	
    	int start = 0;
    	int end = len-1;
        int index = partion(array,start,end);
        
    	while(index != len/2){
    		 if(index<len/2){
    			 index = partion(array,index+1,end);
    		 }else{
    			 index = partion(array,start,index-1);
    		 }
    	}
    	boolean isMoreThanHalf = checkMoreThanHalf(array,index);
    	if(isMoreThanHalf){
    		return array[index]; 
    	}
    	return 0;
    }
    
    
    private boolean checkMoreThanHalf(int[] array, int index) {
    	int time = 0;
    	int result = array[index];
		for(int i = 0;i<array.length;i++){
			if(array[i]==result){
				time++;
			}
		}
		
		if(time<=array.length/2){
			return false;
		}
		return true;
	}

	public int partion(int[] array, int start, int end) {
    	int lo = start+1;
    	int hi = end;
    	while(lo<hi){
    		while(array[lo]<=array[start] && lo<end){
    			lo++;
    		}
    		while(array[hi]>=array[start] && hi>start){
    			hi--;
    		}
    		if(lo<hi){
    			swap(array,lo,hi);
    		}
    	}
    	swap(array,start,hi);
		return hi;
	}

	private void swap(int[] array, int lo, int hi) {
		int temp = array[lo];
		array[lo] = array[hi];
		array[hi] = temp;
		
	}

	//快速排序乱入
	public void QuickSort(int[] array){
		QuickSort(array,0,array.length-1);
	}
	
	private void QuickSort(int[] array,int lo,int hi){
		if(lo>=hi){
			return;
		}
		int i = partion(array,lo,hi);
		QuickSort(array,lo,i-1);
		QuickSort(array,i+1,hi);
		
	}
	
	//第三种解法
	public int MoreThanHalfNum_Solution3(int [] array) {
	        int length=array.length;
	        if(array==null||length<=0){
	            return 0;
	        }
	        
	        int result=array[0];
	        int times=1;
	        for(int i=1;i<length;i++){
	            if(times==0){
	                result=array[i];
	                times=1;
	            }else{
	                if(array[i]==result){
	                    times++;
	                }else{
	                    times--;
	                }
	            }
	        }
	        
	        //验证是否超过了一半
	        times=0;
	        for(int i=0;i<length;i++){
	            if(result==array[i]){
	                times++;
	            }
	       }
	            
	       if(times*2<=length){
	           result=0;
	       }
	       return result;
	}
	public static void main(String[] args){
    	N29_MoreThanHalfNum m = new N29_MoreThanHalfNum();
    	int[] a = {1,1,2,2,3};
    	
    	System.out.println(m.MoreThanHalfNum_Solution3(a));
    	for(int i:a){
    		System.out.println(i+",");
    	}
    }
}
