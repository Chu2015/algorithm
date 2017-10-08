package jianzhiOffer;

import leetCode.array.SearchforaRange;

public class N38_GetNumberOfK {
	
    public int GetNumberOfK(int [] array , int k) {
		if(array==null || array.length==0){
			return 0;
		}
		int a = getFirstNumberGETargetIndex (array,0,array.length-1,k);
		int b = getFirstNumberGETargetIndex (array,0,array.length-1,k+1);
		
    	return b-a;
        
    }
    
    //
    public int getFirstNumberGETargetIndex (int[] array,int lo,int hi,int target){
    	if(lo>=hi){
    		if(array[lo]>=target){
        		return lo;
    		}else{
    			return hi+1;
    		}
    	}
    	
    	int mid = (hi+lo)/2;
    	if(array[mid]>=target){
    		hi = mid;
    	}else{
    		lo = mid+1;
    	}
    	
		return getFirstNumberGETargetIndex (array,lo,hi,target);
    } 
    public static void main(String[] args){
    	N38_GetNumberOfK s = new N38_GetNumberOfK();
    	int[] nums = {1,2,3,3,3,3,3,3,4,5,6};
    	//System.out.println(s.findTheFirstNumGreaterOrEqalToTheTarget(nums, 3));
    	int result = s.GetNumberOfK(nums, 8);
        System.out.println(result);	
    }
    
}
