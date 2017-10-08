package zzz_BiShiTi;

import java.util.Arrays;
import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            double[] points = new double[n];
            for(int i=0;i<n;i++) {
            	points[i] = in.nextDouble();
            	
            }
            Arrays.sort(points);
            int lo=0;
            int hi=2;
   
            for(int i=2;i<n;i++) {
            	double target = points[i]-180.0;
            	int index = findBigger(points,0,i-1,target);
            	int count = i-index;
            	result += count*(count-1)/2;
            }
            boolean minusmark = false;
            int minusfirst = 0;
            if(points[0]>180) {
            	System.out.println(result);
            }
            for(int i=0;i<n;i++) {
            	if(points[i]>180) {
            		if(minusmark==false) {
            			minusfirst = i;
            			minusmark = true;
            		}
            		points[i] -= 360;
            	}
            }
           // Arrays.sort(points);
            if(minusmark) {
	            for(int i=0;i<minusfirst;i++) {
	            	if(points[i]-180>=points[n-1]) {
	            		break;
	            	}
	            	double target = points[i]-180.0;
	            	int index = findBigger(points,minusfirst,n-1,target);
	            	int count = i+(n-index);
	            	result += count*(count-1)/2-(i*i-1)/2;
	            }
            }
            System.out.println(result);
        }
    }

	private static int findBigger(double[] a, int i, int j, double target) {
		// TODO Auto-generated method stub
		int lo = i;
		int hi = j;
		int mid =0 ;
		while(lo<hi) {
			mid = (lo+hi)/2;
			if(a[mid]<=target) {
				lo = mid+1;
			}else {
				hi = mid;
			}
		}
		return lo;
	}
//	public static void main(String[] args) {
//		System.out.println(findBigger(new int[] {0,5,10,56,179,180},0,5,10));
//	}
}
