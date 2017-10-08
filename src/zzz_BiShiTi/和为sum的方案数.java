package zzz_BiShiTi;

import java.util.Scanner;

public class 和为sum的方案数 {
	public static long bag(int []weight,int n,int sum){
        long dp[]=new long[sum+1];
        dp[0]=1;
        int i,j;
        for(i=0;i<n;i++){
            for(j=sum;j>=weight[i];j--){
               //阶段i当前和我为j方案数   = 上衣阶段和为j的方案数  + 上一阶段和为j-w[i]的方案数
               dp[j]=dp[j-weight[i]]+dp[j];
            }
        }
        return dp[sum];
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int sum=s.nextInt();
        int i,j;
        int arr[]=new int[n];
        for(i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        System.out.println(bag(arr,n,sum));
    }
}
