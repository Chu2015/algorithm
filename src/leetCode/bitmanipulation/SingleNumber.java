package leetCode.bitmanipulation;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        if(nums == null){
            return 0;
        }
        int result = nums[0];
        for(int i = 1;i<nums.length;i++){
            result ^= nums[i];
        }
        return result;
    }
    public static void main(String[] args){
    	SingleNumber  s = new SingleNumber();
    	int[] nums = {1,13,45,34,1,3,4,34,45,13,4,9,9};
    	System.out.println(s.singleNumber(nums));
    }
}
