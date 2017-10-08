package cc150;

import java.util.*;

public class MaxSum {
    public int getMaxSum(int[] A, int n) {
        // write code here
        if(A==null){
            return 0;
        }
        int sum = 0;
        int maxsum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(sum>0){
                sum = sum + A[i];
            }else{
                sum = A[i];
            }
            maxsum = maxsum>sum ? maxsum:sum;
        }
        return maxsum;
    }
}
