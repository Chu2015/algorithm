package jianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class N33_PrintMinNumber {
	
    @SuppressWarnings("unchecked")
	public String PrintMinNumber(int [] numbers) {
//    	int length = numbers.length;
//    	char[][] aa = new char[length][];
//    	for(int i =0;i<length;i++){
//    		char[] c = String.valueOf(i).toCharArray();
//    		aa[i] = c;
//    	}
    	List<String> list = new ArrayList<String>();
    	for(int i : numbers){
    		list.add(String.valueOf(i));
    	}
    	
    	Comparator<String> com = new Com();
    	Collections.sort(list,com);
    	
    	StringBuilder result = new StringBuilder();
    	for(String s : list){
    		result.append(s);
    	}
    	
		return result.toString();
    	
		//return listToString(numbers);
    }

    
    class  Com implements Comparator<String>{
		public int compare(String o1, String o2) {
			String a = (String) o1;
			String b = (String) o2;
			
			String ab = a.concat(b);
			String ba = b.concat(a);
			
			for(int i=0;i<ab.length();i++){
				if(ab.charAt(i)<ba.charAt(i)){
					return -1;  //ab小于ab,a应该在前面，所以a比b小
				}else if(ab.charAt(i)>ba.charAt(i)){
					return 1;
				}
			}
			return 0;
		}
    }
    
//    public int chooseFromTwo(int[] nums,int i,int j){
//    	char[] a = String.valueOf(nums[i]).toCharArray();
//    	char[] b = String.valueOf(nums[j]).toCharArray();
//    	int alen = a.length;
//    	int blen = b.length;
//    	
//    	int min = 10;
//    	int index = 0;
//    	for(int k=0;k<alen || k<blen;k++){
//    		if(k>alen-1 && a[0]<=min+'0'){
//    			min = Integer.valueOf(String.valueOf(a[0]));
//    			index = i;
//    			
//    		}
//    		if(k>blen-1 && a[0]<=min+'0'){
//    			min = Integer.valueOf(String.valueOf(a[0]));
//    			index = i;
//    		}
//    		if(k<alen && k<blen){
//	        	if(a[k]<b[k]){
//	        		index = i;
//	        		break;
//	        	}else if(a[k]>b[k]){
//	        		index = j;
//	        		break;
//	        	}
//    		}
//    	}
//		return index;
//    }
//    
//    public int chooseTheLeftOne(char[][] caa,int index) {
//    	if(caa.length ==1){
//    		return String.valueOf(caa[0]);
//    	}
//    
//    	List<char[]> list2 = new ArrayList<char[]>();
//    	int min = 10;
//    	boolean quanbuyichu = true;
//    	
//    	
//    	for(char[] c : list){
//    		if(index>c.length-1){
//    			if(c[0]<=min+'0'){
//    				min = Integer.valueOf(String.valueOf(c[0]));
//        			list2.add(c);
//    			}
//    		}
//    		
//    		if(c[index]<=min+'0'){
//    			min = Integer.valueOf(String.valueOf(c[index]));
//    			list2.add(c);
//    			quanbuyichu = false;
//    		}
//    	}
//    	
//    	if(quanbuyichu){
//    		return String.valueOf(list.get(0));
//    	}
//    	
//		return chooseTheLeftOne(list2,index+1);
//    }
    
    
    public static void main(String[] args){
    	N33_PrintMinNumber p = new N33_PrintMinNumber();
    	int[] numbers = {5,32,3,321,44};
    	
    	System.out.println(p.PrintMinNumber(numbers));
    }
}
