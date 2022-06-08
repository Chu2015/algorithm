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
				if(subHasSubTreeContainsRoot(root1,root2)){
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


	//dicide if root2 is subtree of root1(both could be null)
	public boolean HasSubtreeRecursively(TreeNode root1,TreeNode root2) {
		if(root1==null || root2==null){
			return false;
		}

		//第二处递归，针对每个结点遍历，这里是先序遍历
		return subHasSubTreeContainsRoot(root1, root2) || HasSubtreeRecursively(root1.left,root2) || HasSubtreeRecursively(root1.right,root2);
	}

	private boolean subHasSubTreeContainsRoot(TreeNode treeNode1, TreeNode treeNode2) {
        //边界条件的处理，如果root2已经比到空的地步，说明前面的都相同，已经成功
        if(treeNode2==null){
            return true;
        }
        //root2不为空，root1为空必然失败
        if(treeNode1==null){
            return false;
        }
        return treeNode1.val == treeNode2.val
                &&subHasSubTreeContainsRoot(treeNode1.left, treeNode2.left)
                && subHasSubTreeContainsRoot(treeNode1.right, treeNode2.right);
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
    	
    	System.out.println(a.HasSubtreeRecursively(root1, root2));
    }
}
