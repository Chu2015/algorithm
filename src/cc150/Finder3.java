package cc150;

public class Finder3 {
	
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
    	int[] result = new int[2];
    	int jinit=0;
    	for(int i = n-1;i>=0;i--){
    		
    		for(int j = jinit;j<m;j++){
    			int value = mat[i][j];
    			if(value==x){
    				result[0] = i;
    				result[1] = j;
    			}else if(value>x){
    				jinit = j;
    				break;
    			}else{
    				jinit = j;
    			}
    		}
    	}
    	return result;
    }
}
