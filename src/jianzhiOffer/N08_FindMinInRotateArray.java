package jianzhiOffer;

public class N08_FindMinInRotateArray {
    public int minNumberInRotateArray(int [] array) {
    	if(array == null || array.length==0){
    		return 0;
    	}
    	int len = array.length;
		int lo=0,hi=len-1;
		int mid = 0;
		while(lo<=hi){
			mid = (lo+hi)/2;
			//注意边界条件=，当mid=lo时，必须归为这种情况
			if(array[mid] >= array[lo]){
				//处理有序的情况
				if(array[mid] <= array[hi]){
					return array[lo];
				}else{
				//mid落在了第一个有序数组
					lo = mid +1;
				}
			}//只可能落在第二个有序数组上
			 else{
				if(array[mid]<array[mid-1]){
					//mid是最小数的位置
					return array[mid];
				}else{
					//mid不是最小数的位置
					hi = mid - 1;
				}
			}
		}
		return -1;
    }
    
    public static void main(String[] args) {
    	N08_FindMinInRotateArray f = new N08_FindMinInRotateArray();
    	int[] a ={2,1,2,2,2};
    	System.out.println(f.minNumberInRotateArray(a));
    	
    }
}
