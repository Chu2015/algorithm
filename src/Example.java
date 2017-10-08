import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Example {
	
    public static void main(String[] args) throws IOException {

    	Scanner in=new Scanner(System.in);
    	String str=in.nextLine(); 
    	String sub[]=str.split(" "); 
    	int len=sub.length; 
    	
    	int []a=new int[len]; 
    	for(int i =0;i<len;i++){ 
    		a[i]=Integer.parseInt(sub[i]); 
    	}
    	
    	for(int i=0;i<a.length;i++) {
    		System.out.println(a[i]);
    	}
        
    }
}