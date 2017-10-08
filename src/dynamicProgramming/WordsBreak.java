package dynamicProgramming;

import java.util.*;
public class WordsBreak {
   //网上的答案，动态规划问题
   public boolean wordBreak(String s, List<String> dict) {
        if (dict.size()==0||s.length()==0) {
            return false;
              
        }
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        //记录以XX结尾的字符串是否可分，动态规划
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (dp[j]&&dict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
   
   public static void main(String[] args) {
	   WordsBreak wb = new WordsBreak();
	   List<String> dict = new ArrayList<String>();
	   dict.add("leet");
	   dict.add("code");
	   System.out.println(wb.wordBreak("leetcode", dict));
	   
   }
}