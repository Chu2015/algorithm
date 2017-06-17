package leetCode.array;

public class SearchforaRange {
	
    public int[] searchRange(int[] nums, int target) {
    	if(nums==null || nums.length==0){//for the empty array
    		int[] result = {-1,-1};
    		return result;
    	}
        int len = nums.length;
       
        int result = searchRange(nums,0,len-1,target);
        int min = result,minsearch = result;
        int max = result,maxsearch = result;
        
    	while(minsearch!=-1){	
    		minsearch = searchRange(nums,0,minsearch-1,target);
    		if(minsearch!=-1){
    			min = minsearch;
    		}
    	}
    	while(maxsearch!=-1){	
    		maxsearch = searchRange(nums,maxsearch+1,len-1,target);
    		if(maxsearch!=-1){
    			max = maxsearch;
    		}
    	}
    	
    	int[] resultarray = {min,max};
		return resultarray;
    }
    private int searchRange(int[] nums,int lo,int hi,int target){
    	int len = nums.length;
        int mid;
    	while(lo<=hi){	//caution for the boundary condition
    		mid = (lo+hi)/2;
    		if(nums[mid] == target){
    			return mid;
    		}else if(nums[mid] > target){
    			hi = mid-1;
    		}else{
    			lo = mid+1;
    		}
    	}
		return -1;
    }
//	public int[] searchRange(int[] nums, int target) {
//    	if(nums==null || nums.length==0){//for the empty array
//    		int[] result = {-1,-1};
//    		return result;
//    	}
//    	int a = findTheFirstNumGreaterOrEqalToTheTarget(nums,target);
//    	int b = findTheFirstNumGreaterOrEqalToTheTarget(nums,target+1);
//    	if(a==b){
//    		int[] result = {-1,-1};
//    		return result;
//    	}
//    	int[] result = {a,b-1};
//		return result;
//	}
//	public int findTheFirstNumGreaterOrEqalToTheTarget(int[] nums,int target){
//    	int len = nums.length;
//    	int mid;
//    	int lo = 0;
//    	int hi = len-1;
//  		while(lo<=hi){	//caution for the boundary condition
//	  		mid = (lo+hi)/2;
//	  		if(nums[mid] >= target){
//	  			hi = mid-1;
//	  		}else{
//	  			lo = mid+1;
//	  		}
//  		}
//		return lo;
//	} 
	
    public static void main(String[] args){
    	SearchforaRange s = new SearchforaRange();
    	int[] nums = {1,2,3,3,3,3,3,3,4,5,6};
    	System.out.println(s.findTheFirstNumGreaterOrEqalToTheTarget(nums, 3));
    	int[] result = s.searchRange(nums, 3);
    	for(int i: result){
    		System.out.println(i+",");
    	}
    }
}
