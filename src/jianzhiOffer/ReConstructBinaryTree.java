package jianzhiOffer;

public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	if(pre==null || pre.length==0 || in==null || in.length==0){
    		return null;
    	}
		return reConstructBinaryTree2(pre,0,pre.length-1,in,0,in.length-1);
    }
    
    private TreeNode reConstructBinaryTree2(int [] pre,int prelo, int prehi,int [] in,int inlo, int inhi){
    	if(prelo>prehi || inlo>inhi){
    		return null;
    	}
    	int rootval = pre[prelo];
    	TreeNode root = new TreeNode(rootval);
    	int i = inlo;
    	for(i= inlo;i<=inhi;i++ ){
    		if(in[i]==rootval){
    			break;
    		}
    	}
    	int len = i - inlo;
		root.left = reConstructBinaryTree2(pre,prelo+1,prelo+len,in,inlo,i-1);
    	root.right = reConstructBinaryTree2(pre,prelo+len+1,prehi,in,i+1,inhi);
    	return root;
    }
    
    public static void main(String[] args){
    	ReConstructBinaryTree r = new ReConstructBinaryTree();
    	int[] a = {1,2,3,4,5,6,7};
    	int[] b = {3,2,4,1,6,5,7};
    	TreeNode root = r.reConstructBinaryTree(a, b);
    	System.out.println(root);
    }
}
