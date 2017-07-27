package jianzhiOffer;

public class PublicParentNodeinTree {

	public TreeNode result;
	public TreeNode findParent(TreeNode tree,TreeNode node1,TreeNode node2){
		isInTree(tree, node1, node2);
		return null;
	}
	
	//
//	public boolean isInTree(TreeNode tree,TreeNode node1,TreeNode node2){
//		if(tree==null){
//			return false;
//		}
//		if(tree==node1 || tree==node2){
//			return true;
//		}
//		boolean isInleft = isInTree(tree.left,node1,node2);
//		boolean isInRight  = isInTree(tree.right,node1,node2);
//		
//		return isInleft || isInRight;
//	}
	
	public boolean isInTree(TreeNode tree,TreeNode node1,TreeNode node2){
		if(tree==null){
			return false;
		}
		
		boolean isInleft = isInTree(tree.left,node1,node2);
		boolean isInRight  = isInTree(tree.right,node1,node2);
		
		if(tree==node1 || tree==node2){
			return true;
		}
		
		if(isInleft && isInRight){
			result = tree;
		}
		return isInleft || isInRight;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		TreeNode node1 = new TreeNode(4);
		root.left.left = node1;
		TreeNode node3 = new TreeNode(5);
		root.left.right = node3;
		TreeNode node2 = new TreeNode(6);
		root.right.right = node2;
		TreeNode node4 = new TreeNode(7);
		root.left.right.left = node4;
		PublicParentNodeinTree p = new PublicParentNodeinTree();
		p.findParent(root, node1, node4);
		System.out.println(p.result.val);
		
	}
}
