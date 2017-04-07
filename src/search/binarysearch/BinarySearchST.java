package search.binarysearch;

public class BinarySearchST<Key extends Comparable<Key>,Value>{
	private Key[] keys;
	private Value[] values;
	private int N;
	public BinarySearchST(int capacity){
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Comparable[capacity];
	}
	
	public int size(){
		return N;
	}
	
	//���ķ��������û����ͬ��key���򷵻�keyӦ�ò����λ�ã��������ͬ��key���򷵻ص�ǰ��key��λ��
	public int rank(Key key){
		int lo = 0;
		int hi = N-1;
		while(lo<=hi){
			int mid = (lo+hi)/2;
			if(key.compareTo(keys[mid])>0){
				lo = mid+1;
			}
			else if(key.compareTo(keys[mid])<0){
				hi = mid-1;
			}else{
				return mid;
			}
		}
		return lo;
	}
	
	public void put(Key key,Value value){
		int r = rank(key);
		//���ű�������ͬ��key
		if(r<N && key.compareTo(keys[r])==0 ){
			values[r] = value;
			return;
		}
		//���ű���û����ͬ��key,���ƶ��ٲ���
		for(int i = N;i>=r;i--){  
			keys[i+1]=keys[i];
			values[i+1]=values[i];
		}
		keys[r] = key; 
		values[r] = value;
	}
	
	public Value get(Key key){
		if(isEmpty()){
			return null;
		}
		int r = rank(key);
		if(r<N && key.compareTo(keys[r])==0 ){
			return values[r]; 
		}
		return null;
	}
	
	public boolean isEmpty(){
		if(N>0){
			return true;
		}
		else return false;
	}
	
}
