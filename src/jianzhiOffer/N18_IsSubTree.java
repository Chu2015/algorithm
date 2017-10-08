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
    	//ȷ�����������������������Ϊ�յ���
    	if(root2==null || root1==null){
    		return false;
    	}
    	return subHasSubTree(root1,root2);
    }
    
    //  dicide if root2 is subtree of root1( two not-null binaryTree)
    private boolean subHasSubTree(TreeNode root1,TreeNode root2){
    	//�߽������Ĵ������root2�Ѿ��ȵ��յĵز���˵��ǰ��Ķ���ͬ���Ѿ��ɹ�
    	if(root2==null){
    		return true;
    	}
    	//root2��Ϊ�գ�root1Ϊ�ձ�Ȼʧ��
    	if(root1==null){
    		return false;
    	}
    	//��һ���ݹ飬��Ե�ǰ��㣬�����ǰ���tree2��tree1ֵ��ͬ���ٷֱ�Ƚ�������������������
    	if(root1.val==root2.val && subHasSubTree(root1.left,root2.left) && subHasSubTree(root1.right ,root2.right)){
    		return true;
    	}
    	//�ڶ����ݹ飬���ÿ�����������������������
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
