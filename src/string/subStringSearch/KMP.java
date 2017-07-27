package string.subStringSearch;

import graph.undirectedGraph.StdOut;

public class KMP {
	private String pat;
	private int[][] dfa;
	public KMP(String pat){
		this.pat = pat;
		int M = pat.length();
		int R = 256;
		dfa = new int[R][M];
		
		int a = pat.charAt(0);
		
		dfa[pat.charAt(0)][0] = 1;
		//生成dfa(确定有限状态自动机)
		for(int j = 0,X = 0 ; j<M ; j++){
			for(int c = 0; c<R ; c++){
				dfa[c][j] = dfa[c][X];
			}
			dfa[pat.charAt(j)][j] = j+1; 
			X = dfa[pat.charAt(j)][X];
		}
		
	}
	
	//搜索
	public int search(String txt){
		int patlen = pat.length();
		int len = txt.length();
		int i ,j ;
		for(i = 0,j = 0; i < len && j<patlen ; i++){
			j = dfa[txt.charAt(i)][j];
		}
		if(j == patlen){
			return i - patlen; //找到匹配
		}else{
			return len; //未找到匹配
		}
	}
	
    public static void main(String[] args) {
        String pat = "AACA";
        String txt = "BBBDDCCDBAABDDAABRAACADABRAACAAADABRAAADDBBBBBCCDBDCDCDCBBDBD";

        KMP kmp1 = new KMP(pat);
        int offset1 = kmp1.search(txt);

        // print results
        StdOut.println("text:    " + txt);

        StdOut.print("pattern: ");
        for (int i = 0; i < offset1; i++)
            StdOut.print(" ");
        StdOut.println(pat);
    }
}
