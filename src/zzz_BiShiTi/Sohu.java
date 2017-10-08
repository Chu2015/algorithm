package zzz_BiShiTi;

import java.util.Scanner;

public class Sohu {
	public static void main(String[] args) {
    	int result[] = null;
    	int number[] = null;
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextInt()) {//注意while处理多个case
        	  int n = sc.nextInt();
        	  result = new int[n];
        	  
        	  int len = sc.nextInt();
        	  number = new int[len];
        	  for(int i=0;i<len;i++) {
        		  number[i] = sc.nextInt();
        	  }
        	  
    	      int i=0;
    	      //初始化
    	      result[0] = number[0];
    	      int index = 0;
    		  for(int m=0;i<n;m++) {
        		  for(int j=0;j<len && i<n;j++) {
        			  int num = number[j];
        			  int count = result[index++];
        			  if(count==0) {
        				  count = num;
        			  }
        			  while(count-->0) {
        				  if(i>=n) {
        					  break;
        				  }
            			  result[i] = num;
            			  i++;
        			  }
        		  }
    		  }
    		  for(int k=0;k<n;k++) { 
    			  System.out.println(result[k]);
    		  } 
        }
	}
}
