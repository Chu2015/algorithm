package leetCode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	//use hashmap:O(n)
	public int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	    	int want = target-numbers[i];
	        if (map.containsKey(want)) {
	            result[1] = i + 1;
	            result[0] = map.get(want);
	            return result;
	        }
	        map.put(numbers[i], i + 1); //key为值，value为index
	    }
	    return result;
	}
	
	//two pointers:o(n^2)
	public int[] twoSum2(int[] nums, int target) {
        for(int i = 0; i<nums.length;i++ ){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
