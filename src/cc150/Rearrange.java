package cc150;

public class Rearrange {
	
    public int[] findSegment(int[] A, int n) {
        // write code here
    	int[] result = new int[2];
    	int left =0;
    	int right=0;
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	for(int i=0;i<n;i++) {
    		if(A[i]>=max) {
    			max = A[i];
    		}else {
    			right = i;
    		}
    	}
    	for(int i=n-1;i>=0;i--) {
    		if(A[i]<=min) {
    			min = A[i];
    		}else {
    			left = i;
    		}
    	}
    	result[0] = left;
    	result[1] = right;
    	return result;
    	
    }
}
