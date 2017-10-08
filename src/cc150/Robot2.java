package cc150;

public class Robot2 {
	public int countWays(int[][] map, int x, int y) {
        int[][] dp = new int [x][y];
        if(map[0][0]==1) {
        	dp[0][0] = 1;
        }else {
        	return 0;
        }
        for(int i=1;i<x;i++){
            if(map[i][0]!=1) {
            	dp[i][0] = 0;
            }else {
            	dp[i][0] = dp[i-1][0];
            }
        }
        for(int i=1;i<y;i++){
            if(map[0][i]!=1) {
            	dp[0][i] = 0;
            }else {
            	dp[0][i] = dp[0][i-1];
            }
        }
        for(int i=1;i<x;i++){
           for(int j=1;j<y;j++){
               if(map[i][j]==1) {
            	   dp[i][j] = dp[i-1][j]+dp[i][j-1];
               }else {
            	   dp[i][j] = 0;
               }   
       	   }
        }
        return dp[x-1][y-1];
    }
}
