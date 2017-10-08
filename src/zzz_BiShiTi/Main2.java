package zzz_BiShiTi;

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
    	
    	//每天租金
    	int x = 0;
    	//已有水果
    	int f = 0;
    	//现金
    	int d = 0;
    	//水果单价
    	int p = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            x = in.nextInt();
            f = in.nextInt();
            d = in.nextInt();
            p = in.nextInt();   
            int result = 0;
            
            if(d<x){
            	System.out.println(result);
            	return;
            }
            
            int n = d/x;
            //水果不用买
            if(n<=f){
            	System.out.println(n);
            	return;
            }
            d = d-x*f;
            result = f;
            int m = d/(x+p);
            result += m;
            System.out.println(result);
        }
    }
}