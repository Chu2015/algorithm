package sort.selection;

public class SelectionSort {

	public static void sort(int[] a,int lo,int hi){
		if(lo>=hi){
			return;
		}
		ExchangeMinAndFirst(a,lo,hi);
		sort(a,lo+1,hi);
	}
	
	public static void ExchangeMinAndFirst(int[] a,int lo,int hi){
		int min = a[lo];
		int index = lo;
		for(int i=lo+1;i<hi;i++){
			if(a[i]<min){
				min = a[i];
				index = i;
			}
		}
		a[index]=a[lo];
		a[lo] = min;
	}
	
	public static void main(String arg[]){
		int[] c = {6,3,2,34,42,23,43,23,23,34,342,67,78};
		sort(c,0,c.length);
		for(int num : c){
			System.out.println(num+"_");
		}
	}
	
}
