package sort.bubble;

public class ImprovedBubbleSort {


	public static void sort(int[] a){
		boolean flag = false;//作为上一个循环是否有两个数交换的标志
		
		for(int j=a.length;j>0;j--){
			if(flag==false){
				return;
			}
			flag = false;
		 for(int i=0;i<j-1;i++){
			 if(a[i]>a[i+1]){
				 int b = a[i+1];
				 a[i+1] = a[i];
				 a[i] = b;
				 flag = true;
			 }
		   }
		}
	}
	
	public static void main(String arg[]){
		int[] c = {6,3,2,34,42,23,43,23,23,34,342,67,78};
		sort(c);
		for(int num : c){
			System.out.println(num+"_");
		}
	}
	
}
