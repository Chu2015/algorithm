package jianzhiOffer;

public class N40_FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
    	if(array==null || array.length==0){
    		return;
    	}
    	int j = 0;
        for(int i=0 ; i<array.length; i++){
        	j ^= array[i];
        }
        
        //���ұ��������ұ�Ϊ1
        int position = FindBit1(j);
        
        num1[0] = 0;
        num2[0] = 0;
        
        for(int i=0 ; i<array.length; i++){
        	if(isBit1(array[i], position)){
        		num1[0] ^= array[i];
        	}else{
        		num2[0] ^= array[i];
        	}
        }
    	
    }
    
    public int FindBit1(int k){
    	int i = 1;
    	while((k & 1)!=1){
    		k = k >> 1;
        	i++;
    	}
    	return i;
    }
    
    public boolean isBit1(int k,int position){
		k = k>>(position-1);
		if((k & 1 )==1){
			return true;
		}
		return false;
    }
    
    public static void main(String[] args){
    	N40_FindNumsAppearOnce f = new N40_FindNumsAppearOnce();
    	System.out.println(f.isBit1(10, 4));
    }
}
