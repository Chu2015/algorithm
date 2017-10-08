package zzz_BiShiTi;

import java.util.Scanner;

public class 买苹果 {
	public static void main(String[] args) {
		   Scanner input = new Scanner(System.in);
		   int n=0;
		   int[] a= null;
		   
	       while (input.hasNext()) {
	    	   n = input.nextInt();
	    	   a = new int[n+1];
	    	   //边界条件，买0个至少0袋，max_value表示无法买这么多个苹果
	    	   a[0] = 0;
	    	   for(int i=1;i<n+1;i++){
	    		   a[i] = Integer.MAX_VALUE;
	    	   }
	    	   for(int i=0;i<n+1;i++){
	    		   //max_value表示无法买这么多个苹果
	    		   if(a[i]==Integer.MAX_VALUE){
	    			   continue;
	    		   }
	    		   else{
	    			   //可以买到这么多个苹果，再买一个6个，更新最小的袋数
	    			   if(i+6<n+1){
	    				   a[i+6] = Math.min(a[i]+1, a[i+6]);
	    			   }
	    			   //可以买到这么多个苹果，再买一个8个，更新最小的袋数
	    			   if(i+8<n+1){
	    				   a[i+8] = Math.min(a[i]+1, a[i+8]);
	    			   }
	    		   }
	    	   }
	    	   if(a[n]==Integer.MAX_VALUE){
	    		   System.out.println(-1);
	    	   }else{
	    		   System.out.println(a[n]);
	    	   }  
	       }
	  }
}
