package leetCode.DFS;

import java.util.Stack;

public class ValidateBinarySearchTree {

//    public boolean isValidBST(TreeNode root) {
//    	if(root == null) return true;
//    	boolean isValid  = true;
//    	
//    	TreeNode left = root.left;
//    	TreeNode right = root.right;
//    	if(left != null ){
//    		while(left.right != null){
//    			left = left.right;
//    		}
//    		if(left.val >= root.val){
//    			isValid = false;
//    			return isValid;
//    		}else{
//    			isValid = isValidBST(root.left);
//        	}
//    	}
//    	
//    	if(right != null ){
//    		while(right.left != null){
//    			right = right.left;
//    		}
//    		if(right.val <= root.val){
//    			isValid = false;
//    			return isValid;
//    		}else{
//    			isValid = isValidBST(root.right);
//        	}
//    	}
//    	
//        return isValid;
//    }
    
	Stack<Integer> s = new Stack<Integer>();
	public boolean isValidBST(TreeNode root) {
		if(root == null){
			return true;
		}
		
		boolean isValid = true;
		
		if(root.left !=null){
			isValid = isValidBST(root.left);
		}
		
		if( (!s.isEmpty() && s.pop()>=root.val) || isValid==false){
			return false;
		}else{
			s.push(root.val);
		}
		if(root.right !=null){
			isValid = isValidBST(root.right);
		}
		
		return isValid;
	}
    public static void main(String args[]){
    	ValidateBinarySearchTree v= new ValidateBinarySearchTree();
    	TreeNode root  = new TreeNode(3);
    	root.right = new TreeNode(30);
    	root.right.left = new TreeNode(10);
    	root.right.left.right = new TreeNode(15);
    	root.right.left.right.right = new TreeNode(45);
    	
    	System.out.println(v.isValidBST(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
