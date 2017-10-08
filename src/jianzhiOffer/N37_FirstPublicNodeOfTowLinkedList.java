package jianzhiOffer;

import java.util.*;

public class N37_FirstPublicNodeOfTowLinkedList {
	//using hashMap
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	HashMap<ListNode,Integer> map = new HashMap<ListNode,Integer>();
    	while(pHead1!=null){
    		map.put(pHead1,0);
    		pHead1 = pHead1.next;
    	}
    	while(pHead2!=null){
    		if(map.containsKey(pHead2)){
    			return pHead2;
    		}
    		pHead2 = pHead2.next;
    	}	
		return null;	 
    }
    //not using extra space
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
    	int len1 = getLinkedListLength(pHead1);
    	int len2 = getLinkedListLength(pHead2);
    	if(len1>len2){
    		int dis = len1-len2;
    		while(dis-->0){
    			pHead1 = pHead1.next;
    		}
    	}else if(len2>len1){
    		int dis = len2-len1;
    		while(dis-->0){
    			pHead2 = pHead2.next;
    		}
    	}
    	while(pHead1!=null && pHead2!=null){
    		if(pHead1==pHead2){
    			return pHead1;
    		}
    		pHead1 = pHead1.next;
    		pHead2 = pHead2.next;
    	}
    	
		return null;	 
    }
    private int getLinkedListLength(ListNode pHead){
    	int length = 0;
    	while(pHead!=null){
    		length++;
    		pHead=pHead.next;
    	}
    	return length;
    }
}
