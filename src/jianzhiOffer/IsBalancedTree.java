package jianzhiOffer;

public class IsBalancedTree {
	
//    public boolean IsBalanced_Solution(TreeNode root) {
//    	//边界情况
//    	if(root==null){
//    		return true;
//    	}
//    	//前序遍历
//        if(Math.abs(TreeDepth(root.left)-TreeDepth(root.right))>1){
//        	return false;
//        }
//    	//递归
//        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
//    }
	
	
	public Boolean b = true;
    public boolean IsBalanced_Solution(TreeNode root) {
    	TreeDepth(root);
    	return  b;
    }
    
    //O(n)
    public int TreeDepth(TreeNode root) {
    	if(root==null){
    		return 0;
    	}
    	
    	int leftDepth = TreeDepth(root.left);
    	int rightDepth = TreeDepth(root.right);
    	
    	if(Math.abs(leftDepth-rightDepth)>1){
    		b = false;
    	}
    	
		return leftDepth>rightDepth ? leftDepth+1:rightDepth+1;      
  
    }
    
    
    
	public static void main(String args[]){
		IsBalancedTree i = new IsBalancedTree();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.left.right.left = new TreeNode(7);
		
		System.out.println(i.IsBalanced_Solution(root));
	}
}
