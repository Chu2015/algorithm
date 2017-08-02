package dynamicProgramming;

public class TriangleOfNumber {

	public int[][] maxSum = new int[101][101];
	public int n;
	
	//递归版本
	public int getMaxSum(int[][] a){

		n = a.length-1;
		return getMaxSum(0,0,a);
	}
	
	private int getMaxSum(int i,int j,int[][] a){
        if(i==n){
           return a[i][j];	
        }
		return a[i][j]+Math.max(getMaxSum(i+1,j, a), getMaxSum(i+1,j+1, a));
	}
	
	//非递归版本
	public int getMaxSum2(int[][] a){
		n = a.length - 1;
		for(int i=0;i<=n;i++){
			for(int j=0;j<=i;j++){
				maxSum[i][j] = a[i][j];
			}
		}
		for(int i = n-1;i>=0;i--){
			for(int j=0;j<=i;j++){
				maxSum[i][j] = maxSum[i][j]+Math.max(maxSum[i+1][j], maxSum[i+1][j+1]);
			}
		}
		return maxSum[0][0];
	}
	
	public static void main(String[] args) {
		TriangleOfNumber t = new TriangleOfNumber();
		int[][] a = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
	    System.out.println(t.getMaxSum2(a));
		
	}
	
}
