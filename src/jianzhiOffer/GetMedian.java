package jianzhiOffer;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ArrayList;
public class GetMedian {

	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {

		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	});
	
    public void Insert(Integer num) {
    	if(maxHeap.isEmpty()){
    		maxHeap.add(num);
    		return;
    	}
    	//如果现有元素个数为偶数
    	if(((minHeap.size()+maxHeap.size()) & 1)==0){
			if(num>minHeap.peek()){
				maxHeap.add(minHeap.poll());
				minHeap.add(num);
			}else{
				maxHeap.add(num);
			}
		}
    	//如果现有元素个数为奇数
    	else{
			if(num>maxHeap.peek()){
				minHeap.add(num);
			}else{
				minHeap.add(maxHeap.poll());
				maxHeap.add(num);
			}
		}
    }

    public Double GetMedian() {
    	if(minHeap.isEmpty()){
    		if(maxHeap.isEmpty()){
    			return null;
    		}else{
    			return maxHeap.peek()*1.0;
    		}	
    	}
		if(((minHeap.size()+maxHeap.size()) & 1)==0){
			return (minHeap.peek()+maxHeap.peek())/2.0;
		}else{
			return maxHeap.peek()*1.0;
		}
    }
//	ArrayList<Integer> list  = new ArrayList<Integer>();
//	LinkedList<Integer> list2  = new LinkedList<Integer>();
//    public void Insert(Integer num) {
//    	int size = list.size();
//    	if(num>list.get(size/2+1)){
//    		list2.add(0, element);
//    	}
//    	
//    }
//
//    public Double GetMedian() {
//    	int size = list.size();
//    	if((size & 1) ==0){
//    		return (list.get(size/2)+list.get(size/2-1))/2.0;
//    	}else{
//    		return list.get(size/2)*1.0;
//    	}
//    }
}
