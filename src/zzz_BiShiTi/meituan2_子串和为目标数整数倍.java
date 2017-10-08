package zzz_BiShiTi;

import java.util.Scanner;

public class meituan2_子串和为目标数整数倍 {

	  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        while (sc.hasNextInt()) {
	        	int n = sc.nextInt();
	        	int[] a = new int[n];
	        	int total = 0;
	        	for(int i=0;i<n;i++) {
	        		a[i] = sc.nextInt();
	        		total += a[i];
	        	}
	        	int[] dp = new int[n];
	        	int target = sc.nextInt();
	        	int maxlen = 0;
	        	for(int i=0;i<n;i++) {
	        		int length = 0;
	        		for(int j= 0;j<=i;j++) {
	        			if(j==i) {dp[j] = a[i];}
	        			else {
	        				dp[j] = dp[j]+a[i];
	        			}
	        			if((dp[j]%target)==0){
	        				int len = i+1-j;
	        				length = length > len ? length : len;
	        			}
	        		}
	        		maxlen = maxlen > length ? maxlen : length;
	        	}
	        	System.out.println(maxlen);
	        }
	  }
}
