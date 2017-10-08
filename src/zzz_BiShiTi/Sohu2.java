package zzz_BiShiTi;

import java.util.ArrayList;
import java.util.Scanner;

public class Sohu2 {
	public static void main(String[] args) {
    	int result[] = null;
    	int number[] = null;
    	ArrayList dingdanl = new ArrayList();
    	ArrayList output = new ArrayList();
    	
        Scanner sc = new Scanner(System.in);
        int[] dingdan = null;
        while (sc.hasNextInt()) {
        	dingdan = new int[6];
        	for(int i=0;i<6;i++) {
        		dingdan[i] = sc.nextInt();
        	}
        	dingdanl.add(dingdan);
        }
        for(int i=0;i<dingdanl.size()-1;i++) {
        	int packnum = 0;
        	dingdan = (int[]) dingdanl.get(i);
        	while(dingdan[5]-->0) {
        		packnum ++;
        	}
        	while(dingdan[4]-->0) {
        		int fujia1 = 11;
        		while(dingdan[0]!=0 && fujia1-->0) {
        				dingdan[0]--;
        		}
        		packnum ++;
        	}
        	while(dingdan[3]-->0) {
        		int fujia2 = 5;
        		while( dingdan[1]!=0 && fujia2-->0 ) {
        				dingdan[0]--;
        		}
        		int fujia1 = fujia2 * 4;
        		while(dingdan[0]!=0 && fujia1-->0) {
    				dingdan[0]--;
    		    }
        		packnum ++;
        	}
        	int aa = dingdan[2]/3;
        	packnum += aa;
        	int bb = dingdan[2]%3;
        	if(bb!=0) {
        		if(bb==1) {
        			int fujia2 = 5;
            		while( dingdan[1]!=0 && fujia2-->0 ) {
            				dingdan[0]--;
            		}
            		int fujia1 = fujia2 * 4+7;
            		while(dingdan[0]!=0 && fujia1-->0) {
        				dingdan[0]--;
        		    }
            		packnum ++;
        		}else if(bb==2) {
        			int fujia2 = 3;
            		while( dingdan[1]!=0 && fujia2-->0 ) {
            				dingdan[0]--;
            		}
            		int fujia1 = fujia2 * 4+6;
            		while(dingdan[0]!=0 && fujia1-->0) {
        				dingdan[0]--;
        		    }
            		packnum ++;
        		}else {
        			int fujia2 = 1;
            		while( dingdan[1]!=0 && fujia2-->0 ) {
            				dingdan[0]--;
            		}
            		int fujia1 = fujia2 * 4+5;
            		while(dingdan[0]!=0 && fujia1-->0) {
        				dingdan[0]--;
        		    }
            		packnum ++;
        		}
        	}
        	int cc = dingdan[2]/9;
        	packnum += aa;
        	int dd = dingdan[2]%9;
        	if(dd!=0) {

            		int fujia1 = 36 -4+7;
            		while(dingdan[0]!=0 && fujia1-->0) {
        				dingdan[0]--;
        		    }
            		packnum ++;

        	}
        }
        
    	for(int i=0;i<6;i++) {
    		System.out.println(dingdan[i]);
    	}
	}
}
