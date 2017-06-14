package leetCode.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List list  = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = null;
        
        while(!stack.isEmpty()  || root!=null){
            while(root != null){
            	stack.push(root);//�Ƚ��Լ����Լ���ߵ����н�����ջ��
            	root = root.left;
            }
            current = stack.pop(); //������ǰ��㲢����list
            list.add(current.val);
            root = current.right;  //����ǰ�����Ϊ�����ҽڵ㣬ѭ������ջ��
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
    	BinaryTreeInorderTraversal b =new BinaryTreeInorderTraversal();
    	List<Integer> list = b.inorderTraversal(node);
    	System.out.println(list);
    }
}
