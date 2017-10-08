package zzz_BiShiTi;
import java.util.*;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
        	//个数
            int n = in.nextInt();
            //m个不能重复
            int m = in.nextInt();
            //颜色个数
            int c = in.nextInt();
          //  boolean[][] color = new boolean[c+1][n+1];
            ArrayList<ArrayList<Integer>>  color = new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<c;i++) {
            	color.add(new ArrayList<Integer>());
            }
            for(int i =0;i<n;i++){
            	//第i个珠子多少中颜色
            	int c2 = in.nextInt();
            	for(int j=0; j<c2 ;j++) {
            		int col = in.nextInt();
            		ArrayList<Integer> eachcolor = color.get(col-1);
            		eachcolor.add(i+1);
            	}
            }
            int result=0;
            for(int i= 0;i<color.size();i++) {
            	ArrayList<Integer> eachcolor = color.get(i);
            	for(int j=1;j<eachcolor.size();j++) {
            		if((eachcolor.get(j)-eachcolor.get(j-1))<m) {
            			result++;
            			break;
            		}
            		if(j==eachcolor.size()-1) {
            			if((n-eachcolor.get(j)+eachcolor.get(0))<m) {
            				result++;
                			break;
            			}
            		}
            	}
            }
            
            System.out.println(result);
        }
    }
}
