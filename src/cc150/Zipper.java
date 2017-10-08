package cc150;

public class Zipper {
    public String zipString(String iniString) {
    	int num = 0;
    	int len = iniString.length();
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<len ;i++) {
    		int count = 1;
    		while(i+1<len && iniString.charAt(i)==iniString.charAt(i+1)) {
    			count++;
    			i++;
    		}
    		sb.append(iniString.charAt(i)+""+count);
//    		num++;
    	}
        return len > sb.length()? sb.toString(): iniString;
    }
    public static void main(String[] args) {
    	Zipper z = new Zipper();
    	System.out.println(z.zipString("jjjjjjxxxxxxxoo"));
	}
}
