package cc150;

public class GoUpstairs2 {
    public int countWays(int n) {
        // write code here
    	int first = 1;
    	int second = 2;
    	int third = 4;
        if(n==1) {
        	return first;
        }else if(n==2) {
        	return second;
        }else if(n==3) {
        	return third;
        }
        for(int i=0;i<n-3;i++) {
            int temp = third;
        	third = ((first+second)%1000000007+third)%1000000007;
            first = second;
        	second = temp;
        }
        return third;
    }
}
