package sort.bubble;

public class RecursionBubbleSort {

	public static void sort(int[] a,int lo,int hi){
		if(lo>=hi){
			return;
	    }
		findMax(a,lo,hi);
		sort(a,lo,hi-1);

	}
	public static void findMax(int[] a,int lo,int hi){
		 for(int i=lo;i<hi;i++){
			 if(a[i]>a[i+1]){
				 int b = a[i+1];
				 a[i+1] = a[i];
				 a[i] = b;
			 }
		  }
	}
	public static void main(String arg[]){
		int[] c = {6,3,2,34,42,23,43,23,23,34,342,67,78};
		sort(c,0,c.length -1);
		for(int num : c){
			System.out.println(num+"_");
		}
	}
}
