package jianzhiOffer;

public class InversePairs {
	public int[] copy;
	public int pairNum;
    public int InversePairs(int [] array) {
    	if(array==null || array.length<=1){
    		return 0;
    	}
    	copy = new int[array.length];
    	sort(array,0,array.length-1);
    	return pairNum;
    
    }
    private void sort(int[] a,int lo,int hi){
		if(lo>=hi){
			return;
		}
		int mid = (lo+hi)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		if(a[mid]<a[mid+1]){ //此语句用来处理有序的数组，此时复杂度为O（N）
			return;
		}
		merge(a,lo,mid,hi);
	}
	
	//将有序数组a[lo--mid]和有序数组a[mid+1,hi]归并成有序数组
	private void merge(int[] a,int lo,int mid,int hi){
		for(int l=lo;l<=hi;l++){
			copy[l] = a[l];
		}
		int i = lo;
		int j = mid+1;
		for(int k=lo ;k<=hi;k++){
			if(i>mid){
				a[k]=copy[j];
				j++;
			}else if(j>hi){
				a[k]=copy[i];
				i++;
			}
			else if(copy[i]>copy[j]){
				pairNum += mid-i+1;
				a[k]=copy[j];
				j++;
			}else if(copy[i]<=copy[j]){
				a[k]=copy[i];
				i++;
			}
		}
	}
	public static void main(String arg[]){
		InversePairs i = new InversePairs();
		int[] c = {1,2,3,4,5,6,7,0,11,21,32,28,98,22,33,41};
		System.out.println(i.InversePairs(c));
		
	}
}
