package cc150;

public class Checker2 {

	 public boolean checkBST(TreeNode root) {
	    	return  between(root,Integer.MIN_VALUE,Integer.MAX_VALUE);	
	 }
	 //�ݹ飬����Ϊÿ���ڵ��ȡֵ��Χ
	 public boolean between(TreeNode root,int min,int max) {
		//�߽�����
		if(root==null) {
			return true;
		}
		//������
		if(root.val <= min || root.val>max) {
			return false;
		} 
		
		return between(root.left,min,root.val) && between(root.right,root.val,max);
	 }
	 
	 
}
