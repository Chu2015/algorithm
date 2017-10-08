package zzz_BiShiTi;

public class ÄêÖÕ½± {
	//
    public int getMost(int[][] board) {
        int[][] dp = new int[6][6];
        dp[0][0] = board[0][0];
        for(int i=1;i<6;i++) {
        	dp[i][0] = dp[i-1][0]+board[i][0];
        	dp[0][i] = dp[0][i-1]+board[0][i];
        }
        for(int i=1;i<6;i++) {
            for(int j=1;j<6;j++) {
            	dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+board[i][j];
            }
        }
        return dp[5][5];
    }
    
    public static void main(String[] args) {
		int[][]a =new int[][] {{1,2,3,4,5,6}, {1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6}};
		ÄêÖÕ½± n = new ÄêÖÕ½±();
		n.getMost(a);
	}
}
