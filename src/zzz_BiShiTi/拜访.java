package zzz_BiShiTi;

public class  ฐÝทร {
    public int countPath(int[][] map, int n, int m) {
        // write code here
    	
    	int len = map.length;
    	int len2 = map[0].length;
    	int x1=0,x2=0,y1=0,y2=0; 
    	int dp[][] = null;
        for(int i=0; i<len ; i++){
            for(int j=0; j<len2 ;j++){
                if(map[i][j]==1) {
                	x1 = i;
                	y1 = j;
                }else if(map[i][j]==1) {
                	x2 = i;
                	y2 = j;
                }
            }
        }
        dp = new int[10][10];
//    	for(int i=Math.min(x2, x1);i<=Math.max(x2, x1);i++) {
//    		dp[i][0] = 0;
//    	}
//    	for(int i=Math.min(y2, y1);i<=Math.max(y2, y1);i++) {
//    		dp[0][i] = 0;
//    	}
    	dp[x1][y1] = 1;
    	if(x1<=x2) {
    		for(int i=x1+1;i<=x2;i++) {
    			if(map[i][y1]==-1) {
    				dp[i][y1] = 0;
    			}else {
        			dp[i][y1] = dp[i-1][y1];
    			}
    		}
    		if(y1<=y2) {
				for(int j=y1;j<=y2;j++) {
					if(map[x1][j] == -1) {
						dp[x1][j] = 0;
					}else {
						dp[x1][j] = dp[x1][j-1];
					}
				}
			}else {
				for(int j=y1;j<=y2;j++) {
					if(map[x1][j] == -1) {
						dp[x1][j] = 0;
					}else {
						dp[x1][j] = dp[x1][j-1];
					}
				}
			}
    		
    		for(int i=x1;i<=x2;i++) {
    			if(y1<=y2) {
    				for(int j=y1;j<=y2;j++) {
    					if(map[i][j] == -1) {
    						dp[i][j] = 0;
    					}else {
    						dp[i][j] = dp[i-1][j]+dp[i][j-1];
    					}
    				}
    			}else {
    				for(int j=y1;j>=y2;j--) {
    					if(map[i][j] == -1) {
    						dp[i][j] = 0;
    					}else {
    						dp[i][j] = dp[i-1][j]+dp[i][j-1];
    					}
    				}
    			}
    		}
    	}else {
    		for(int i=x1+1;i>=x2;i--) {
    			if(map[i][y1]==-1) {
    				dp[i][y1] = 0;
    			}else {
        			dp[i][y1] = dp[i-1][y1];
    			}
    		}
    		if(y1<=y2) {
				for(int j=y1;j<=y2;j++) {
					if(map[x1][j] == -1) {
						dp[x1][j] = 0;
					}else {
						dp[x1][j] = dp[x1][j-1];
					}
				}
			}else {
				for(int j=y1;j<=y2;j++) {
					if(map[x1][j] == -1) {
						dp[x1][j] = 0;
					}else {
						dp[x1][j] = dp[x1][j-1];
					}
				}
			}
    		
    		for(int i=x1;i>=x2;i--) {
    			if(y1<=y2) {
    				for(int j=y1;j<=y2;j++) {
    					if(map[i][j] == -1) {
    						dp[i][j] = 0;
    					}else {
    						dp[i][j] = dp[i-1][j]+dp[i][j-1];
    					}
    				}
    			}else {
    				for(int j=y1;j>=y2;j--) {
    					if(map[i][j] == -1) {
    						dp[i][j] = 0;
    					}else {
    						dp[i][j] = dp[i-1][j]+dp[i][j-1];
    					}
    				}
    			}
    		}
    	}
		return dp[x2][y2];
    }
}
