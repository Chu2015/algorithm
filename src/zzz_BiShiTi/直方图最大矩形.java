package zzz_BiShiTi;

import jianzhiOffer.N31_MaxSubArraySum;

public class 直方图最大矩形{
	
    public int countArea(int[] A, int n) {
       int max = 0;
       for(int i=0;i<n;i++) {
    	   max = max > A[i] ? max : A[i];
       }
       int dp[] = new int[max+1];
       int result = 0;
       for(int i=0;i<n;i++) {
    	   int maxforeach = 0;
    	   for(int j = 1;j <= max;j++) {
    		   if(j<=A[i]) {
            	   dp[j] = dp[j] + j;
            	   maxforeach = maxforeach > dp[j] ? maxforeach : dp[j];
    		   }else {
    			   dp[j] = 0;
    		   }
    	   }
    	   result = result > maxforeach ? result : maxforeach;
       }
	   return result;
    }
    public static void main(String[] args){
    	直方图最大矩形 m = new 直方图最大矩形();
    	int[] a = {281,179,386,165,88,500};
    	System.out.println(m.countArea(a, 6));
    }
}
