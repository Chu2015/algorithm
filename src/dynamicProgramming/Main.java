package dynamicProgramming;


import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		  //学生个数
		  int n = 0;
		  //能力值
		  int[] a = null;
		  //选多少学生
		  int number = 0;
		  //间隔
		  int dis = 0;
		  //dp数组：表示以a[j]为结尾的，选出i个学生的最大值
		  int dpmax[][] = null;
		  int dpmin[][] = null;
		  
		  Scanner in = new Scanner(System.in);
		  while (in.hasNextInt()) {
		      n = in.nextInt();
		      a = new int[n];
		      for(int i=0;i<n;i++){
		    	  a[i] = in.nextInt();
		      }
		      number = in.nextInt();
		      dis = in.nextInt();
		      //dp数组初始化
		      int result = Integer.MIN_VALUE;
		      dpmax = new int[11][51];
			  dpmin = new int[11][51];
		      //对数组遍历
		      for(int k = 0; k<n; k++){
		    	  dpmax[1][k] = a[k];
		    	  dpmin[1][k] = a[k];
		    	  //以a[k]为结尾的i个数乘积最大值
		    	  for(int i=2;i<=number;i++){
		    		  //如果a[k]为正数，找最大值
		    			  int max = Integer.MIN_VALUE;
		    			  int min = Integer.MAX_VALUE;
		    			  //通过自底向上的方法:Max（以dis范围内的i-1个数乘积的最大值）
		    			  for(int j = 1;j <= dis && i-2<=k-j;j++){
		    				  max = max > dpmax[i-1][k-j]? max : dpmax[i-1][k-j];
		    				  min = min < dpmin[i-1][k-j]? min : dpmin[i-1][k-j];
		    			  }
		    			  if(a[k]>0){
		    				  dpmax[i][k] = max*a[k];	
		    				  dpmin[i][k] = min*a[k];
		    			  }else if(a[k]<0){
		    				  dpmax[i][k] = min*a[k];
		    				  dpmin[i][k] = max*a[k];
		    			  }
		    	  }
		    	  result = result > dpmax[number][k] ? result : dpmax[number][k];
		      }
			  System.out.println(result);
	      }
	}
}
