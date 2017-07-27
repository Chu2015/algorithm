package jianzhiOffer;

public class N31_MaxSubArraySum {
    public int FindGreatestSumOfSubArray(int[] array) {
    	if(array==null || array.length==0){
    		return 0;
    	}
    	
    	int max = Integer.MIN_VALUE;
    	int sum = 0;
    	
    	for(int i=0; i<array.length ;i++){
    		int num = array[i];
			if(sum<0){//sum为当前数组能提供给下一个数使用的最大值，所以如果之前的sum<0,直接将当前的数设为sum即可
				sum = num;
			}else{
				sum += num;
			}
			max = max>sum ? max : sum;
    	}
    	
		return max;
    }
    
    public static void main(String[] args){
    	N31_MaxSubArraySum m = new N31_MaxSubArraySum();
    	int[] a = {1,-2,3,10,-4,7,2,-5};
    	System.out.println(m.FindGreatestSumOfSubArray(a));
    }
}
