package cc150;

import java.util.*;

public class AntiOrder {
	public int[] copy;
	public int result;
    public int count(int[] A, int n) {
        copy = new int[n];
        mergeSort(A, 0, A.length-1);
		return result;
    }
    
    public void mergeSort(int[] a, int lo, int hi) {
    	if(lo>=hi) {
    		return; 
    	}
    	int mid = (lo+hi)/2;
    	mergeSort(a,lo,mid);
    	mergeSort(a,mid+1,hi);
    	merge(a,lo,mid,hi);
    }
    
    public void merge(int[] a, int lo, int mid, int hi) {
    	for(int i=lo;i<=hi;i++) {
    		copy[i] = a[i];
    	}
    	int left = lo;
    	int right = mid+1;
    	for(int i=lo;i<=hi;i++) {
    		if(left>mid) {
    			a[i] = copy[right];
    			right++;
    		}else if(right>hi) {
    			a[i] = copy[left];
    			left++;
    		}else {
    			if(copy[right]>=copy[left]) {
    				a[i] = copy[left];
        			left++;
    			}else {
    				result += mid-left+1;
    				a[i] = copy[right];
        			right++;
    			}
    		}
    	}
    }
    public static void main(String[] args) {
    	AntiOrder ao = new AntiOrder();
    	System.out.println(ao.count(new int[] {8,7,5,2,4}, 5));
	}
}