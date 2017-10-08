package jianzhiOffer;

public class N34_GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
    	if(index<=0){
    		return 0;
    	}
    	//���鱣�����,��һ����Ϊ1
    	int[] array = new int[index];
    	array[0] = 1;
    	
    	//��ʼ��3��ָ��
    	int two = 0;
    	int three = 0;
    	int five = 0;
    	
    	for(int i =1;i<index;i++){
    		array[i] = minAmongThree(array[two]*2,array[three]*3,array[five]*5);
    		//����ÿ��ָ�룬ֱ�����ǳ��Ը��Ե�ֵʱ��������ĩ�˵�ֵ
    		while(array[two]*2<=array[i]){
    			two++;
    		}
    		while(array[three]*3<=array[i]){
    			three++;
    		}
    		while(array[five]*5<=array[i]){
    			five++;
    		}
    	}

        return array[index-1];
    }
    
    private int minAmongThree(int i,int j,int k){
    	int a = i<j ? i : j;
    	return a<k ? a : k;
    }
    public static void main(String[] args){
    	N34_GetUglyNumber g = new N34_GetUglyNumber();
    	System.out.println(11^36);
    }
}
