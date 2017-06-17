package sort.quicksort;

import java.lang.ref.SoftReference;

public class QuickSort {
	
	SoftReference<String> sr = new SoftReference<String>(new String("java"));
	
	public static void quickSort(int[] array,int lo,int hi){	

		if(lo >= hi){
			return;
		}
		int index = getLoNumToRightPosition(array,lo,hi);

		quickSort(array,lo,index-1);
		
		quickSort(array,index+1,hi);
	}
	public static int getLoNumToRightPosition2(int[] array,int lo,int hi){
		int key  = array[lo];
		int i = lo+1;
		int j = hi;
		while(i<=j){
			while(array[i] < key){
				if(i>=j){
					break;
				}
				i++;
			}
			while(array[j] > key){
				if(i>=j){
					break;
				}
				j--;
			}
			if(i>=j){
				break;
			}
			exch(array,lo,hi);
		}
		exch(array,lo,j);
		return j;
	}
	
	private static void exch(int[] a,int lo,int hi){
		int temp = a[lo];
		a[lo] = a[hi];
		a[hi] = temp;
	}
	public static int getLoNumToRightPosition(int[] array,int lo,int hi){
		//快速排序版本2
		int key = array[lo];
		while(lo<hi){
			while(key<=array[hi] && lo<hi){
				hi--;
			}
			array[lo]=array[hi];
			while(array[lo]<=key && lo<hi){
				lo++;
			}
//			array[lo]=array[lo];
		}
		array[hi]=key;//array[lo]=key;
		return hi;
		//快速排序版本1
//		while(lo<hi){
//			if(array[lo]<=array[hi] && array[lo]== key){
//				hi--;
//				continue;
//			}else if(array[lo]>=array[hi] && array[lo]== key){
//				int temp = array[hi];
//				array[hi] = array[lo];
//				array[lo] = temp;
//				lo++;
//				continue;
//			}else if(array[lo]<=array[hi] && array[hi]== key){
//				lo++;
//				continue;
//			}else if(array[lo]>=array[hi] && array[hi]== key){
//				int temp = array[hi];
//				array[hi] =array[lo];
//				array[lo] = temp;
//				hi--;
//				continue;
//			}
//		}
	}
	
	public static void main(String[] args){
		int[] c = {6,3,2,34,42,23,43,23,23,34,342,67,78};
		quickSort(c , 0 ,c.length-1);
		for(int num : c){
			System.out.println(num+"_");
		}
	}
	
}
