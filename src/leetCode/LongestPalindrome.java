package leetCode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
    	int len = s.length();
    	if(s==null || len==0){
    		return null;
    	}
    	if(len==1){
    		return s;
    	}
    	char[] c = s.toCharArray();
    	StringBuffer origin =new StringBuffer(s);
    	String reverseS = origin.reverse().toString();
    	char[] reverseC = reverseS.toCharArray();
    	
    	
    	int[][] dp = new int[len+1][len+1];
    	for(int i=0;i<len+1;i++){
    		dp[0][i] = 0;
    	}
    	
    	int result = 0;
    	int mark = 0;
    	for(int i=1;i<=len;i++){
    		dp[i][0] = 0;
    		for(int j=1;j<=len;j++){
    			if(c[i-1]==reverseC[j-1] && i-(len-j-1)==dp[i-1][j-1]){
    				dp[i][j] = dp[i-1][j-1]+1;
    			}else{
    				dp[i][j] = 0;
    			}
    			if( result<dp[i][j]){
    				result = dp[i][j];
    				mark = i-1;
    			}
    		}
    	}
    	
		return s.substring(mark-result+1, mark+1);
        
    }
    public static void main(String[] args) {
    	LongestPalindrome l = new LongestPalindrome();
    	System.out.println(l.longestPalindrome("abcbddf"));
	}
}
