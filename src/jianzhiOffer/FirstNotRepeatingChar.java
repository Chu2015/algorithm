package jianzhiOffer;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FirstNotRepeatingChar {
	 public int FirstNotRepeatingChar(String str) {
		 if(str==null || str.length()==0){
			 return -1;
		 }
		 HashMap<Character,Integer> repeat = new HashMap<Character,Integer>();
		 HashMap<Character,Integer> notrepeat = new HashMap<Character,Integer>();
//		 Character[] result = new Character[str.length()];
		 
		 for(int i=0;i<str.length();i++){
			 char c = str.charAt(i);
			 if(repeat.containsKey(c)){
				 continue;
			 }else {
				 if(notrepeat.containsKey(c)){
					 int index = notrepeat.get(c);
//					 result[index]=result[index+1]==null ? null :result[index+1];
					 notrepeat.remove(c);
					 repeat.put(c, i);
				 }else{
					 notrepeat.put(c, i);
//					 result[i] = c;
				 }
			 }
		 }
		 Collection<Integer> list = notrepeat.values();
		 int result = str.length()+1;
		 for(int i : list){
			 if(i<result){
				 result = i;
			 }
		 }
		 return result;
	 }
	 
    public static void main(String[] args){
    	FirstNotRepeatingChar f = new FirstNotRepeatingChar();
    	int[] a = {1,-2,3,10,-4,7,2,-5};
    	System.out.println(f.FirstNotRepeatingChar("arrdfbaccdeff"));
    }
}
