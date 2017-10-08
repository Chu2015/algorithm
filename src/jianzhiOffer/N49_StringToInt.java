package jianzhiOffer;

public class N49_StringToInt {
    public int StrToInt(String str) {
    	if(str==null || str.length()==0){
    		return 0;
    	}
        char[] c = str.toCharArray();
        int result= 0;
        boolean pos = true;
        
        //检查是否有正负号
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
        	 //检查字符的合法性
        	 if(c[i]<'0' || c[i]>'9'){
         		return 0;
         	}else{
         		result = result*10 + c[i]-'0';
         	}
        }
        
        //设置正负号
        if(!pos){
        	result = - result;
        }
        return result;
    }
	public static void main(String[] args){
		N49_StringToInt s = new N49_StringToInt();
		System.out.println(s.StrToInt("123"));
	}
}
