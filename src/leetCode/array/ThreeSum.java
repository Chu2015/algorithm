package leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
	 public List<List<Integer>> threeSum(int[] nums) {
		 Arrays.sort(nums);
         
		   List result = new ArrayList();
		   for(int i = 0 ; i<nums.length;i++){
			   if(i!=0 && nums[i] == nums[i-1]){
				   continue;
			   }
			   int targetSum = 0 - nums[i];
			   HashMap map = new HashMap();
			   
			   
			   for(int j=i+1; j<nums.length;j++){
			       if(j==i+1){
			           map.put(nums[j], j);
			           continue;
			       }
				   if(j!=i+1 && nums[j] == nums[j-1]){
					   continue;
				   }
				   int target = targetSum - nums[j];
				   if(map.containsKey(target)){
				           List triplets = new ArrayList();
					       triplets.add(nums[i]);
					       triplets.add(nums[j]);
					       triplets.add(target);
					       result.add(triplets);
				   }else{
					   map.put(nums[j], j);
				   }
			   } 
		   }
		   return result;
	   }

	    public static void main(String[] args){
	    	List list = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
	    	System.out.println(list);
	    }
}
