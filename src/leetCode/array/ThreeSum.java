package leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
	 //time limit exceeded
	  public List<List<Integer>> threeSum(int[] nums) { 
		 List result = new ArrayList();
		 HashMap<Integer,Integer> recordmap = new HashMap();
		
		 for(int i = 0 ; i<nums.length;i++){
			 if(recordmap.containsKey(nums[i])) {
				 continue;
			 }
			 int twosum = 0 - nums[i]; 
			 HashMap<Integer,Integer> map = new HashMap();
			 for(int j=i+1; j<nums.length;j++){
				 if(recordmap.containsKey(nums[j]) || (map.containsKey(nums[j]) && map.get(nums[j])==1)) {
					 continue;
				 }
				 int want = twosum - nums[j];
				 if(map.containsKey(want)) {
					 List<Integer> singleResult = new ArrayList<Integer>();
					 singleResult.add(nums[i]);
					 singleResult.add(nums[j]);
					 singleResult.add(want);
					 result.add(singleResult);
					 map.put(nums[j],1);
					 map.put(want, 1);
				 }else {
					 map.put(nums[j], 0);
				 }
		   	 } 
			 recordmap.put(nums[i], i);
		 }
		 return result;
	  }
	  
	  //accept
	  public List<List<Integer>> threeSum2(int[] nums) {
		 Arrays.sort(nums); //先排序
		 List result = new ArrayList();
		 
		 for(int i = 0 ; i<nums.length;i++){
			 if(i!=0 && nums[i]==nums[i-1]) { //相同的数，不再重复查找
				 continue;
			 }
			 int twosum = 0 - nums[i]; 
			 HashMap<Integer,Integer> map = new HashMap();
			 for(int j=i+1; j<nums.length;j++){
				 if(map.containsKey(nums[j]) && map.get(nums[j])==1) {//在内循环中，为了避免重复（如-1，0，1，1），排除已经被查找到的数
					 continue;
				 }
				 int want = twosum - nums[j];
				 if(map.containsKey(want)) {
					 List<Integer> singleResult = new ArrayList<Integer>();
					 singleResult.add(nums[i]);
					 singleResult.add(nums[j]);
					 singleResult.add(want);
					 result.add(singleResult);
					 map.put(nums[j],1); //使用map中的value，标记此数是否已经被查找到
					 map.put(want, 1);
				 }else {
					 map.put(nums[j], 0);
				 }
		   	 } 
		 }
		 return result;
	  }
	  
	//accept(hashmap)
	  public List<List<Integer>> threeSum3(int[] nums) {
		 Arrays.sort(nums); //先排序
		 List result = new ArrayList();
		 for(int i = 0 ; i<nums.length;i++){
			 if(i!=0 && nums[i]==nums[i-1])  continue;//相同的数，不再重复查找
			 int twosum = 0 - nums[i]; 
			 HashMap<Integer,Integer> map = new HashMap();
			 for(int j=i+1; j<nums.length;j++){
				 int want = twosum - nums[j];
				 if(map.containsKey(want)) {
					 result.add(Arrays.asList(nums[i],nums[j],want));
					 while(j+1<nums.length && nums[j]==nums[j+1])  j++;//在内循环中，为了避免重复（如-1，0，1，1），排除已经被查找到的数
				 }else {
					 map.put(nums[j], j);
				 }
		   	 } 
		 }
		 return result;
	  }
	  
	  //accept(two point)
	  public List<List<Integer>> threeSum4(int[] nums) {
		 Arrays.sort(nums); //先排序
		 List result = new ArrayList();
		 for(int i = 0 ; i<nums.length-2;i++){
			 if(i!=0 && nums[i]==nums[i-1])  continue;//相同的数，不再重复查找
			 int twosum = 0 - nums[i]; 
			 int lo = i+1;
			 int hi = nums.length-1;
			 while(lo<hi) {
				 if(nums[lo]+nums[hi]==twosum) {
					 result.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
					 while(lo<hi && nums[lo+1]==nums[lo]) lo++;
					 while(lo<hi && nums[hi-1]==nums[hi]) hi--;
					 lo++;
					 hi--;
				 }else if(nums[lo]+nums[hi]<twosum) {
					 lo++;
				 }else {
					 hi--;
				 }
			 }
		 }
		 return result;
	  }
	  
	  public static void main(String[] args){
		  List list = new ThreeSum().threeSum4(new int[]{-1, 0, 1, 2, -1, -4});
	      System.out.println(list);
	  }
}
