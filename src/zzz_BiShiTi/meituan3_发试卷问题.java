package zzz_BiShiTi;

import java.util.Scanner;

public class meituan3_∑¢ ‘æÌŒ Ã‚ {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        while (sc.hasNextInt()) {
	        	int n = sc.nextInt();
	        	int[] a = new int[n];
	        	int max = 0;
	        	int maxin = 0;
	        	for(int i=0;i<n;i++) {
	        		a[i] = sc.nextInt();
	        		if(max >a[i]) {
	        			maxin = i;
	        			max = a[i];
	        		}
	        	}
	        	int sum = 0;
	        	for(int i=0;i<n;i++) {
	        		if(i!=maxin) {
	        			sum += a[i];
	        		}
	        	}
	        	if(sum>max) {
	        		System.out.println("Yes");
	        	}else {
	        		System.out.println("No");
	        	}
	        }
	 }
}
