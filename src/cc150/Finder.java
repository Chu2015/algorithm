package cc150;

import java.util.*;

public class Finder {
    public int findElement(int[] A, int n, int x) {
        // write code here
        int lo = 0;
        int hi = n-1;
        
        while(lo<=hi){
        	int mid = (lo+hi)/2;
            if(A[mid]==x){
            	return mid;
            }else if(A[mid]<x){
            	if(A[lo]>A[mid] && x>A[hi]){
            		hi = mid-1;
            	}else{
            		lo = mid+1;
            	}
            }else{
            	if(A[lo]<A[mid] && x<A[lo]){
            		lo = mid+1;
            	}else{
            		hi = mid-1;
            	}
            }
        }
		return -1;
    }
    public static void main(String[] args) {
    	Finder finder = new Finder();
    	System.out.println(finder.findElement(new int[]{5,6,1,2,3,4}, 6, 3));
	}
}
