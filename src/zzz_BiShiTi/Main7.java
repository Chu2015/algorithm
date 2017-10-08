package zzz_BiShiTi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main7 {
	//public static HashMap<Integer,Integer> result = new HashMap<Integer,Integer>();
	public static int x;
	public static int fenzi = 0;
	public static int fenmu = 1;
	
	public static void printProbobility(int num){
//		for(int i=num;i<=6*num;i++){
//			result.put(i, 0);
//		}
		printProbobility(num,0);
	}
	
	public static void printProbobility(int num,int sum){
		if(num==1){
			for(int i=1;i<7;i++){
				if(sum+i>=x) {
					fenzi += 1;
				}
				//result.put(sum+i, result.get(sum+i)+1);
			}
		}else{
			for(int i=1;i<7;i++){
				printProbobility(num-1,i+sum);
			}	
		}
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            x = in.nextInt();
            printProbobility(n);
            while(n-->0) {
            	fenmu = 6 * fenmu;
            }
            if(fenzi==0) {
            	System.out.println("0");
            	return;
            }else if(fenzi == fenmu) {
            	System.out.println("1");
            	return;
            }
            int k = yueshu(fenmu,fenzi);
            if(k!=0) {
            	fenmu /= k;
            	fenzi /= k;
            }
            System.out.println(fenzi+"/"+fenmu);
        }
    }
    
    public static int yueshu (int m,int n) {
    	int k = m % n;
    	while(k!=0) {
    		m = n;
    		n = k;
    		k = m % n;
    	}
    	return n;
    }
}
