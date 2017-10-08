package cc150;

public class Factor {
    public int getFactorSuffixZero(int n) {
        // write code here
    	int count=0;
    	for(int i=1;i<=n;i++) {
    		int num = i;
    		while(num%5==0) {
    			count++;
    			num=num/5;
    		}
    	}
		return count;
    }
}
