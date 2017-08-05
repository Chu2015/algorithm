import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.TreeMap;


public class Test<T> implements Serializable {
	int num = 0;
	
	public T method(){
		return null;
	}
	
	
//	public Object mothod(){
//		return null;
//	}
	
//	public Test method(){
//		
//	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


	public void QSort(int[] a,int lo,int hi){
		int[] abc = new int[6];
		try{
			int s = abc[9];
		}catch(Error e){
			System.out.println(e.getClass());
		}
		
		if(lo>=hi){
			return;
		}
		int index = partion(a,lo,hi);
		QSort(a,lo,index-1);
		QSort(a,index+1,hi);
		
	}
		
	public int partion(int[] a,int lo,int hi){
		int start = lo;
		int end = hi;
		int value = a[lo];
		while(start<end){
			while(a[start]<=value && start<hi){
				start ++;
			}
			while(a[end]>=value && end>lo){
				end --;
			}
			if(start<end){
				exchange(a,start,end);
			}
		}
		exchange(a,end,lo);
		return end;
	}
	
	private void exchange(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		num++;
	}
	
	public static void main(String[] args){
//		Test t = new Test();
//		int[] a = {5,3,3,2,1,6,9,8,7,4,10,15,14,16,19,20,25,21,22,24,23};
//		Node[] b = new Node[4];
//		t.QSort(a, 0, a.length-1);
//		for(int i:a){
//			System.out.println(i+",");
//		}
//		System.out.println(t.num+"½»»»´ÎÊý");
//		LinkedHashMap lm = new LinkedHashMap();
		
		TreeMap map = new TreeMap();
		map.put(3, "aa");
		map.put(2, "bb");
		map.put(66, "cc");		
		map.put(22, "dd");
		Iterator i = map.entrySet().iterator();
		Iterator i2 = map.keySet().iterator();
		
		while(i2.hasNext()){
			System.out.println(i2.next()+",");
		}
		
	}
	
}
class Node<T>{
	public Node(T data){
		this.data = data;
	}
	T data;
	Node<T> left,right;
}

class Testson extends Test<Integer>{

	@Override
	public Integer method() {
		// TODO Auto-generated method stub
		return super.method();
	}
}