package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	 public List<Integer> postorderTraversal(TreeNode root) {
	        List<Integer> list  = new ArrayList<Integer>();
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode current = null;
	        
	        while(!stack.isEmpty()  || root!=null){
	            while(root != null){
	            	stack.push(root);//先将自己和自己左边的所有结点加入栈中
	            	root = root.left;
	            }
	            
	            current = stack.peek();
	            if(current.right!=null){
	            	root = current.right;  
	            	current.right = null;	//将右边置为空，以便下一次弹出
	            }else{						//此时右边已经遍历完毕，而左边由于用stack存储，必然左边的结点也已经处理完毕，可以弹出
	            	current = stack.pop();  //弹出当前结点并加入list
		            list.add(current.val);	
	            }
	        }
	        return list;     
	 }
	 public List<Integer> postorderTraversal2(TreeNode root) {
		    Stack<Integer> resultstack = new Stack<Integer>();
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        List<Integer> list  = new ArrayList<Integer>();
	        TreeNode current = null;
	        
	        while(!stack.isEmpty()  || root!=null){
	            while(root != null){
	            	stack.push(root);//先将自己和自己左边的所有结点加入栈中
	            	resultstack.push(root.val);
	            	root = root.right;
	            }
	            current = stack.pop(); //弹出当前结点并加入list
	            root = current.left;  //将当前结点设为它的右节点，循环加入栈中
	        }
	        while(!resultstack.isEmpty()){
	        	list.add(resultstack.pop());
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
	    	BinaryTreePostorderTraversal b =new BinaryTreePostorderTraversal();
	    	List<Integer> list = b.postorderTraversal2(node);
	    	System.out.println(list);
	 }
}
