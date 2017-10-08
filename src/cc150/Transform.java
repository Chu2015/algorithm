package cc150;

public class Transform {
    public int[][] transformImage(int[][] mat, int n) {
    	int[][] result = new int[n][n];
    	for(int i=0;i<n;i++) {
    		for(int j=n-1;j>=0;j--) {
    			result[i][n-1-j] = mat[j][i];
    		}
    	}
    	return result;
    }
}
