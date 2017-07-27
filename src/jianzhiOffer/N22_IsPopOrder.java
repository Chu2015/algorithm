package jianzhiOffer;

import java.util.HashMap;
import java.util.Stack;

public class N22_IsPopOrder {
	
	//worst complexity O(N^2)
    public boolean IsPopOrder2(int [] pushA,int [] popA) {
    	if(pushA==null || popA==null || pushA.length!=popA.length){
    		return false;
    	}
    	
    	HashMap<Integer,Integer> map = new HashMap();
    	int [] popB = new int[popA.length];
    	for(int i=0;i<pushA.length;i++){
    		map.put(pushA[i], i+1);
    	}
    	for(int i=0;i<popA.length;i++){
    		if(map.get(popA[i])==null){
    			return false;
    		}
    		popB[i] = map.get(popA[i]);
    	}
    	
    	for(int i=0;i<popB.length;i++){
    		int mark = popB[i];
    		for(int j=i+1;j<popB.length;j++){
        		if(popB[j]>popB[i]){//�����ҿ���
        			continue;
        		}
    			if(popB[j]>mark){//С���ҵ��Ǵ���mark����
    				return false;
    			}else{
        			mark = popB[j];//�����markС����Ϊ�µ�mark
    			}
        	}
    	}

		return true;
    }
    
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	if(pushA==null || popA==null || pushA.length!=popA.length){
    		return false;
    	}
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> stackhelper = new Stack<Integer>();
    	
    	for(int i=pushA.length-1;i>=0;i--){
    		stackhelper.push(pushA[i]);
    	}
    	
    	for(int i=0;i<popA.length;i++){
    		int value = popA[i];
    		//�����ǰջ���������ֵ����ô���ֵ��û��ѹ��
    		if(stack.isEmpty() || stack.peek()!=value){
    			if(stackhelper.isEmpty()){
    				return false;
    			}
    			Integer popvalue = stackhelper.pop();
    			while(popvalue!=value){
    				stack.push(popvalue);
    				if(stackhelper.isEmpty()){
        				return false;
        			}
    				popvalue = stackhelper.pop();
    			}

    			continue;

    		}else{
    			stack.pop();
    		}
    	}
    	
		return true;
    }
    
    public static void main(String args[]){
    	N22_IsPopOrder n = new N22_IsPopOrder();
    	int[] a = {1,2,3,4,5};
    	int[] b = {4,5,3,2,1};
    	System.out.println(n.IsPopOrder(a, b));
    }
}
