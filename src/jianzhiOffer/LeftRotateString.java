package jianzhiOffer;

public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(str==null || str.length()==0){
        	return "";
        }
        n = n%str.length();
        char[] c = str.toCharArray();
        Reverse(c, 0, str.length()-1);
        Reverse(c, 0, str.length()-n-1);
        Reverse(c, str.length()-n, str.length()-1);
        return new String(c);
    }
    
    public void Reverse(char[] c, int lo, int hi) {
    	while(lo<hi){
    		char temp = c[hi];
    		c[hi] = c[lo];
    		c[lo] = temp;
    		lo++;
    		hi--;
    	}
	}
    
	public static void main(String args[]){
		LeftRotateString l = new LeftRotateString();
		char[] c = {'j','o','k','e'};
		System.out.println(l.LeftRotateString("abcdefg", 2));
	}
}
