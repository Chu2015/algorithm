package sort.quicksort;

public class Quick3Way {

	public static void sort(int[] a,int lo,int hi){
		if(lo>=hi){
			return;
		}
		
		int value = a[lo];
		int le = lo;
		int ge = hi;
		
		for(int i=lo+1;i<=hi && i<=ge;){
			if(a[i]<value){
				exch(a,le,i);
				le++;
				i++;
			}else if(a[i]>value){
				exch(a,i,ge);
				ge--;
			}else{
				i++;
			}
		}
		sort(a,lo,le-1);
		sort(a,ge+1,hi);
	}
	
	private static void exch(int[] a,int lo,int hi){
		int temp = a[lo];
		a[lo] = a[hi];
		a[hi] = temp;
	}
	
	public static void main(String[] args){
		int[] c =  {6,3,2,34,42,23,43,23,23,34,342,67,78};
		sort(c , 0 ,c.length-1);
		for(int num : c){
			System.out.println(num+"_");
		}
	}
}
