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
            	stack.push(root);//先将自己和自己左边的所有结点加入栈中
            	root = root.left;
            }
            current = stack.pop(); //弹出当前结点并加入list
            list.add(current.val);
            root = current.right;  //将当前结点设为它的右节点，循环加入栈中
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
