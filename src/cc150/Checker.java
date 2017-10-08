package cc150;

public class Checker {

    public boolean checkBST(TreeNode root) {
        if(root==null) {
        	return true;
        }
        if(root.left!=null) {
        	int left = max(root.left).val;
        	if(root.val<left) {
        		return false;
        	}
        }
        if(root.right!=null) {
        	int right = max(root.right).val;
        	if(root.val>=right) {
        		return false;
        	}
        }
    	return  checkBST(root.left) && checkBST(root.right);
    	
    }
 
    public TreeNode max(TreeNode node) {
    	if(node==null) {
    		return null;
    	}
    	while(node.right!=null) {
    		node  = node.right;
    	}
    	return node;
    }
    
    public TreeNode min(TreeNode node) {
    	if(node==null) {
    		return null;
    	}
    	while(node.left!=null) {
    		node  = node.left;
    	}
    	return node;
    } 
    
}
