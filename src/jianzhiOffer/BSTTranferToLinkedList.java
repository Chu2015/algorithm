package jianzhiOffer;

public class BSTTranferToLinkedList {
	
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
	        	 while(rightTree.left != null){
	 	        	rightTree = rightTree.left;
	 	        }  
	 	        rightTree.left = pRootOfTree;
	 	        pRootOfTree.right = rightTree;
	        }
	        
	        while(pRootOfTree.left !=null){
	        	pRootOfTree = pRootOfTree.left;
	        }
	        return pRootOfTree;
	    }
}
