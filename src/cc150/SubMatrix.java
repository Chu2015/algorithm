package cc150;

public class SubMatrix {
	
    public int sumOfSubMatrix(int[][] mat, int n) {
        int Max = Integer.MIN_VALUE;
    	//int[] temp = null;
    	//对二维数组每一行遍历
    	for(int i=0;i<n;i++) {
    		int[] temp = mat[i];
    		//此行的连续最大子数组和
    		Max = Math.max(Max, maxSumofArray(temp));
    		//遍历此行下面的每一行
    		for(int j=i+1;j<n;j++) {
    			//遍历第j行的每一个数，累加到第i行的数组temp中
    			for(int k=0;k<n;k++) {
    				temp[k] += mat[j][k];
    				//计算累加后的连续最大子数组和，可以遍历每一个子矩阵
    			}
    			Max = Math.max(Max, maxSumofArray(temp));
    		}
    	}
    	return Max;
    }
    
    public int maxSumofArray(int[] a) {
    	int max = Integer.MIN_VALUE;
        int sum = a[0];
    	for(int i=1;i<a.length;i++) {
    		if(sum > 0) {
    			sum = sum + a[i];
    		}else {
    			sum = a[i];
    		}
    		max = max>sum ? max : sum;
    	}
    	return max;	
    }
    
    public static void main(String[] args) {
    	SubMatrix s = new SubMatrix();
    	int[][] mat = new int[][] {{-1,1},{-2,24}};
    	System.out.println(s.sumOfSubMatrix(mat, 2));
	}
}
