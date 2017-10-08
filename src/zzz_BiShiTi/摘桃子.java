package zzz_BiShiTi;

import java.util.*;
public class ժ���� {
/** ������������������ʵ����ĿҪ��Ĺ��� **/
/** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^  **/
    static int pick(int[] peaches) {
    	int len = peaches.length;
        int[] dp = new int[len];
        
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        
        int result = 1;
        for (int i = 1; i < len; i++) {
        	for(int j=0;j<i;j++) {
        		if(peaches[i]>=peaches[j]) {
        			dp[i] = dp[i] > dp[j]+1 ? dp[i] : dp[j]+1;
        		}
        	}
        	result = result> dp[i]?result:dp[i];
        }
        
        return result;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int trees = Integer.parseInt(in.nextLine().trim());
        int[] peaches = new int[trees];
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(pick(peaches));
    }
}