package jianzhiOffer;

//�ڲ��������������£��滻�ո�
public class N04_ReplaceSpace {
	
    public static String replaceSpace(StringBuffer str) {
    	if(str == null){
    		return null;
    	}
    	int len = str.length();
    	int count = 0;
    	char space = ' ';
    	
    	//�����ַ���������ո������Ӷ�ȷ��
    	for(int i = 0; i<len ;i++){
    		if( space == str.charAt(i)){
    			count ++;
    		}
    	}
    	
    	int newlen = len + count*2;
    	str.setLength(newlen); //��ʵ���Ǹ���������
    	
    	int i ;
    	int j = newlen-1;
    	for(i = len-1 ; i>=0 ; i--){
    		char c = str.charAt(i);
    		if(!(c == ' ')){
    			str.setCharAt(j, c);
    			j--;
    		}else{
    			str.setCharAt(j--, '0');
    			str.setCharAt(j--, '2');
    			str.setCharAt(j--, '%');
    		}
    	}
    	

		return new String(str);
    }
    public String replaceSpace(String iniString, int length) {
        if(iniString == null){
    		return null;
    	}
    	StringBuffer str = new StringBuffer(iniString);

    	int len = str.length();
    	int count = 0;
    	char space = ' ';
    	
    	//�����ַ���������ո������Ӷ�ȷ��
    	for(int i = 0; i<len ;i++){
    		if( space == str.charAt(i)){
    			count ++;
    		}
    	}
    	
    	int newlen = len + count*2;
    
    	str.setLength(newlen); //��ʵ���Ǹ���������
    	
    	int i ;
    	int j = newlen-1;
    	for(i = len-1 ; i>=0 ; i--){
    		char c = str.charAt(i);
    		if(!(c == ' ')){
    			str.setCharAt(j, c);
    			j--;
    		}else{
    			str.setCharAt(j--, '0');
    			str.setCharAt(j--, '2');
    			str.setCharAt(j--, '%');
    		}
    	}
    	

		return new String(str);
    }
    public static void main(String[] args){
    	System.out.println(replaceSpace(new StringBuffer("aa bb ccf")));
    }
}
