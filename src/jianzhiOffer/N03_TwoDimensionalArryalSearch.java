package jianzhiOffer;

public class N03_TwoDimensionalArryalSearch {
	
    public boolean Find(int target, int [][] array) {
    	int k=0;
    	int len = array.length;
    	//�����½ǿ�ʼ
    	for(int i = len-1;i>=0;i--){
    		int len2 = array[i].length;
    		//从第k列开�?
    		for(int j = k ; j<len2 ; j++){
    			if(array[i][j] == target){		//�õ�Ŀ����
        			return true;
        		}else if(array[i][j] > target){ //����Ŀ������������һ�С�	
        			k = j;						//��ǵ�ǰ��������
        			break;
        		}						        //С��Ŀ����������һ��
    		}
    	}
		return false;
    }
}
