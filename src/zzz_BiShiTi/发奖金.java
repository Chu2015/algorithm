package zzz_BiShiTi;

import java.util.Scanner;

public class 发奖金 {
	 public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    while (sc.hasNextInt()) {//注意while处理多个case
	    	int n = sc.nextInt();
	    	int[] po =  new int[n];
	    	int[] money =  new int[n];
	    	for(int i=0;i<n;i++){
	    		  po[i] = sc.nextInt(); 
	    		  money[i] = 1;
	    	}

	    	for(int i=1;i<n;i++){
	    		if(po[i]<po[i-1]){
	    			int j = i;
	    			while(j-1>=0 && money[j]>=money[j-1] && po[j]<po[j-1]){
	    				money[j-1] = money[j]+1;
	    				j--;
	    			}
	    		}else if(po[i]>po[i-1]){
	    			money[i] = money[i-1]+1;
	    		}
	    	}
	    	
	    	int result = 0;
	    	for(int i=0;i<n;i++){
	    		  result+=money[i];
	    	}
	    	System.out.println(result);
	    }
	 }
}
