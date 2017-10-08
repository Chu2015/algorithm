package cc150;

public class ReverseEqual {
    public boolean checkReverseEqual(String s1, String s2) {
        // write code here
    	int len1 = s1.length();
    	int len2 = s1.length();
    	if(len1!=len2) {return false;}
    	String temp = s1 + s1 ;
    	return temp.contains(s2);
    }
}
