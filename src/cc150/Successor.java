package cc150;

import java.util.Stack;


public class Successor {
	
    public int findSucc(TreeNode root, int p) {
        if(root==null){
        	return -1;
        }
        boolean isfound = false;
//        TreeNode parent = null;
//        while(root!=null){
//        	int v = root.val;
//        	parent = root;
//        	if(v==p){
//        		break;
//        	}else if(v>p){
//        		root = root.left;
//        	}else{
//        		root = root.right;
//        	}
//        }
//    	if(root==null){
//    		return -1;
//    	}
    	Stack<TreeNode> s =new Stack<TreeNode>();
 //   	s.add(root);
    	while(!s.isEmpty() || root!=null){
    		if(root!=null) {
        		s.push(root);
        		while(root.left!=null){
        			s.push(root.left);
        			root = root.left;
        		}
    		}
    		TreeNode pop = s.pop();
    		if(isfound) {
    			return pop.val;
    		}
    		if(pop.val==p) {
    			isfound = true;
    		}


    		root = pop.right;
    	}
    	
    	return -1;
    }
    
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}