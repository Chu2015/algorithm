package jianzhiOffer;

public class BinaryTreeMirror {
//    public void Mirror(TreeNode root) {
//        submirror(root);
//    }
//    
//    public TreeNode submirror(TreeNode root){
//    	if(root==null){
//    		return null;
//    	}
//    	TreeNode left = submirror(root.left);
//    	TreeNode right  = submirror(root.right);
//    	root.right = left;
//    	root.left = right;
//		return root;
//    }
    
    public void Mirror(TreeNode root) {
    	if(root==null || (root.left==null && root.right==null)){
    		return;
    	}
    	//preorder traversal
    	TreeNode temp =root.left;
    	root.left = root.right;
    	root.right = temp;
    	
    	Mirror(root.left);
    	Mirror(root.right);
    }
    

    
    public void print(TreeNode root){
    	System.out.println(root.val);
    	if(root.left!=null){
    		print(root.left);
    	}
    	if(root.right!=null){
    		print(root.right);
    	}
    }
    
    public static void main(String[] args){
    	BinaryTreeMirror a = new BinaryTreeMirror();
    	
    	TreeNode root2 = new TreeNode(8);
    	root2.left = new TreeNode(9);
    	root2.left.left = new TreeNode(4);
    	root2.left.right = new TreeNode(7);
    	root2.right = new TreeNode(2);
    	root2.right.left = new TreeNode(1);
    	root2.right.right = new TreeNode(6);
    	a.Mirror(root2);
    	
    	
    	a.print(root2);
    }
}
