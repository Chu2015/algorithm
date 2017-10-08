package jianzhiOffer;

import java.util.HashMap;
import java.util.Map.Entry;

public class N43_PrintProbobility {

	public final static int MAXDIANSHU= 6;
	
	//ʹ�õݹ飬���Ӷȣ�6^n
	public HashMap<Integer,Integer> result = new HashMap<Integer,Integer>();
	public void printProbobility(int num){
		for(int i=num;i<=6*num;i++){
			result.put(i, 0);
		}
		printProbobility(num,0);
	}
	
	public void printProbobility(int num,int sum){
		if(num==1){
			for(int i=1;i<7;i++){
				result.put(sum+i, result.get(sum+i)+1);
			}
		}else{
			for(int i=1;i<7;i++){
				printProbobility(num-1,i+sum);
			}	
		}
	}
	
	//�����õݹ飬���Ӷ�n^3
	public void printProbobility2(int num){
		int[] oldresult = new int[6*num+1];
		int[] newresult = new int[6*num+1];
		
		for(int i=1;i<=6;i++){
			oldresult[i] = 1;
		}
		
		for(int i = 2;i<=num;i++){ //������ѭ��
			for(int j=i;j<=6*i;j++){ //�Ե�ǰ�����ӳ��ֵĵ�����ѭ��
				for(int k=j-1;k>=Math.max(0, j-6);k--){ //ѭ�����
					if(oldresult!=null){
						newresult[j] += oldresult[k];
					}
				}
			}
			oldresult = newresult;
			newresult = new int[6*num+1];
		}
		
		for(int i:oldresult){
			System.out.println(i+" ");
		}
	}
	
	public static void main(String[] args){
		N43_PrintProbobility p = new N43_PrintProbobility();
		p.printProbobility(3);
		for(Entry<Integer,Integer> entry : p.result.entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	
}
