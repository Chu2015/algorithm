package jianzhiOffer;

import java.util.List;

public class TreeDepth {
    public int TreeDepth(TreeNode root) {
    	if(root==null){
    		return 0;
    	}
    	
		return TreeDepth(root.left)>TreeDepth(root.right) ? TreeDepth(root.left)+1:TreeDepth(root.right)+1;      
    }
	public static void main(String args[]){
		TreeDepth t = new TreeDepth();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.left.right.left = new TreeNode(7);
		
		System.out.println(t.TreeDepth(root));
	}
}
