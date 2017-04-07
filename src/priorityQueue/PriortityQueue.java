package priorityQueue;

//基于堆的优先队列
public class PriortityQueue<Key extends Comparable<Key>> {
	
	private Key[] pq ;
	
	private int N = 0;
	
	public PriortityQueue(int maxN){
		pq = (Key[]) new Comparable[maxN+1];
	}
	
	public Key deleteMax(){
		Key max = pq[1];
		pq[1] = pq[N--];
		pq[N] = null; //防止对象游离
		sink(1);
		return max;
	}
	
	public void insert(Key a){
		N++;
		pq[N] = a;
		swim2(N);
	}
	
	private void swim(int i){
		if(i>N || i/2<1){
			return;
		}
		int parent = i/2;
		if(pq[parent].compareTo(pq[i])<0){
			swap(i,parent);
			 swim2(parent);	//递归
		}	
	}
	

	
	private void swim2(int i){
		while(i/2>=1 && pq[i/2].compareTo(pq[i])<0){
				swap(i,i/2);
				i/=2;
		}
	}
	
	private void sink(int i){
		if(2*i>N || i<1){
			return;
		}
		int child = i*2;
		if(pq[child+1].compareTo(pq[child])>0){
			child++;
		}
	    if(pq[child].compareTo(pq[i])>0){
			swap(i,child);
			sink(child);
		}
	}
	
	private void sink2(int i){
		while(i*2<=N){
			int child = i*2;
			if(pq[child+1].compareTo(pq[child])>0){
				child++;
			}
			if(pq[child].compareTo(pq[i])<=0){
					break;
			}
			swap(child,i);
			i = child;
		}
	}
	private void swap(int i, int k){
		Key temp = pq[i]; pq[i]= pq[k];pq[k] = temp;
	}
	
	public static void main(String[] args){
		PriortityQueue<Integer> pq = new PriortityQueue<Integer>(20);
		pq.insert(1);
		pq.insert(4);
		pq.insert(99);
		pq.insert(43);
		pq.insert(33);
		pq.insert(4);
		pq.insert(20);
		pq.insert(33);
		
		System.out.println(pq.deleteMax());
	}
}
