package zzz_BiShiTi;

import java.util.Scanner;

public class ��ƻ�� {
	public static void main(String[] args) {
		   Scanner input = new Scanner(System.in);
		   int n=0;
		   int[] a= null;
		   
	       while (input.hasNext()) {
	    	   n = input.nextInt();
	    	   a = new int[n+1];
	    	   //�߽���������0������0����max_value��ʾ�޷�����ô���ƻ��
	    	   a[0] = 0;
	    	   for(int i=1;i<n+1;i++){
	    		   a[i] = Integer.MAX_VALUE;
	    	   }
	    	   for(int i=0;i<n+1;i++){
	    		   //max_value��ʾ�޷�����ô���ƻ��
	    		   if(a[i]==Integer.MAX_VALUE){
	    			   continue;
	    		   }
	    		   else{
	    			   //��������ô���ƻ��������һ��6����������С�Ĵ���
	    			   if(i+6<n+1){
	    				   a[i+6] = Math.min(a[i]+1, a[i+6]);
	    			   }
	    			   //��������ô���ƻ��������һ��8����������С�Ĵ���
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
