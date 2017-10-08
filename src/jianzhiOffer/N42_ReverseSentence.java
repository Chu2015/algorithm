package jianzhiOffer;

public class N42_ReverseSentence {
    public String ReverseSentence(String str) {
        if(str==null || str.length()==0){
        	return "";
        }
        char[] c = str.toCharArray();
    	Reverse(c,0,c.length-1);
    	
    	int i = 0;
    	int j = 0;
		for(j=0;j<str.length();j++){
    		if(c[j]==' '){
    			Reverse(c,i,j-1);
    			i=j+1;
    		}
    		if(j==str.length()-1){
    			Reverse(c,i,j-1);
    		}
		}
		Reverse(c,i,j-1);
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
		N42_ReverseSentence r = new N42_ReverseSentence();
		char[] c = {'j','o','k','e'};
		System.out.println(r.ReverseSentence("I am a student."));
	}

    
    
}
