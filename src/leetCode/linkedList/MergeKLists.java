package leetCode.linkedList;

import java.util.Arrays;

public class MergeKLists {
//	public ListNode mergeKLists(ListNode[] lists) {
//
//        ListNode minNode = new ListNode(0);
//        int length = lists.length;
//        if(length == 1){
//            return lists[0];
//        }
//        int a = 0;
//        for(int i = 0; i < length ; i++){
//            if(lists[i].val < minNode.val){
//            	a = i;
//                minNode = lists[i];
//            }
//        }
//        if(lists[a].next != null){
//        	lists[a] = lists[a].next;
//        }else{
//        	lists[a] = null;
//        }
//        minNode = mergeKLists(lists);
//        
//        return minNode;
//    }
	private ListNode[] queue;
	int N = 0;
	public ListNode mergeKLists(ListNode[] lists) {
		queue = new ListNode[lists.length];
		
		if(lists.length==0){
			return null;
		}
		if(lists.length==1){
			return lists[0];
		}
		ListNode mergedList = new ListNode(0);
		ListNode tail = mergedList;

		//µÃµ½¶þ²æ¶Ñ
		for(int i=0;i<lists.length;i++){
			if(lists[i] != null){
				insert(lists[i]);
			}
		}

		while(N>0 ){
			tail.next = queue[0];
			tail = tail.next;
			queue[0] = queue[0].next;
			if(queue[0] == null){
				queue[0] = queue[N-1]; 
				sink(0);
				N--;
			}else{

				sink(0);
			}
		}

		return mergedList.next;
	}
	
	public void insert(ListNode a){
		if(a == null){
			return;
		}
		queue[N] = a;
		swim(N);
		N++;
	}
	private void swim(int i){
		while(i>=1 && queue[(i-1)/2].val >= queue[i].val){
			swap(i,(i-1)/2);
			i= (i-1)/2;
		}
	}
	private void sink(int i){
		while(i*2+1<=N-1){
			int child =i*2+1;
			if (child+1<=N-1 && queue[child+1].val<queue[child].val) child++;
			if(queue[child].val>=queue[i].val) break;
			swap(i,child);
			i = child;
		}
	}
	private void swap(int i, int k){
		ListNode temp = queue[i]; queue[i]= queue[k];queue[k] = temp;
	}
	
	public static void main(String[] args){
		MergeKLists mkl = new MergeKLists();
		ListNode[] ln = new ListNode[6];
		ln[0] = new ListNode(9);
		ln[1] = new ListNode(199);
		ln[2] = new ListNode(1);
		ln[3] = new ListNode(34);
		ln[4] = new ListNode(44);
		ln[5] = new ListNode(21);
		
		ListNode result = mkl.mergeKLists(ln);
		while(result.next != null){
			System.out.println(result.val + ",");
			result = result.next;
		}
	
	}
		

}
