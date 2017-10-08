package cc150;

import java.util.*;

public class SetOfStacks {
	public int size;
    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        // write code here
    	this.size = size;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = ope.length;
        int count = 0;
        for(int i=0;i<len;i++){
        	if(ope[i][0]==1) {
        		count++;
        		push(result,ope[i][1],count);
        	}else if(ope[i][0]==2) {
        		//pop(result,count);
        		count--;
        	}
        }
        return result;
    }

	private void pop(ArrayList<ArrayList<Integer>> result,int count) {
		int n = count/size+ (count%size==0 ? 0:1);
		ArrayList<Integer> a = result.get(n-1);
		
	}

	private void push(ArrayList<ArrayList<Integer>> result, int i,int count) {
		int n = count/size+ (count%size==0 ? 0:1);
		ArrayList<Integer> a = result.get(n-1);
		if(a==null) {
			a = new ArrayList<Integer>(size);
		}
		a.add(size-count-1,i);
		result.add(n-1,a);
	}
}