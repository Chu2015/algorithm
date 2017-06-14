package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreePreorderTraversal {
	 public List<Integer> preorderTraversal(TreeNode root) {
	        List<Integer> list  = new ArrayList<Integer>();
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode current = null;
	        
	        while(!stack.isEmpty()  || root!=null){
	            while(root != null){
	            	stack.push(root);//先将自己和自己左边的所有结点加入栈中
	            	list.add(root.val);
	            	root = root.left;
	            }
	            current = stack.pop(); //弹出当前结点并加入list
	            root = current.right;  //将当前结点设为它的右节点，循环加入栈中
	        }
	        return list;     
	 }
	 public static void main(String[] args){
	    	TreeNode node  = new TreeNode(0);
	    	node.left = new TreeNode(1);
	    	node.right= new TreeNode(2);
	    	node.left.left = new TreeNode(3);
	    	node.left.right = new TreeNode(4);
	    	node.right.left= new TreeNode(5);
	    	node.right.right= new TreeNode(6);
	    	BinaryTreePreorderTraversal b =new BinaryTreePreorderTraversal();
	    	List<Integer> list = b.preorderTraversal(node);
	    	System.out.println(list);
	 }
}
