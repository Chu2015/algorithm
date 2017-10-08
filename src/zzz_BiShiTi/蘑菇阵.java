package zzz_BiShiTi;

import java.util.Scanner;

public class 蘑菇阵{
//	  public static void main(String[] args) {
//	//	  	System.out.println(String.format("%.2f", 1.115));
//	        Scanner sc = new Scanner(System.in);
//	        while (sc.hasNextInt()) {
//	        	int m = sc.nextInt();
//	        	int n = sc.nextInt();
//	        	//蘑菇个数
//	        	int k = sc.nextInt();
//	        	//概率二维数组
//	        	float dp[][] = new float[m][n];
//	        	//蘑菇标记
//	        	boolean mogu[][] = new boolean [m][n];
//	        	int pathNum[][] = new int[m][n];
//	        	
//	        	//标记蘑菇的位置
//	        	for(int i=0; i<k ;i++) {
//	        		int x = sc.nextInt();
//	        		int y = sc.nextInt();
//	        		mogu[x-1][y-1] = true;
//	        	} 
//	        	if(mogu[0][0]==true) {
//	        		System.out.println("0");
//	        		return;
//	        	}
//	        	//初始化
//	        	dp[0][0] = 1;
//	        	for(int j=1;j<n;j++) {
//	        		pathNum[0][j] = 1;
//	        		if(mogu[0][j]==true) dp[0][j] = 0;
//	        		else dp[0][j] = dp[0][j-1];
//	        	}
//	        	for(int j=1;j<m;j++) {
//	        		pathNum[j][0] = 1;
//	        		if(mogu[j][0]==true) dp[j][0] = 0;
//	        		else dp[j][0] = dp[j-1][0];
//	        	}
//	        	
//	        	for(int i=1;i<m;i++) {
//		        	for(int j=1;j<n;j++) {
//		        		int totalPath = pathNum[i][j-1] + pathNum[i-1][j];
//		        		pathNum[i][j] = totalPath;
//		        		if(mogu[i][j]) {
//		        			dp[i][j] = 0;
//		        		}else {
//		        			dp[i][j] = dp[i-1][j]*(float)pathNum[i-1][j]/totalPath+ dp[i][j-1]*(float)pathNum[i][j-1]/totalPath;
//		        		}
//		        	}
//	        	}
//	        	System.out.println(String.format("%.2f", dp[m-1][n-1]));
//	        }
//	  }
	  public static void main(String[] args){
		 Scanner sca = new Scanner(System.in);
		 while(sca.hasNext()){
			 int n = sca.nextInt();
			 int m = sca.nextInt();
			 int k = sca.nextInt();
			 boolean[][] map = new boolean[n][m];
			 for(int i = 0; i < k; i++) {
			 int x = sca.nextInt()-1;
			 int y = sca.nextInt()-1;
			 map[x][y] = true;
		  }
		  //cw[i][j]为不碰到蘑菇走到i，j的概率
		  double[][] cw = new double[n][m];
		  cw[0][0] = 1;
		  for(int i = 0; i < n; i++){
			  for(int j = 0; j < m; j++){
				  double leftright=0;
				  double updown=0;		
				  if(map[i][j]) cw[i][j] = 0;
				  else if(i == 0 && j == 0) {}
				  else {
					  if(j==0) {
						  //当前坐标在左边界上
						  leftright = 0;
					  }else {			  
						  if(i==n-1) {
							  //当前坐标在下边界上
							  leftright = cw[i][j-1];
						  }else {
							  leftright = cw[i][j-1]*0.5;
						  }
					  }
					  if(i==0) {
						  //当前坐标在上边界上
						  updown = 0;
					  }else {			  
						  if(j==m-1) {
							  //当前坐标在右边界上
							  updown = cw[i-1][j];
						  }else {
							  updown = cw[i-1][j]*0.5;
						  }
					  }
					  cw[i][j] = leftright + updown;
				  }
					//  else cw[i][j] = (j==0?0:(i+1<n?cw[i][j-1]*0.5:cw[i][j-1]))+(i==0?0:(j+1<m?cw[i-1][j]*0.5:cw[i-1][j]));
			  }
		
		  }
		  
		  double res = cw[n-1][m-1];
		  System.out.println(String.format("%.2f", res));
		}
	  }
}


