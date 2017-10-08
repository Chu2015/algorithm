import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    	ArrayList<Integer> array = new ArrayList();
    	
    	int[] numbers = null;
    	int k=0;
    
    	Scanner in=new Scanner(System.in);
    	String str=in.nextLine(); 
    	String sub[]=str.split(" "); 
    	int len=sub.length; 
    	
    	int []a=new int[len]; 
    	for(int i =0;i<len;i++){ 
    		a[i]=Integer.parseInt(sub[i]); 
    	}
        
       numbers = new int[len-1];
       for(int i=0;i<len-1;i++) {
      	numbers[i] = array.get(i);
       }
      
      k = array.get(len-1);
      System.out.println(getKthNumber(numbers,k));

    }
    public static int getKthNumber(int[] array,int k) {
    	if(k<=0 || k>array.length-1 || array==null || array.length==0) {
    		return -1;
    	}

    	return getKthNumber(array,0,array.length-1,k);
    }
    public static int getKthNumber(int[] array,int start,int end,int k) {
    	
    	int n = partion(array,start,end);
    	
    	if(n<k) {
    		return getKthNumber(array,n+1,end,k);
    	}else if(n>k) {
    		return getKthNumber(array,start,n-1,k);
    	}else {
    		return array[n];
    	}
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
    			exch(array,lo,hi);
    		}
    	}
    	exch(array,start,hi);
		return hi;
	}
	private static void exch(int[] a,int lo,int hi){
		int temp = a[lo];
		a[lo] = a[hi];
		a[hi] = temp;
	}

}
