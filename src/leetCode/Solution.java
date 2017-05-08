package leetCode;

public class Solution {
	
	    
	    public Integer getMinimumDifference(TreeNode root) {
	        Integer left=null;
	        Integer right=null;
	        if(root.left!=null){
	             left = min(getMinimumDifference(root.left),root.val - root.left.val);
	        }
	        if(root.right!=null){
	             right = min(getMinimumDifference(root.right),root.right.val - root.val);
	        }
	        return min(left,right);
	    }
	    
	    private Integer min(Integer a,Integer b){
	        if(a==null && b==null){
	            return null;
	        }else if(a==null){
	            return b;
	        }else if(b==null){
	            return a;
	        }else{
	            return a<b ? a : b;
	        }
	    }
	    
	    public void rotate(int[] nums, int k) {
	        k = k%nums.length;
	        if(k==0){
	        	return;
	        }
	        int l = nums.length;
	        for(int i=0 ; i<l/2 ; i++){
	            swap(i,l-1-i,nums);
	        }
	        for(int i=0 ; i<k/2 ; i++){
	            swap(i,k-1-i,nums);
	        }
	        for(int i=k ; i<(l+k)/2;i++){
	            swap(i,l-1+k-i,nums);
	        }
	    }
	    private void swap(int i,int j,int[] nums){
	    	int temp = nums[i];
	    	nums[i] = nums[j];
	    	nums[j] = temp;
	
	    }
	    public static void main(String[] args){
	    	int[] nums = {1};
	    	Solution s= new Solution();
	    	s.rotate(nums, 0);
	    	for(int i :nums){
	    		System.out.print(i+",");
	    	}
	    }

}

class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}