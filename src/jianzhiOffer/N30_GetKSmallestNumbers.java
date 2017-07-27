package jianzhiOffer;

import java.util.ArrayList;

public class N30_GetKSmallestNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	//����ļ���
    	if(input.length<k || k<=0 || input==null ||input.length==0){
    		return list;
    	}
    	
    	//�½�����ʼ����������
    	int[] maxHeap = new int[k];
    	for(int i=0;i<k;i++){
    		maxHeap[i] = Integer.MAX_VALUE;
    	}
    	
    	//�������飬�������е�ֵС�����ѶѶ���ֵʱ�����Ѷ�ֵ�滻Ϊ��ǰֵ������sinkά������
    	for(int i=0;i<input.length;i++){
    		if(input[i]<maxHeap[0]){
    			maxHeap[0] = input[i];
    			sink(maxHeap);
    		}
    	}
    	
    	//�������ӵ�list
    	for(int i=0;i<k;i++){
    		list.add(maxHeap[i]);
    	}
		return list;

    }
    
    //���ѵ��³�
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
	
	public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	//����ļ���
    	if(input.length<k || k<=0 || input==null ||input.length==0){
    		return list;
    	}
    	
    	int len = input.length;
    	int p = 0,start = 0,end = len-1;
    	p = partion(input,start,end);
    	while(p!=k-1){
    		if(p>k-1){
    			end = p-1;
    		}else{
    			start = p+1;
    		}
    		p = partion(input,start,end);
    	}
    	
    	for(int i=0;i<k;i++){
    		list.add(input[i]);
    	}
		return list;
    }
	
	
	public static int partion(int[] array, int start, int end) {
    	int lo = start;
    	int hi = end;
    	while(lo<hi){
    		while(array[lo]<=array[start] && lo<end){
    			lo++;
    		}
    		while(array[hi]>=array[start] && hi>start){
    			hi--;
    		}
    		if(lo<hi){
    			swap(array,lo,hi);
    		}
    	}
    	swap(array,start,hi);
		return hi;
	}
	
    public static void main(String[] args){
    	N30_GetKSmallestNumbers m = new N30_GetKSmallestNumbers();
    	int[] a = {4,5,1,6,2,7,3,8};
    	System.out.println(m.GetLeastNumbers_Solution2(a, 4));
    }
}
