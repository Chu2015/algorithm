package cc150;

public class LCA {
    public int getLCA(int a, int b) {
        while(a!=b){
        	if(a>b){
        		a = a/2;
        	}else{
        		b = b/2;
        	}
        }
        return a;
    }
}