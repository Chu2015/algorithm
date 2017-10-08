package cc150;

public class SubMatrix {
	
    public int sumOfSubMatrix(int[][] mat, int n) {
        int Max = Integer.MIN_VALUE;
    	//int[] temp = null;
    	//�Զ�ά����ÿһ�б���
    	for(int i=0;i<n;i++) {
    		int[] temp = mat[i];
    		//���е���������������
    		Max = Math.max(Max, maxSumofArray(temp));
    		//�������������ÿһ��
    		for(int j=i+1;j<n;j++) {
    			//������j�е�ÿһ�������ۼӵ���i�е�����temp��
    			for(int k=0;k<n;k++) {
    				temp[k] += mat[j][k];
    				//�����ۼӺ���������������ͣ����Ա���ÿһ���Ӿ���
    			}
    			Max = Math.max(Max, maxSumofArray(temp));
    		}
    	}
    	return Max;
    }
    
    public int maxSumofArray(int[] a) {
    	int max = Integer.MIN_VALUE;
        int sum = a[0];
    	for(int i=1;i<a.length;i++) {
    		if(sum > 0) {
    			sum = sum + a[i];
    		}else {
    			sum = a[i];
    		}
    		max = max>sum ? max : sum;
    	}
    	return max;	
    }
    
    public static void main(String[] args) {
    	SubMatrix s = new SubMatrix();
    	int[][] mat = new int[][] {{-1,1},{-2,24}};
    	System.out.println(s.sumOfSubMatrix(mat, 2));
	}
}
