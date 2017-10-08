package cc150;

public class GoUpstairs {
	public int countWays(int n) {
    	int pre = 1;
    	int result = 2;
    	if(n<=1){
    		return 0;
    	}
    	if(n==2){
    		return 1;
    	}
        if(n==3){
    		return 2;
    	}
    	for(int i=4; i<=n ;i++){
    		int temp = result;
    		result = pre+result;
    		pre =temp;
    	}
    	return result % 1000000007;
    }
	public static void main(String[] args) {
		GoUpstairs g = new GoUpstairs();
		System.out.println(g.countWays(44));
	}
}
