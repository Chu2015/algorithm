package leetCode.array;

public class SearchforaRange {
	
    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int len = nums.length;
        int hi = len;
        int mid = len+1;
    	while(lo<hi){
    		mid = (lo+hi)/2;
    		if(nums[mid] == target){
    			break;
    		}else if(nums[mid] > target){
    			hi = mid-1;
    		}else{
    			lo = mid+1;
    		}
    	}
    	if(mid == len+1){
    		int[] result = {-1,-1};
    		return result;
    	}
    }
}
