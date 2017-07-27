package jianzhiOffer;

public class StringToInt {
    public int StrToInt(String str) {
    	if(str==null || str.length()==0){
    		return 0;
    	}
        char[] c = str.toCharArray();
        int result= 0;
        boolean pos = true;
        
    	if(c[0]=='+'){
    		pos = true;
    	}else if(c[0]=='-'){
    		pos = false;
    	}else if(c[0]<'0' || c[0]>'9'){
    		return 0;
    	}else{
    		result = c[0]-'0';
    	}
    	
        for(int i=1;i<c.length;i++){
        	 if(c[i]<'0' || c[i]>'9'){
         		return 0;
         	}else{
         		result = result*10 + c[i]-'0';
         	}
        }
        
        if(!pos){
        	result = - result;
        }
        return result;
    }
	public static void main(String[] args){
		StringToInt s = new StringToInt();
		System.out.println(s.StrToInt("123"));
	}
}
