package zzz_BiShiTi;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int[] likes = new int[n];
            for(int i =0;i<n;i++){
            	likes[i] = in.nextInt();
            }
            int n2 = in.nextInt();
            int[][] query = new int[n2][3];
            for(int i =0;i<n2;i++){
            	for(int j=0;j<3;j++) {
            		query[i][j] = in.nextInt();
            	}
            }
            for(int i =0;i<n2;i++){
            	int lo = query[i][0]-1;
            	int hi = query[i][1]-1;   
            	int target = query[i][2];
            	int total = 0;
            	for(int j = lo;j<=hi;j++) {
            		if(likes[j]==target) {
            			total++;
            		}
            		  
            	}
            	System.out.println(total);
            }
            
          
        }
    }
}
