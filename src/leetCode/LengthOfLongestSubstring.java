package leetCode;

import java.util.HashMap;

//用hashMap可以使得时间复杂度为O(n),使用的时候注意双指针的move,以及map的更新

public class LengthOfLongestSubstring {
	//time: O(n^2)(max) ; Space: O(1)
    public int lengthOfLongestSubstring(String s) {
    	
    	int len = s.length();
    	if(s==null || len==0){
    		return 0;
    	}
    	if(len==1){
    		return 1;
    	}
    	
    	char[] chars = s.toCharArray();
    	
    	int[] dp = new int[len];
    	dp[0] = 1;
    	
    	int result = Integer.MIN_VALUE;
    	for(int i=1;i<len;i++){
    		int count = dp[i-1];
    		while(count>0){
    			if(chars[i]==chars[i-count]){
    				dp[i] = count;
    				break;
    			}
    			count--;
    		}
    		if(count==0){
    			dp[i] = dp[i-1]+1;
    		}
    		result = result > dp[i] ? result : dp[i];
    	}
    	
		return result;
    }
    
    //time: O(n),space: O(n)(equals to the number of unique characters)
    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        //i is right pointer,move i to scan through the String, and update the hashmap
        for (int i=0, j=0; i<s.length(); ++i){
        	//If the character is already in the hashmap, then move the left pointer to the right of the same character last found
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            //update the hashmap(Key: character, value: position)
            map.put(s.charAt(i),i);
            //i-j+1 is the LongestSubstring ended by chars[i];
            max = Math.max(max,i-j+1);
        }
        return max;
    }
    
    public static void main(String[] args) {
    	LengthOfLongestSubstring l = new LengthOfLongestSubstring();
    	System.out.println(l.lengthOfLongestSubstring("ab"));
	}
}
