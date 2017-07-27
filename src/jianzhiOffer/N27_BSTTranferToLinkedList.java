package jianzhiOffer;

public class N27_BSTTranferToLinkedList {
	
	   public TreeNode Convert(TreeNode pRootOfTree) {
		    if(pRootOfTree==null){
		    	return null;
		    }
	        TreeNode leftTree = null;
	        TreeNode rightTree = null;
	        if(pRootOfTree.left != null){
	            leftTree = Convert(pRootOfTree.left);
		        while(leftTree.right != null){
		        	leftTree = leftTree.right;
		        }
		        leftTree.right = pRootOfTree;
		        pRootOfTree.left = leftTree;
	        }

	        if(pRootOfTree.right != null){
	        	rightTree = Convert(pRootOfTree.right);
	 	        rightTree.left = pRootOfTree;
	 	        pRootOfTree.right = rightTree;
	        }
	        
	        while(pRootOfTree.left !=null){
	        	pRootOfTree = pRootOfTree.left;
	        }
	        return pRootOfTree;
	    }
}
