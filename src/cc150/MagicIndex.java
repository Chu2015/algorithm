package cc150;

public class MagicIndex {
	//只有正整数
//    public boolean findMagicIndex(int[] A, int n) {
//    	int mid = n/2;
//        while(mid>0) {
//        	if(A[mid]==mid) {
//        		return true;
//        	}else {
//        		mid = mid/2;
//        	}
//        }
//        return A[0]==0;
//    	
//    }
    public boolean findMagicIndex(int[] A, int n) {
        return findMagicIndex(A,0,n-1);   	
    }
    public boolean findMagicIndex(int[] A, int lo,int hi) {
        while(lo<=hi) {
	    	int mid = (lo+hi)/2;
	    	if(mid==A[mid]) {
	    		return true;
	    	}else if(mid > A[mid]) {
	    		lo = mid+1;
	    	}else {
	    		hi = mid-1;
	    	}
        }
    	return false;
    }
    
    public static void main(String[] args) {
    	MagicIndex m = new MagicIndex();
    	System.out.println(m.findMagicIndex(new int[] {-3,-2,-1,3,5,6,7,8,9}, 9));
	}
}
