package leetCode.array;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums ==null){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }

        int mark = 1;
        for(int i=1 ;i< nums.length;i++){
            if(!(nums[i] == nums[i-1])){
                nums[mark] = nums[i];
                mark  ++;
            }
        }
        return mark;
    }
}
