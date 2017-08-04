package zzz_MianShiTi;

import java.util.Scanner;

public class Shengjizhilu {
	public static void main(String[] args) {
	  int b = 0;
	  int a = 0;
	  int[] monster = null;
	  Scanner in = new Scanner(System.in);
	  while (in.hasNextInt()) {
	      b = in.nextInt();
	      monster = new int[b];
	      a = in.nextInt();
	      for(int i=0;i<b;i++){
	    	  monster[i] = in.nextInt();
	      }
	      for(int i=0;i<b;i++){
	    	  if(a>=monster[i]){
	    		  a += monster[i];
	    	  }else{
	    		  a += zuidagongyueshu(a,monster[i]) ;
	    	  }
	      }
		  
		  System.out.println(a);
      }
	
    }

	private static int zuidagongyueshu(int a, int i) {
		int y= i%a;
		while(y!=0){
		    int temp = y;
			y = a%y;
			a = temp;
		}
		return a;
	}
	
}
