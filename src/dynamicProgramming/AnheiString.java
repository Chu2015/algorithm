package dynamicProgramming;

import java.util.Scanner;

public class AnheiString {
//	public static void main(String[] args) {
//        int b =0;
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case              int a = in.nextInt();
//            b = in.nextInt();
//        }
//        System.out.println(solution(11));   
//    }

	//non-recursion is better
	public static void main(String args[]){
		int j = 23;
        long[] num = new long[30];
		num[1] = 3;
		num[2] = 9;
		for(int i=3; i<=j; i++){
			num[i] = 2*num[i-1] + num[i-2];
		}
		System.out.println(num[j]);
		System.out.println(solution(j));   
	}
	//recursion causes stackoverflow 
    public static int solution(int i){
        if(i<=0){
            return 0;
        }
        if(i==1){
            return 3;
        }else if(i==2){
            return 9;
        }else{
            return 2*solution(i-1)+solution(i-2);
        }
    }
}
