package cc150;

import java.util.ArrayList;

public class Stack {
    public int getHeight(int[] men, int n) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(men[0]);
    	for(int i=1;i<n;i++){
    		int height = men[i];
    		makeL1ist(list,height);
    		
    	}
		return list.size();
    }

	private void makeL1ist(ArrayList<Integer> list, int height) {
		int size = list.size();
		int lo = 0;
		int hi = size-1;
		while(lo<hi){
			int mid = (lo+hi)/2;
			if(list.get(mid)<height){
				lo = mid+1;
			}else if(list.get(mid)>height){
				hi = mid;
			}else{
				return;
			}
		}
		if(list.get(lo)>height){
			list.remove(lo);
			list.add(lo,height);
		}else{
			list.add(size,height);
		}
		
	}
	public static void main(String[] args) {
		Stack s =new Stack();
		System.out.println(s.getHeight(new int[]{1,6,2,5,3,4},6));
	}
    
}
