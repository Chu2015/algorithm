package cc150;

import java.util.ArrayList;

public class Clearer {
    public int[][] clearZero(int[][] mat, int n) {
    	int[][] result = new int[n][n];
    	ArrayList<Integer> ilist = new ArrayList<Integer>();
    	ArrayList<Integer> jlist = new ArrayList<Integer>();
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(mat[i][j]==0) {
        			ilist.add(i);
        			jlist.add(j);
        		}
        	}
        }
        for(int i=0;i<ilist.size();i++) {
        	int a = ilist.get(i);
        	for(int j=0;j<n;j++) {
        		mat[a][j] =0;
        	}
        }
        for(int j=0;j<jlist.size();j++) {
        	int b = jlist.get(j);
        	for(int i=0;i<n;i++) {
        		mat[i][b] =0;
        	}
        }
        return mat;
    }
}
