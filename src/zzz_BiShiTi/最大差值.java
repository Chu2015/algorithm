package zzz_BiShiTi;

public class ×î´ó²îÖµ {
	
    public int getDis(int[] A, int n) {
        int len = A.length;
        int result = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            min = min<A[i] ? min:A[i];
            result = A[i]-min > result ? A[i]-min:result;
        }
		return result;
    }
}

