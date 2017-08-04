package dynamicProgramming;

import java.util.Scanner;

public class YuanDian{
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int rSquare = in.nextInt();
        int count =0;
        double r = Math.sqrt(rSquare);
        int result = 0;
        
        for(int i=0;i<r;i++){
//            for(int j=0;j<=r;j++){
//            	if((i*i+j*j)==rSquare){
//            		if(i==0 || j==0){
//            			result += 2;
//            		}else{
//            			result += 4;
//            		}
//            	}
//            }
 
            double j = Math.sqrt(rSquare-i*i);
            if((int) j==j){
            	count++;
            }
        }
        
       System.out.println(count<<2);
   }
}