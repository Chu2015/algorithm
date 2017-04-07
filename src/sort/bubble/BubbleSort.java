package sort.bubble;

public class BubbleSort {

		public static void sort(int[] a){
			
			for(int j=a.length;j>0;j--){
			 for(int i=0;i<j-1;i++){
				 if(a[i]>a[i+1]){
					 int b = a[i+1];
					 a[i+1] = a[i];
					 a[i] = b;
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
