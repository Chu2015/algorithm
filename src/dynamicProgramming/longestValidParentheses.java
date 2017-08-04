package dynamicProgramming;

public class longestValidParentheses {

    public int longestValidParentheses(String s) {
    	if(s==null || s.length()==0){
    		return 0;
    	}
    	char[] c = s.toCharArray();
    	int[] dp = new int[c.length]; 
    	dp[0] = 0;
    	int max = 0;
    	for(int i=1;i<c.length;i++){
    		if(c[i]==')' && c[i-1]=='('){
    			if(i==1){
    				dp[i] = 2;
    			}else{
        			dp[i] = dp[i-2]+2;
    			}

    		}else{
    			dp[i] = 0;
    		} 
    		max = max>dp[i]?max : dp[i];
    	}
		return max;
        
    }
    
    public static void main(String[] args) {
    	longestValidParentheses l= new longestValidParentheses();
    	System.out.println(l.longestValidParentheses(")()()()(())"));
	}
}
