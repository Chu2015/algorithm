package zzz_BiShiTi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	int x[] = null;
    	int y[] = null;
    	int dis[][] = null;
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextInt()) {//注意while处理多个case
        	  int n = sc.nextInt();
        	  dis = new int[n][n];
        	  x = new int[n];
        	  y = new int[n];
         	  for(int i = 0; i < n; i++){
              	x[i] = sc.nextInt();
              } 
              for(int i = 0; i < n; i++){
              	y[i] = sc.nextInt();
              }
              //计算dis
              for(int i = 0; i < n; i++){
                  for(int j = 0; j <= i; j++){
                      if(j==i){
                      	dis[i][j] = 0;
                      }else{
                      	dis[i][j] = Math.abs((x[i]-x[j]))+Math.abs((y[i]-y[j]));
                      	dis[j][i] = dis[i][j];
                      }
                  }
              } 
              
              for(int j = 0; j < n; j++){
              	Arrays.sort(dis[j]);;
              }

              for(int i=0;i<n;i++){
              	int result = Integer.MAX_VALUE;
                  for(int j = 0; j < n; j++){
                  	int xx = 0;
                  	for(int k = 1;k<=i;k++){
                      	xx += dis[j][k];
                  	}
                  	result = result < xx? result : xx;
                  }
                  System.out.println(result);
              }

        }

    }
}



