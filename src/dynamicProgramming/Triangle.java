package dynamicProgramming;

import java.util.ArrayList;

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		 int len = triangle.size();
		 int[] dp = new int[len];
		 ArrayList<Integer> initlist = triangle.get(len-1);
		 for(int i=0;i<len;i++) {
			 dp[i] = initlist.get(i);
		 }
		 
		 for(int i=len-2;i>=0;i--) {
			 ArrayList<Integer> list = triangle.get(i);
			 for(int j=0; j<=i;j++) {
				 dp[j] = Math.min(dp[j], dp[j+1])+list.get(j);
			 }
		 }
		 
		 return dp[0];
	}
}
