package leetCode.array;

public class SearchinRotatedSortedArray {
	
//    public int search(int[] nums, int target) {
//    	//ע�����鳤��Ϊ0
//    	if(nums == null || nums.length==0){
//    		return -1;
//    	}    
//    	
//    	int len = nums.length;
//    	int mid = 0, start=0, end=0;
//    	
//    	int i=0;
//    	for(i=0;i+1<len;i++){
//    		if(nums[i]>nums[i+1]){
//    			break;
//    		}
//    	}
//    	if(i+1>=len){
//    		start = 0;
//    		end = len-1;
//    	}else if(target>nums[i]){
//    		return -1;
//    	}else if(target>=nums[0]){
//    		start = 0;
//    		end = i;
//    	}else if(target<nums[0]){
//    		start = i+1;
//    		end = len-1;
//    	}
//    	
//    	//���ַ�����
//    	while(start < end){
//    		mid = (start+end)/2;
//	    	if(target == nums[mid]){
//	    		return mid;
//	    	}else if(target>nums[mid]){
//	    		start = mid+1;
//	    	}else{
//	    		end = mid-1;
//	    	}
//    	}
//    	
//        return -1;
//    }
	public int search(int[] nums, int target) {
    	if(nums == null || nums.length==0){
    		return -1;
    	}  
		int len = nums.length;
		int lo=0,hi=len-1;
		int mid = 0;
		while(lo<=hi){
			mid = (lo+hi)/2;
			if(nums[mid] == target){
				return mid;
			}
			//ע��߽�����=����mid=loʱ�������Ϊ�������
			if(nums[mid] >= nums[lo]){
				if(target<nums[mid] && target>=nums[lo]){ //ע���=
					hi = mid-1;
				}else{
					lo = mid+1;
				}
			}else{
				if(target>nums[mid] && target<=nums[hi]){ //ע���=
					lo = mid+1;
				}else{
					hi = mid-1;
				}
			}
		}
		
		return -1;
	}
    public static void main(String[] args){
    	SearchinRotatedSortedArray s =new SearchinRotatedSortedArray();
    	int[] a = {1,3};
    	System.out.println(s.search(a, 3));

    }
    
}