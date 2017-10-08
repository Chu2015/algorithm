package zzz_BiShiTi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 马戏团 {
	 public static void main(String[] args) {
    	Info dis[] = null;
        Scanner sc = new Scanner(System.in);
        int[] dp = null;
        
        while (sc.hasNextInt()) {//注意while处理多个case
        	  int n = sc.nextInt();
        	  dis = new Info[n];
        	  dp = new int[n];
        	  for(int i=0;i<n;i++){
        		  int index = sc.nextInt();
        		  int w = sc.nextInt();
        		  int h = sc.nextInt();
        		  dis[i] = new Info(w,h);
        	  }

        	  Arrays.sort(dis,new Comparator(){
				public int compare(Object o1, Object o2) {
					Info in1 = (Info)o1;
					Info in2 = (Info)o2;
					int w1 = in1.height;
					int w2 = in2.height;
					if(w1>w2){
						return 1;
					}else if(w1<w2){
						return -1;
					}else{
						
						return Integer.compare(in1.weight, in2.weight);
					}
				}
        	  });
        	  for(int i=0;i<n;i++){
            	  dp[i] = 1;
        	  }

        	  int result = 0;
        	  for(int i=1;i<n;i++){
        		  for(int j=0;j<i;j++){
        			  if(dis[i].weight>dis[j].weight || (dis[i].weight==dis[j].weight && dis[i].height==dis[j].height)){
        				  dp[i] = dp[i]<dp[j]+1 ? dp[j]+1 : dp[i];
        			  }
        		  }
        		  result = result>dp[i]?result:dp[i];
        	  }
        	  System.out.println(result);
        }
	 }
}
class Info{
	public int weight;
	public int height;
	public Info(int w,int h){
		this.weight = w;
		this.height = h;
	}
}
