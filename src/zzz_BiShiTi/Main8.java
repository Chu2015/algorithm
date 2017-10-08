package zzz_BiShiTi;

import java.util.Arrays;
import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
//    	System.out.println(cmn(3,1));
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int[] a = new int[3];
            for(int i=0;i<n;i++) {
            	a[i] = in.nextInt();
            }
            System.out.println(solution(a,n));
        }
    }
    
    public static int solution(int[] a,int n) {
    	Arrays.sort(a);
    	int result = 1;

    	for(int i=n-1;i>=0;i--) {
    		result *= cmn(n,a[i]);
    	}
        
    	if(a[2] == n) {
    		return result % 1000000007;
    	}
    	if(a[2] == 1) {
    		return jiecheng(n)% 1000000007;
    	}
    	int wrong = solution(a,a[2]);
		return (result - wrong*cmn(n,a[2]))% 1000000007;
    }
    
    public static int cmn(int m,int n) {
    	int a=1;
    	int k = m;
    	while(m>=k-n+1) {
    		a *= m;
    		m--;
    	}
    	return a/jiecheng(n);
    }
    
    public static int jiecheng(int i) {
    	int result = 1;
    	while(i != 1) {
    		result *= i;
    		i--;
    	}
    	return result;
    }
}
