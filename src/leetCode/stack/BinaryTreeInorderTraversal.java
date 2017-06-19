package leetCode.stack;

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
}

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
