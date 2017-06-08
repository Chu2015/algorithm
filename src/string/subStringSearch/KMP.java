package string.subStringSearch;

import graph.undirectedGraph.StdOut;

public class KMP {
	private String pat;
	private int[][] dfa;
	public KMP(String pat){
		this.pat = pat;
		int M = pat.length();
		int R = 256;
		dfa = new int[M][R];
		
		//Éú³Édfa
		
	}
	
	//ËÑË÷
	public int search(String txt){
		return 0;
		
	}
	
    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];

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
