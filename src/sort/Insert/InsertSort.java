   package sort.Insert;

public class InsertSort {

	public static void sort(int[] a){
		if(a==null || a.length==0){
			return;
		}
		for(int i=1;i<a.length;i++){
			int key = a[i];
			int j;
			for( j=i-1;j>=0 && a[j]>key;j--){	//ע��j>=0���Ҫд�� a[j]>key����ǰ�棬����������ı߽���������Խ��Ĵ���
				a[j+1] = a[j];
			}
			a[j+1] = key;
		}
	}
	
	public static void sort(int[] a,int lo,int hi){

	}
	
	public static void main(String[] args){
		int[] c = {6,3,2,34,42,23,43,23,23,34,342,67,78};
		sort(c);
		for(int num : c){
			System.out.println(num+"_");
		}
	}
}
