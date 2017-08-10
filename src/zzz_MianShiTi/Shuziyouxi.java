package zzz_MianShiTi;

import java.util.Arrays;
import java.util.Scanner;

public class Shuziyouxi {
	public static void main(String[] args) {
		   Scanner input = new Scanner(System.in);
		   int n=0;
		   int miss = 0;
	       while (input.hasNext()) {
	    	   n = input.nextInt();
	    	   int[] a = new int[n];
	    	   Arrays.sort(a);
	    	   for(int i=0;i<n;i++){
	    		   a[i] = input.nextInt();
	    	   }
	    	   for(int i=0;i<n;i++){
	    	        if(a[i]>miss+1) break;
	    	        miss+=a[i];
	    	   }
	    	   
	    	   System.out.println(miss+1);
	       }
	  }
}
