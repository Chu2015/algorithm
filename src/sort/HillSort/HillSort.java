package sort.HillSort;

public class HillSort {
	public static void sort(int[] a){
		
		int N = a.length;
		int h = 1;
		while(h<N/3) h=3*h+1;
		while(h>=1){
//			for(int i=h;i<a.length;i++){
//				for(int j = i; j>=h && a[j]<a[j-h]; j-=h){
//					swap(a,j,j-h);
//				}
//			}
			for(int i=0;i<h;i++){
				for(int j=i+h;j<a.length;j+=h){
					for(int k=j; k>=h&&a[k]<a[k-h]; k=k-h){
						swap(a,k,k-h);
					}
				}
			}
			h=h/3;
		}

	}
	
	public static void swap(int[] a,int i,int j){
		int k = a[i];
		a[i] = a[j];
		a[j] = k;
	}
	
	public static void main(String[] args){
		int[] c = {6,3,2,34,42,23,43,23,23,34,342,67,78};
		sort(c);
		for(int num : c){
			System.out.println(num+"_");
		}
	}
}
