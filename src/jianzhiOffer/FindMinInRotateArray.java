package jianzhiOffer;

public class FindMinInRotateArray {
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
				if(array[mid] <= array[hi]){
					return array[lo];
				}else{
					lo = mid +1;
				}
			}else{
				if(array[mid]<array[mid-1]){
					return array[mid];
				}else{
					hi = mid - 1;
				}
			}
		}
		return -1;
    }
    
    public static void main(String[] args) {
    	FindMinInRotateArray f = new FindMinInRotateArray();
    	int[] a ={33,45,88,1,2,3,4,5,6,7,8,9,10,22};
    	System.out.println(f.minNumberInRotateArray(a));
    	
    }
}
