package dynamicProgramming;

public class LongestSubstring {
	
    public int findLongest(String A, int n, String B, int m) {
    	if(A == null || B==null || A.length()==0 || B.length()==0){
    		return 0;
    	}
    	
    	char[] charA = A.toCharArray();
    	char[] charB = B.toCharArray();
    	
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
        	dp[i][0] = 0;
        }
        for(int i=0;i<m+1;i++){
        	dp[0][i] = 0;
        }
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            	if(charA[i]==charB[j]){
            		dp[i+1][j+1] = dp[i][j]+1;
            	}else{
            		dp[i+1][j+1] = 0;
            	}
            	max = max > dp[i+1][j+1] ? max : dp[i+1][j+1];
            }
        }
		return max;
    }
    
}
