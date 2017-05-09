package jianzhiOffer;

public class ReplaceSpace {
	
    public static String replaceSpace(StringBuffer str) {
    	String aa = new String(str);
    	aa.replaceAll("\\s", "%20");
		return aa;
    }
    
    public static void main(String[] args){
  
    	System.out.println(replaceSpace(new StringBuffer("aa  bb  ccf")));
    }
}
