package zzz_BiShiTi;

import java.util.Scanner;

public class ĩβ0�ĸ��� {

	public static void main(String[] args) {
		int jiecheng = 1;
		int result = 0;
		Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//ע��while������case
            int x = in.nextInt();
            while(x>0){ 
            	result += x/5; 
            	 x /= 5; 
            }
            System.out.println(result);
        }
	}
}
