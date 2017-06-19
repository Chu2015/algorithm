package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
    	if(matrix==null || matrix.length==0){
    		return null;
    	}
    	
    	ArrayList<Integer> list= new ArrayList<Integer>();
    	
    	int len  = matrix.length;
    	int len2 = matrix[0].length;
    	
    	int istart=0,jstart=0;
    	int i=istart,j=istart;
    	
    	while(len>istart && len2>jstart){
	    	for(j=istart;j<len2;j++){
	    		list.add(matrix[i][j]);
	    	}
	    	j--;

	    	for(i=istart+1;i<len;i++){
	    		list.add(matrix[i][j]);
	    	}
	    	i--;
	    	
	    	//if there is only one row
	    	if(len-1>istart){
		    	for(j=len2-2;j>=jstart;j--){
		    		list.add(matrix[i][j]);
		    	}
		    	j++;
    		}
	    	//if there is only one column
	    	if(len2-1>jstart){
		    	for(i=len-2;i>istart;i--){
		    		list.add(matrix[i][j]);
		    	}
		    	i++;
	    	}
	    	istart++;
	    	jstart++;
	    	len--;
	    	len2--;
    	}
		return list;
    }
    public static void main(String[] args){
    	
    	PrintMatrix pm = new PrintMatrix();
    	int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    	List<Integer> list = pm.printMatrix(matrix);
    	for(int i:list){
    		System.out.println(i);
    	}
    }
    
}
