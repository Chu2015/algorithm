package leetCode.tree;


import java.util.Stack;

public class RecoverTree {
    public void recoverTree(TreeNode root) {
    	TreeNode pre = null;
    	TreeNode first = null;
    	TreeNode seconed = null;
    	TreeNode current = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(!stack.isEmpty()  || root!=null){
            while(root != null){
            	stack.push(root);//先将自己和自己左边的所有结点加入栈中
            	root = root.left;
            }

            current = stack.pop();
            if(pre != null){
                if(pre.val>current.val && first == null){
                	first = pre;
                	seconed = current;
                }else if(pre.val>stack.peek().val && first != null){
                	seconed = current;
                	break;
                }
            }
            pre = current;
            
            root = pre.right;  //将当前结点设为它的右节点，循环加入栈中
        }
        
        int temp = first.val;
        first.val = seconed.val;
        seconed.val = temp;
    }
    
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}