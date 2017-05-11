package leetCode.array;

import java.util.List;

public class RemoveElements {

	   public int removeElement(int[] nums, int val) {
	       if(nums == null){
			   return 0;
		   }
		   int len = nums.length;
		   int high = len-1;
		   while( high>0 && nums[high] == val){
			   high--;
		   }
		   if(high == 0){
		       if(nums[high] == val){
		           nums = null;
			       return 0;
		       }else{
		           return 1;
		       }

		   }
		   for(int low= 0;low<high;low++){
			   if(nums[low] == val){
				    nums[low] = nums[high];
				    nums[high] = val;
					   while( high>0 && nums[high] == val){
						   high--;
					   }
			   }

		   }

		   return high+1;   
	   }

	    public static void main(String[] args){
	    	
	    	int  a = new RemoveElements().removeElement(new int[]{3,2,2,3}, 2);
	    	System.out.println(a);
	    }
}
