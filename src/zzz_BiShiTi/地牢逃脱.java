package zzz_BiShiTi;

import java.util.Scanner;

public class µØÀÎÌÓÍÑ {
	 public static void main(String[] args) {
		   Scanner input = new Scanner(System.in);
		   int n=0;
		   int[] f = new int [50];
		   f[0]=0;
		   f[1]=1;
		   
	       while (input.hasNext()) {
	    	   n = input.nextInt();
	    	   int i;
	    	   for(i=2;n>f[i];i++){
	    		   f[i] = f[i-1]+f[i-2];
	    	   }
	    	   if(n==f[i]){
	    		   System.out.println(0);
	    	   }
	    	   System.out.println(f[i]-n>n-f[i-1] ? f[i]-n : n-f[i-1]);
	       }
	  }
	
}
