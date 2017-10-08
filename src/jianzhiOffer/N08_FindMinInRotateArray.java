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
			//ע��߽�����=����mid=loʱ�������Ϊ�������
			if(array[mid] >= array[lo]){
				//������������
				if(array[mid] <= array[hi]){
					return array[lo];
				}else{
				//mid�����˵�һ����������
					lo = mid +1;
				}
			}//ֻ�������ڵڶ�������������
			 else{
				if(array[mid]<array[mid-1]){
					//mid����С����λ��
					return array[mid];
				}else{
					//mid������С����λ��
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
