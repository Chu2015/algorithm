package jianzhiOffer;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    
}
public class FindSumPathFromBST {
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		if(root==null){
			return null;
		}
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		
		//闈為�褰掔殑鍓嶅簭閬嶅巻
		FindPath(root, stack, list, target,0);
		
		
		return list;
	}
	
	public void FindPath(TreeNode node,Stack<Integer> stack,ArrayList<ArrayList<Integer>> listoflist,int sum,int currentsum){
		stack.add(node.val);
		if(isleaf(node)){
			if(node.val == sum-currentsum){
				ArrayList<Integer> list = new ArrayList<Integer>(stack);
				listoflist.add(list);
				stack.pop();
				return;
			}else{
				stack.pop();
				return;
			}
		}
		
		if(node.left != null){
			FindPath(node.left ,stack ,listoflist, sum, currentsum+node.val);
		}
		if(node.right != null){
			FindPath(node.right ,stack,listoflist,sum, currentsum+node.val);
		}
		stack.pop();
	}
	
	public boolean isleaf(TreeNode node){
		return node.left==null && node.right==null;
	}
	
	public static void main(String args[]){
		FindSumPathFromBST fsp = new FindSumPathFromBST();
		
//		TreeNode root = new TreeNode(10);
//		root.left = new TreeNode(5);
//		root.right = new TreeNode(12);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(7);
		
		List list = fsp.FindPath(new TreeNode(1),0);
		return;
	}
	//閫掑綊
//	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
//		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//		if(root == null){
//			return null;
//		}
//		if(root.left==null && root.right==null){
//			if(root.val == target){
//				 result.add(new ArrayList<Integer>(target));
//				 return result;
//			}else{
//				return null;
//			}
//		}
//		if(root.left != null){
//			result = FindPath(root.left,target - root.val);
//		}
//		if(root.right != null){
//			result = FindPath(root.right,target - root.val);
//		}
//		return result;
//    }
	
	
//	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
//		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
//		Stack<Integer> stack = new Stack<Integer>();
////		stack.add(root);		
////		//闈為�褰掔殑鍚庡簭閬嶅巻
////		while(stack!=null){
////			while(root!=null && root.left!=null){
////				root = root.left;
////				stack.add(root);
////			}
////
////			TreeNode cur = stack.peek();
////			if(cur.right!=null){
////				root = cur.right;
////				cur.right = null;
////			}else{
////				root = null;
////				TreeNode pre = stack.pop();
////			}
////			
////		}
//		
//		//闈為�褰掔殑鍓嶅簭閬嶅巻
//		FindPath(root, stack, list, target,root.val);
//			
//		
//		return null;
//	}
}
