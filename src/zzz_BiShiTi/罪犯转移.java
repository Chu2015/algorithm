package zzz_BiShiTi;

import java.util.Scanner;

public class �ﷸת�� {
		
	    public static void main(String[] args) {
	    	int x[] = null;
	    	int y[] = null;
	    	int dis[][] = null;
	        Scanner sc = new Scanner(System.in);
	        
	        while (sc.hasNextInt()) {//ע��while������case
	        	int n = sc.nextInt();
	        	//�����ֵ
	        	int t = sc.nextInt();
	        	//�����ķ���
	        	int c = sc.nextInt();
	        	int[] a = new int[n];
	        	for(int i=0;i<n;i++) {
	        		a[i] = sc.nextInt();
	        	}
	        	int result = 0;
	        	int sum = 0;
	        	for(int i=0;i<c;i++) {
	        		sum += a[i]; 
	        	}
	        	if(sum<=t) {
	        		result++;
	        	}
	        	for(int i=c;i<n;i++) {
	        		sum = sum+a[i]-a[i-c];
		        	if(sum<=t) {
		        		result++;
		        	}
	        	}
	        	System.out.println(result);
	        }
	    }
}
