package zzz_BiShiTi;



import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 丢失的三个数 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 Scanner sc = new Scanner(System.in);
		 StringBuilder sb = new StringBuilder();
		 int[] a = new int[10001];
		 String line = null;
	        while((line = br.readLine()) != null){
	            boolean[] flag = new boolean[10000];
	            String[] s = line.trim().split(" ");
	            for(int i=0;i<s.length;i++){
	                int index = Integer.parseInt(s[i]);
	                a[index] = 1;
	            }
	            int[] miss = new int[3];
	            int index = 0;
			 for(int i=1; i<=10000;i++) {
				 if(a[i]==0) {
					 miss[index++] = i;
		                if(index == 3){
	                        break;
	                    }
				 }
			 }
			 Arrays.sort(miss);
	            sb.append(miss[0]);
	            sb.append(miss[1]);
	            sb.append(miss[2]);
			 long result = Integer.valueOf(sb.toString());
			 System.out.println(result%7);
		 }
	}
}
