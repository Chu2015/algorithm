package zzz_BiShiTi;

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
    	
    	//ÿ�����
    	int x = 0;
    	//����ˮ��
    	int f = 0;
    	//�ֽ�
    	int d = 0;
    	//ˮ������
    	int p = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//ע��while������case
            x = in.nextInt();
            f = in.nextInt();
            d = in.nextInt();
            p = in.nextInt();   
            int result = 0;
            
            if(d<x){
            	System.out.println(result);
            	return;
            }
            
            int n = d/x;
            //ˮ��������
            if(n<=f){
            	System.out.println(n);
            	return;
            }
            d = d-x*f;
            result = f;
            int m = d/(x+p);
            result += m;
            System.out.println(result);
        }
    }
}