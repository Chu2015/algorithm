package dynamicProgramming;

import java.util.Arrays;

public class Candy {
//    public int candy(int[] ratings) {
//        int len = ratings.length;
//        int[] dp = new int[len];
//        dp[0] = 1;
//        for(int i=1;i<len;i++) {
//        	if(ratings[i]>ratings[i-1]) {
//        		dp[i] =dp[i-1]+1;
//        	}else if(ratings[i]<ratings[i-1]){
//        		dp[i] = 1;
//        		int j = i;
//        		while(j-1>=0 && ratings[j]<ratings[j-1] && dp[j]>=dp[j-1] ) {
//        			dp[j-1]++;
//        			j--;
//        		}
//        	}else{
//                dp[i] = 1;
//            }
//        }
//        int sum =0;
//        for(int i = 0;i<len;i++) {
//        	sum += dp[i];
//        }
//		return sum;
//    }
	
		public int candy(int[] ratings) {
			if(ratings==null || ratings.length==0) {
				return 0;
			}
			int[] count = new int[ratings.length];
			//每个孩子初始都有一个糖果
			Arrays.fill(count,1);
			int sum = 0;
			for(int i=1;i<ratings.length;i++) {
				if(ratings[i]>ratings[i-1]) {
					count[i] = count[i-1]+1;
				}
			}
			
			for(int i=ratings.length-1;i>0;i--) {
				sum+=count[i];
					if(ratings[i]<ratings[i-1] && count[i]>=count[i-1]) {
						count[i-1] = count[i]+1;
					}
			}
			sum+=count[0];
			return sum;
		}
}
