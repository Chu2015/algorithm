package string.subStringSearch;

import graph.undirectedGraph.StdOut;

public class MyKMP {
	
	private int[][] dfs;
	private int patlen ;
	public MyKMP(String pat){
		int R = 256;
		patlen = pat.length();
		dfs = new int[R][patlen];
		
		//设置dfs初始状态
		dfs[pat.charAt(0)][0]=1;
		//X为重启状态。这里初始化dfs
		int X = 0;
		for(int j = 1;j<pat.length();j++){
			for(int i = 0;i<R;i++){
				dfs[i][j] = dfs[i][X];
			}
			dfs[pat.charAt(j)][j] = j+1;
			X = dfs[pat.charAt(j)][X];
		}
	}
	
	public int search(String word){
		if(word == null || word.length()==0){
			return -1;
		}
		int i,j;
		for(i=0,j=0;i<word.length() && j<patlen;i++){
			char c = word.charAt(i);
			j = dfs[c][j];
		}
		if(j==patlen){
			return i-patlen;
		}else{
			return -1;
		}
	}
	
	 public static void main(String[] args) {
	        String pat = "DD";
	        String txt = "BBBDDCCDBAABDDAABRAACADABRAACAAADABRAAADDBBBBBCCDBDCDCDCBBDBD";

	        MyKMP kmp1 = new MyKMP(pat);
	        int offset1 = kmp1.search(txt);

	        // print results
	        StdOut.println("text:    " + txt);

	        StdOut.print("pattern: ");
	        for (int i = 0; i < offset1; i++)
	            StdOut.print(" ");
	        StdOut.println(pat);
	    }
	
}
