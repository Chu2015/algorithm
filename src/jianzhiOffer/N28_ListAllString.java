package jianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;

public class N28_ListAllString {
	//wrong
//    public ArrayList<String> Permutation(String str) {
//    	if(str==null || str.length()==0){
//    		return null;
//    	}
//    	ArrayList<String> list = new ArrayList<String>();
//    	char[] newc = str.toCharArray();
//    	
//    	list.add(String.valueOf(newc));
//    	for(int i=0;i<newc.length;i++){
//    		for(int j=i+1;j<newc.length;j++){
//        		if(newc[j]!=newc[i]){
//        			exc(newc,i,j);
//        			list.add(String.valueOf(newc));
//        		}
//        		newc = str.toCharArray();
//    		}
//    	}
//    	
//		return list;
//        
//    }
    
    private ArrayList<String> Permutation(String str){
    	if(str==null || str.length()==0){
    		return null;
    	}
    	ArrayList<String> list = new ArrayList<String>();
    	PerRecuresively(str.toCharArray(),0,list);
    	Collections.sort(list);
		return list;
    	
    }
    
    //递归方法：第一个参数为数组，第二个参数为当前处理的位置，第三个参数为最终返回的list
    private void PerRecuresively(char[] cArray,int index,ArrayList<String> list){
    	if(index>=cArray.length){
    		list.add(String.valueOf(cArray));
    	}
    	for(int i=index;i<cArray.length;i++){
    		if(cArray[i]==cArray[index] && i!=index){
    			continue;
    		}else{
    			exc(cArray,index,i);//与当前的值交换
        		PerRecuresively(cArray,index+1,list);
        		exc(cArray,index,i);//一定要换回来！！
    		}
    	}
    }
    
    private void exc(char[] c,int i,int j){
    	char temp = c[i];
    	c[i] = c[j];
    	c[j] = temp;
    }
    
    public static void main(String[] args){
    	N28_ListAllString l = new N28_ListAllString();
    	ArrayList<String> list =l.Permutation("abcd");
    	for(String s :list){
        	System.out.println(s+",");
    	}

    }
}
