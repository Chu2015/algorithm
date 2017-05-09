package leetCode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
	 public List<List<Integer>> threeSum(int[] nums) {
         HashSet set = new HashSet();
		   List result = new ArrayList();
		   for(int i = 0 ; i<nums.length;i++){
			   int targetSum = 0 - nums[i];
			   HashMap map = new HashMap();
			   for(int j=i+1; j<nums.length;j++){
				   int target = targetSum - nums[j];
				   if(map.containsKey(target)){
				       if(!(set.contains(nums[i]) && set.contains(nums[j]) && set.contains(target))){
						   set.add(nums[i]);
						   set.add(nums[j]);
						   set.add(target);
				           List triplets = new ArrayList();
					       triplets.add(nums[i]);
					       triplets.add(nums[j]);
					       triplets.add(target);
					       result.add(triplets);
				       }
				   }else{
					   map.put(nums[j], j);
				   }
			   } 
		   }
		   return result;
	   }
	    public static void main(String[] args){
	    	List list = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
	    }
}
