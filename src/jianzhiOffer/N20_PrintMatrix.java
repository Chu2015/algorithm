package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

public class N20_PrintMatrix {
	public final int o = 9;
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
	    	
	    	//if there is more than one row
	    	if(len-1>istart){
		    	for(j=len2-2;j>=jstart;j--){
		    		list.add(matrix[i][j]);
		    	}
		    	j++;
    		}
	    	//if there is more than one column
	    	if(len2-1>jstart){
		    	for(i=len-2;i>istart;i--){
		    		list.add(matrix[i][j]);
		    	}
		    	i++;
	    	}
	    	istart++;
	    	jstart++;
	    	//len 和 len2 指的是最大的索引
	    	len--;
	    	len2--;
    	}
		return list;
    }
    public static void main(String[] args){
    	
    	N20_PrintMatrix pm = new N20_PrintMatrix();
    	int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    	List<Integer> list = pm.printMatrix(matrix);
    	for(int i:list){
    		System.out.println(i);
    	}
    }
    
}
