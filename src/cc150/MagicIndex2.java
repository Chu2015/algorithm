package cc150;

public class MagicIndex2 {
	
    public boolean findMagicIndex(int[] A, int n) {
        return findMagicIndex(A,0,n-1);
    }
    
    public boolean findMagicIndex(int[] A, int lo,int hi) {
        if(lo>hi) {
        	return false;
        }else if(lo==hi) {
        	return A[lo] == lo;
        }
    	int mid = (lo+hi)/2;
    	
    	if(mid==A[mid]) {
    		return true;
    	}
    	int newhi = Math.min(A[mid], mid-1);
    	int newlo = Math.max(A[mid], mid+1);
    	return findMagicIndex( A, lo, newhi) || findMagicIndex( A, newlo, hi);
    }
}
