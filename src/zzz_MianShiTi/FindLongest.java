package zzz_MianShiTi;

import java.util.Scanner;

public class FindLongest {
	public static void main(String[] args) {
		  String s = null;
		  String p = null;

		  Scanner in = new Scanner(System.in);
		  while (in.hasNext()) {
		      s = in.next();
		      p = in.next();
			  
		      if(findLongest(s,p)){
		    	  System.out.println("Yes");
		      }else{
		    	  System.out.println("No");
		      }
			 
	      }
	}
	public static boolean findLongest(String s,String p){
	      char[] chars = s.toCharArray(); 
	      char[] charp = p.toCharArray(); 
	      int i,j;
	      int k = 0;
	      for( i=0;i<p.length();i++){
	    	  char a = charp[i];
	    	  for( j=k;j<s.length();j++){
	    		  if(chars[j] == a){
	    			  k = j+1;
	    			  break;
	    		  }
	    		  if(j==s.length()-1){
	    			  return false;
	    		  }
	    	  }
	      }
		  return true;
	}	
}
