package zzz_BiShiTi;

import java.util.Scanner;

public class �����߷���Ŀ {

	
	public static void main(String[] args) {
		 int dp[][] = null;
		 Scanner sc = new Scanner(System.in);
		 while (sc.hasNextInt()) {//ע��while������case
			 int i = sc.nextInt();
	         int j = sc.nextInt();
	         dp = new int[i+1][j+1];
	         dp[0][0]=0;
	         for(int n=0;n<i+1;n++) {
	             dp[n][0]=1;
	         }
	         for(int m=0;m<j+1;m++) {
	             dp[0][m]=1;
	         }
	         for(int n=1;n<i+1;n++) {
	        	 for(int m=1;m<j+1;m++) {
	        		 dp[n][m] = dp[n][m-1] + dp[n-1][m];
	        	 }
	         }
	         System.out.println(dp[i][j]);
		 }
	}
}
