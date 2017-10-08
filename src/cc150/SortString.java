package cc150;

import java.util.*;

public class SortString {
    public ArrayList<String> sortStrings(String[] str, int n) {
        // write code here
    	HashMap<String,String> map = new HashMap<String,String>();
    	ArrayList<String> result = new ArrayList<String>();
    	for(int i=0;i<n;i++){
    		String s1 = str[i];
    		String key = reorder(s1);
    		if(map.containsKey(key)){
    			String s = map.get(key);
    			if(s1.compareTo(s)<0){
    				map.put(key, s1);
    			}
    			continue;
    		}else{
    			map.put(key, s1);
    		}
    	}
    	Iterator<String> iter = map.keySet().iterator();
    	while(iter.hasNext()){
    		String key = iter.next();
    		result.add(map.get(key));
    	}
    	Collections.sort(result);
    	return result;
    }
    public String reorder(String str){
    	char[] sChar = str.toCharArray();
    	Arrays.sort(sChar);
        return new String(sChar);
    }
}

