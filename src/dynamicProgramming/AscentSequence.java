package dynamicProgramming;

public class AscentSequence {
    public int findLongest(int[] A, int n) {
    	if(A==null || A.length==0){
    	   return 0;	
    	}
    	
    	int[] dp = new int[n];
    	
    	for(int i=0; i<n;i++ ){
    		dp[i] =1;
    	}
    	int result=1;
    	for(int i=1; i<n;i++ ){
    		int max = 0;
    		for(int j=0;j<i;j++){
    			if(A[i]>A[j]){
    				max = max>dp[j] ? max : dp[j];
    			}
    		}
    		dp[i] = max+1;
    		result = result > dp[i] ? result : dp[i];
    	}
    	
		return result;
        // write code here
    }
    
    public static void main(String[] args) {
    	AscentSequence a =new AscentSequence();
    	System.out.println(a.findLongest(new int[]{1,2,3,4}, 4));
	}
}
