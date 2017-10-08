package zzz_BiShiTi;

import java.util.Scanner;

public class 裁剪网格纸 {

	  public static void main(String[] args) {
	    	int x[] = null;
	    	int y[] = null;
	    	int dis[][] = null;
	        Scanner sc = new Scanner(System.in);
	        
	        while (sc.hasNextInt()) {//注意while处理多个case
	        	int n = sc.nextInt();
	        	x = new int[n];
	        	y = new int[n];
	        	for(int i=0;i<n;i++) {
	        		x[i] = sc.nextInt();
	        		y[i] = sc.nextInt();
	        	}
	        	int minx = Integer.MAX_VALUE;
	        	int maxx = Integer.MIN_VALUE;
	        	int miny = Integer.MAX_VALUE;
	        	int maxy = Integer.MIN_VALUE;
	        	for(int i=0;i<n;i++) {
	        		if(x[i]<minx) {minx = x[i];}
	        		if(x[i]>maxx) {maxx = x[i];}
	        		if(y[i]<miny) {miny = y[i];}
	        		if(y[i]>maxy) {maxy = y[i];}
	        	}
	        	int disx = maxx - minx; 
	        	int disy = maxy - miny; 
	        	int dismax = disx>disy ? disx : disy;
	        	System.out.println(dismax*dismax);
	        }
	  }
}

class Zuobiao {
	public int x;
	public int y;
	public Zuobiao(int x,int y) {
		this.x = x;
		this.y = y;
	}
}