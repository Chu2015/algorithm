package cc150;

public class Checker3 {

	 int min = Integer.MIN_VALUE;
	 public boolean checkBST(TreeNode root) {
		 return checkBST(root,false);
	 }
	 public boolean checkBST(TreeNode root,boolean isright) {
		 if(root == null) {
			 return true;
		 }
		 if(!checkBST(root.left,false)) {
			 return false;
		 }
		 if(isright) {
			 if(root.val<=min) {
				 return false;
			 }
		 }else {
			 if(root.val<min) {
				 return false;
			 }
		 }
		 min = root.val;
		 return checkBST(root.right,true);
		 
	 }
}
