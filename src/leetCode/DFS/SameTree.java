package leetCode.DFS;

public class SameTree {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//    	boolean isSame = true;
//    	if(p == null || q==null){
//    		if(p!=null || q!=null){
//    			return false;
//    		}else{
//    			return true;
//    		}
//    	}
//        if(p.left != null && q.left != null){
//        	if(isSameTree(p.left,q.left)){
//        		isSame = true;
//        	}else{
//        		return false;
//        	};
//        }else if(p.left != null || q.left!=null){
//        	return false;
//        }
//        
//        isSame = (p.val == q.val);
//        
//        if(p.right != null && q.right != null){
//        	if(isSameTree(p.right,q.right)){
//        		isSame = true;
//        	}else{
//        		return false;
//        	};
//        }else if(p.right != null || q.right!=null){
//        	return false;
//        }
//        return isSame;
//    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	boolean isSame = true;
    	if(p == null || q==null){
    		if(p!=null || q!=null){
    			return false;
    		}else{
    			return true;
    		}
    	}
    	return (p.val == q.val) && isSameTree(p.right,q.right) &&isSameTree(p.left,q.left);
    }
}
