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
	            	stack.push(root);//�Ƚ��Լ����Լ���ߵ����н�����ջ��
	            	root = root.left;
	            }
	            
	            current = stack.peek();
	            if(current.right!=null){
	            	root = current.right;  
	            	current.right = null;	//���ұ���Ϊ�գ��Ա���һ�ε���
	            }else{						//��ʱ�ұ��Ѿ�������ϣ������������stack�洢����Ȼ��ߵĽ��Ҳ�Ѿ�������ϣ����Ե���
	            	current = stack.pop();  //������ǰ��㲢����list
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
	            	stack.push(root);//�Ƚ��Լ����Լ���ߵ����н�����ջ��
	            	resultstack.push(root.val);
	            	root = root.right;
	            }
	            current = stack.pop(); //������ǰ��㲢����list
	            root = current.left;  //����ǰ�����Ϊ�����ҽڵ㣬ѭ������ջ��
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
