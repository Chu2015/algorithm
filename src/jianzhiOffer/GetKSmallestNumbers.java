package jianzhiOffer;

import java.util.ArrayList;

public class GetKSmallestNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(input.length<k || k<=0 || input==null ||input.length==0){
    		return list;
    	}
    	
    	int[] maxHeap = new int[k];
    	
    	for(int i=0;i<k;i++){
    		maxHeap[i] = Integer.MAX_VALUE;
    	}
    	
    	for(int i=0;i<input.length;i++){
    		if(input[i]<maxHeap[0]){
    			maxHeap[0] = input[i];
    			sink(maxHeap);
    		}
    	}
    	
    	for(int i=0;i<k;i++){
    		list.add(maxHeap[i]);
    	}
		return list;
        
    }
    
    public void sink(int[] array){
    	int i=0;
    	int len = array.length;
    	int compare= 0;
    	while(i*2+1<array.length){
    		compare = i*2+1;
    		if(i*2+2<array.length  && array[i*2+2]>array[i*2+1]){
    			compare = i*2+2;
    		}
    		if(array[i]>array[compare]){
    			return;
    		}
    		swap(array,i,compare);
    		i = compare;
    	}
    }
    
	private static void swap(int[] a,int b,int c){
		int temp = a[b];
	    a[b] = a[c];
	    a[c] = temp;
	}
	
    public static void main(String[] args){
    	GetKSmallestNumbers m = new GetKSmallestNumbers();
    	int[] a = {4,5,1,6,2,7,3,8};
    	System.out.println(m.GetLeastNumbers_Solution(a, 4));
    }
}
