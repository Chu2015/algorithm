package zzz_BiShiTi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class 数字和为sum的方案数 {
	public static void main(String[] args) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\objectfile.obj"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] a = null;
		int result = 0;
		Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int target = in.nextInt();
            a = new int[n];
            for(int i=0;i<n;i++){
            	a[i] = in.nextInt();
            }
            for(int i=0;i<a.length;i++){
            	result += solution(a,target,i);
            }
            System.out.println(result); 
        }
	}
	
	//包含了index的，和为target的总方案数
	public static int solution(int[] a,int target,int index){
		int result=0;	
		target = target-a[index];
		if(index>a.length-1 || target<0){
			return 0;
		}
		if(target==0){
			return 1;
		}
		for(int i=index+1;i<a.length;i++){
			result += solution(a,target,i);
		}
		return result;
	}

}
