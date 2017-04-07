package sort.mergesort;

import java.util.Arrays;

public class MergeSort {
	public static int[] copy;
	
	public static void sort(int[] a,int lo,int hi){
		copy = new int[a.length];
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
	public static void merge(int[] a,int lo,int mid,int hi){
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
				a[k]=copy[j];
				j++;
			}else if(copy[i]<=copy[j]){
				a[k]=copy[i];
				i++;
			}
		}
	}
	
	public static void main(String arg[]){
		int[] c = {6,3,2,34,42,23,43,23,23,34,342,67,78};
		sortBu(c,0,c.length -1);
		for(int num : c){
			System.out.println(num+"_");
		}
	}
	
	//自底向上
	public static void sortBu(int[] a,int lo,int hi){
		copy = new int[a.length];
		int i;
		int j;
		for(i=1;i<a.length ;i*=2){
			for(j=0;j+i<=hi;j=j+2*i){
				merge(a,j,j+i-1,Math.min(j+i+i-1,hi));
			}
		}
	}
}
