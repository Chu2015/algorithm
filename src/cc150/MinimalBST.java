package cc150;

public class MinimalBST {
    public int buildMinimalBST(int[] vals) {
      
      return   buildMinimalBST(vals,0,vals.length-1);
    	
    }
    
    public int buildMinimalBST(int[] vals,int lo,int hi) {
    	if(lo>=hi) {
    		return 1;
    	}
    	int mid = (lo+hi)/2;
    	int left = buildMinimalBST(vals,lo,mid-1);
    	int right = buildMinimalBST(vals,mid+1,hi);
    	
    	return left > right ? left+1 : right+1;
    }
    
    public static void main(String[] args) {
    	MinimalBST m = new MinimalBST();
    	System.out.println(m.buildMinimalBST(new int[]{1,2,3,4,5}));
	}
}