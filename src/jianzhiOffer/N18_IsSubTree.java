package jianzhiOffer;

import java.util.Stack;


public class N18_IsSubTree {
	//decide if root2 is a subtree fo root1
	
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	if(root2==null || root1==null){
    		return false;
    	}
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	while(!s.isEmpty()|| root1!=null){
			while(root1!=null){
				if(isSameTree(root1,root2)){
					return true;
				}
				s.push(root1);
				root1 = root1.left;
			}
			TreeNode cur = s.pop();
    		root1 = cur.right;
    	}	
		return false;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	//if q is this far,than is true at this root
    	if(q==null){
		return true;
    	}
		if(p==null){
			return false;
		}
    	return (p.val == q.val) && isSameTree(p.right,q.right) &&isSameTree(p.left,q.left);
    }
    //dicide if root2 is subtree of root1(both could be null)
    public boolean HasSubtree2(TreeNode root1,TreeNode root2) {
    	//确保进入迭代方法的是两个不为空的树
    	if(root2==null || root1==null){
    		return false;
    	}
    	return subHasSubTree(root1,root2);
    }
    
    //  dicide if root2 is subtree of root1( two not-null binaryTree)
    private boolean subHasSubTree(TreeNode root1,TreeNode root2){
    	//边界条件的处理，如果root2已经比到空的地步，说明前面的都相同，已经成功
    	if(root2==null){
    		return true;
    	}
    	//root2不为空，root1为空必然失败
    	if(root1==null){
    		return false;
    	}
    	//第一处递归，针对当前结点，如果当前结点tree2和tree1值相同，再分别比较他们左子树和右子树
    	if(root1.val==root2.val && subHasSubTree(root1.left,root2.left) && subHasSubTree(root1.right ,root2.right)){
    		return true;
    	}
    	//第二处递归，针对每个结点遍历，这里是先序遍历
		return subHasSubTree(root1.left,root2) || subHasSubTree(root1.right,root2);
    }
    
    public static void main(String[] args){
    	N18_IsSubTree a = new N18_IsSubTree();
    	
    	TreeNode root1 = new TreeNode(8);
    	root1.left = new TreeNode(8);
    	root1.right = new TreeNode(7);
    	root1.left.left = new TreeNode(9);
    	root1.left.right = new TreeNode(2);
    	root1.left.right.left = new TreeNode(4);
    	root1.left.right.right = new TreeNode(7);
    	
    	TreeNode root2 = new TreeNode(8);
    	root2.left = new TreeNode(9);
    	root2.right = new TreeNode(2);
    	
    	System.out.println(a.HasSubtree(root1, root2));
    }
}
