package cc150;

public class Checker2 {

	 public boolean checkBST(TreeNode root) {
	    	return  between(root,Integer.MIN_VALUE,Integer.MAX_VALUE);	
	 }
	 //递归，参数为每个节点的取值范围
	 public boolean between(TreeNode root,int min,int max) {
		//边界条件
		if(root==null) {
			return true;
		}
		//处理方法
		if(root.val <= min || root.val>max) {
			return false;
		} 
		
		return between(root.left,min,root.val) && between(root.right,root.val,max);
	 }
	 
	 
}
