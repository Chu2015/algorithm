package jianzhiOffer;

import java.util.ArrayList;

public class N41_FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	ArrayList<ArrayList<Integer> > list  = new ArrayList<ArrayList<Integer> >();
    	if(sum<=2){
    		return list;
    	}
    	int i=1;
    	int j=2;
    	int add =3;
    	while(j<=(sum/2+1)){
    		if(add<sum){
    			j++;
    			add = add+j;
    		}else if(add>sum){
    			add -= i;
    			i++;
    		}else{
    			ArrayList<Integer> l = new ArrayList<Integer>();
    			for(int k = i;k<=j;k++){
    				l.add(k);
    			}
    			list.add(l);
    			
    			j++;
    			add = add + j- i;
    			i++;
    		}  		
    	}
    	return list;
    }
}
