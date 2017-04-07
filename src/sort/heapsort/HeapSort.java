package sort.heapsort;

public class HeapSort {
	
	
	private static void sink(int[] a,int key,int end){
		while(key*2<=end){
			int child =key*2;
			if (child+1<=end && a[child+1]>a[child]) child++;
			if(a[child]<=a[key]) break;
			swap(a,key,child);
			key = child;
		}
	}
	
	private static void swap(int[] a,int b,int c){
		int temp = a[b];
	    a[b] = a[c];
	    a[c] = temp;
	}
	
	public static void sort(int[] a){
		int N = a.length-1;
		//������ת��Ϊ�����
		for(int i= N/2;i>=1;i--){
			sink(a,i,N);
		}
		//����������ֵ����������һ�����ֽ���λ�ã�Ȼ��ԶѶ�����sink������ʹ��������ಿ������һ�������
		while(N>1){
			swap(a,1,N);
			sink(a,1,--N);
		}
		
	}
	
	public static void main(String arg[]){
		int[] c = {999,3,2,34,42,23,43,23,23,34,342,67,78};
		sort(c);
		for(int num : c){
			System.out.println(num+"_");
		}
	}
	
}
