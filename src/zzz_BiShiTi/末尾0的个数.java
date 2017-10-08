package zzz_BiShiTi;

import java.util.Scanner;

public class 末尾0的个数 {

	public static void main(String[] args) {
		int jiecheng = 1;
		int result = 0;
		Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int x = in.nextInt();
            while(x>0){ 
            	result += x/5; 
            	 x /= 5; 
            }
            System.out.println(result);
        }
	}
}
