package zzz_BiShiTi;


import java.util.Scanner;

链接：https://www.nowcoder.com/questionTerminal/b698e67a2f5b450a824527e82ed7495d
来源：牛客网

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
public class Shuzuhuanyuan{
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int RES = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] A = new int[n];
            boolean[] flag = new boolean[n+1];
            //flag标记哪些数字已经存在
            for(int i=0;i<n;i++){
                A[i] = sc.nextInt();
                if(A[i] != 0){
                    flag[A[i]] = true;
                }
            }
             
            //统计排列中不存在的数�?
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=1;i<=n;i++){
                if(flag[i] == false)
                    list.add(i); 
            }
             
            //perm用来存模糊数字的全排�?
            List<ArrayList<Integer>> perm = new ArrayList<ArrayList<Integer>>();
             
            //计算perm
            calperm(perm, list, 0);
             
            //统计已有的排列的顺序�?
            int cv = 0;
            for(int i=0;i<n;i++){
                if(A[i]!= 0){
                    for(int j=i+1;j<n;j++){
                        if(A[j] != 0 && A[i] < A[j])
                            cv++;
                    }
                }
            }
             
            //计算每个模糊数字排列的顺序对，如果与k相等，则结果RES加一
            for(ArrayList<Integer> tmp : perm){
                int val = cv;
                int[] tmpA = Arrays.copyOf(A, n);
                val += calvalue(tmp, tmpA);
                if(val == k)
                    RES++;
            }
             
            System.out.println(RES);
        }
    }
     
    //计算排列的顺序对
    public static int calvalue(List<Integer> list, int[] A){
        int val = 0;
        int j = 0;
        for(int i=0;i<A.length;i++){
            if(A[i] == 0){
                A[i] = list.get(j++);
                for(int k = 0;k<i;k++){
                    if(A[k]!=0 && A[k]<A[i])
                        val++;
                }
                for(int k=i+1;k<A.length;k++){
                    if(A[k]!=0 && A[k]>A[i])
                        val++;
                }
            }
        }
        return val;
    }
     
    //计算全排�?
	public static void calperm(List<ArrayList<Integer>> perm , ArrayList<Integer> list, int n){
		if(n == list.size()){
			perm.add(new ArrayList<Integer>(list));
		}else{
			for(int i=n;i<list.size();i++){
				Collections.swap(list, i, n);
				calperm(perm, list, n+1);
				Collections.swap(list, i, n);
			}
		}
	}
}