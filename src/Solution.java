
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
	    
	    public static void main(String[] args){
	    	TreeNode root = new TreeNode(1);
	    	root.right = new TreeNode(3);
	    	root.right.left = new TreeNode(2);
	    	
	    	Solution s= new Solution();
	    	System.out.println(s.getMinimumDifference(root));
	    	
	    }
}

class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}