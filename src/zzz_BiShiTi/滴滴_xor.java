package zzz_BiShiTi;

import java.util.Scanner;

public class 滴滴_xor {
	public static void main(String[] args) {
		int result = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int[] numbers = new int[n];
            for(int i=0;i<n;i++) {
            	numbers[i] = in.nextInt();
            }
            int dp[] = new int[n];
            int index = 0;
            for(int i=0; i<n; i++) {
            	for(int j=index; j<=i; j++) {
            		if(numbers[i]==0) {
            			result++;
            			index = i;
            			break;
            		}
            		dp[j] = dp[j]^numbers[i];
            		if(dp[j]==0) {
            			result++;
            			index = i;
            			break;
            		}
            	}
            }
            
            System.out.println(result);
        }
    }
}
