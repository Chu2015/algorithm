package leetCode.array;

public class SearchinRotatedSortedArray {
	
    public int search(int[] nums, int target) {
    	if(nums == null){
    		return -1;
    	}    
    	
    	int len = nums.length;
    	int mid = (len-1)/2;
    	int start = 0;
    	int end = len-1;
    	
    	while(start < end){
    		
	    	if(nums[mid] > nums[start]){
	    		if(target < nums[(len-1)/2] && target > nums[start]){
	    			end = mid-1;
	    			continue;
	    		}else if(target == nums[(len-1)/2]){
	    			return mid;
	    		}else{
	    			//ตÝน้
	    		}
	    	}else if(nums[mid] < nums[start]){
	    		
	    	}
	    	
    	}
    	
    	
        return 0;
    }
    
    public int search(int[] nums,int start,int end){
    	return 0;
    }
    
}
