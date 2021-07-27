package dynamicProgramming;

import java.util.HashMap;
import java.util.List;

public class WordsBreak2 {
	 public List<String> wordBreak(String s, List<String> wordDict) {
		    HashMap<Integer,String> hm = new HashMap<Integer,String>();
		    
	        if (wordDict.size()==0||s.length()==0) {
	            return null;
	              
	        }
	        List<String> resultList=null;
	        int len = s.length();
	        Boolean[] dp = new Boolean[len+1];
	        dp[0] = true;
	        //��¼��XX��β���ַ����Ƿ�ɷ֣���̬�滮
	        for (int i = 1; i < s.length()+1; i++) {
	            for (int j = i-1; j >= 0; j--) {
	            	String w = s.substring(j,i);
	                if (dp[j]&&wordDict.contains(w)) {
	                	String ss = hm.get(j);
	                	
	                	hm.put(i, ss+" "+w);
	                    dp[i] = true;
	                    break;
	                }else {
	                    dp[i] = false;
	                }
	            }
	        }
	        return null;
	    }
}
