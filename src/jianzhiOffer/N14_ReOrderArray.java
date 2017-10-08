package jianzhiOffer;

public class N14_ReOrderArray {
	public void reOrderArray(int [] array,Judge judge) {
        if(array==null || array.length==0){
        	return;
        }
        int lo = 0;
        int hi = array.length-1;
        while(lo<hi){
        	while(judge.isleft(array[lo]) && lo<=hi){
        		lo++;
        	}
        	while(!judge.isleft(array[hi]) && hi>=0){
        		hi--;
        	}
        	if(lo<hi){
            	exchange(array,lo,hi);
        	}
        }
    }
	
	public void exchange(int[] array,int lo,int hi){
		int temp = array[lo];
		array[lo] = array[hi];
		array[hi] = temp;
	}
	
	public static void main(String[] args){
		N14_ReOrderArray r = new N14_ReOrderArray();
		int[] array = {1,2,3,4,4,5,7,8,8};
		r.reOrderArray(array, new Judge(){

			public boolean isleft(int n) {
				if((n & 1)==1){
					return true;
				}
				return false;
			}
			
		});
		for(int i:array){
			System.out.println(i+",");
		}

	}
}

interface Judge{
	public boolean isleft(int n);
}