package jianzhiOffer;

import leetCode.bitmanipulation.SingleNumber;

public class NumberOf1 {
	 //bad way
//    public int NumberOf1(int n) {
//    	int count = 0;
//    	while(n!=0){
//    		if((n & 1) == 1){
//    			count++;
//    		}
//    		n = n>>1;
//    	}
//    	return count;
//    }
    
    public int NumberOf1(int n) {
    	int count = 0;
    	while(n!=0){
    		int oldn = n; 
    		n = n-1;
    		n = n & oldn;
    		count ++;
    	}
    	return count;
    }
    public static void main(String[] args){
    	NumberOf1 c = new NumberOf1();
    	System.out.println(c.NumberOf1(5));
    }
    
}
