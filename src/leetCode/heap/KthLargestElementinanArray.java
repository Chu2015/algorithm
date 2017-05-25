package leetCode.heap;

public class KthLargestElementinanArray {

	   public int findKthLargest(int[] nums, int k) {

		   int len = nums.length;
		   if(len == 1){
			   return nums[0];
		   }
		   for(int i= (len-2)/2;i>=0;i--){
			   sink(nums,i,len);
		   }
		   while(--k>0){
			   nums[0] = nums[len-1];
			   len--;
			   sink(nums,0,len);
		   }
		   return nums[0]; 
	   }
	   
	   public void sink(int[] nums,int i,int len){
		   int child = i*2+1;
		   if(child>=len){
			   return;
		   }
		   if(child+1<len && nums[child+1]>nums[child]){
			   child++;
		   }
		   if(nums[i] < nums[child]){
			   int temp = nums[child];
			   nums[child] = nums[i];
			   nums[i] = temp;
			   sink(nums,child,len);
		   }
	   }
	   
	   public static void main(String[] args){
		   KthLargestElementinanArray a= new KthLargestElementinanArray();
		   System.out.println(a.findKthLargest(new int[]{3,5,2,6,77,3,44}, 3));
	   }
}
