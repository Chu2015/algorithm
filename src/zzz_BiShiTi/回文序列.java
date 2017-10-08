package zzz_BiShiTi;

import java.util.Scanner;

public class ╩ьндпРап {
	 public static void main(String[] args) {
			
	    	Scanner scanner = new Scanner(System.in);

			while(scanner.hasNext()){
				int times = 0;
				int n = scanner.nextInt();
				int[] inputArr = new int[n];
				for(int i = 0; i < n; i++){
					inputArr[i] = scanner.nextInt();
				}
				int lo = 0;
				int hi = inputArr.length-1;
				int result =0;
				while(lo<hi){
					if(inputArr[lo]<inputArr[hi]){
						result++;
						inputArr[lo+1] = inputArr[lo]+inputArr[lo+1];
						lo++;
					}else if(inputArr[lo]>inputArr[hi]){
						result++;
						inputArr[hi-1] = inputArr[lo]+inputArr[hi-1];
						hi--;
					}else{
						lo++;
						hi--;
					}
				}
				
				System.out.println(result);
			}		
		}
}
