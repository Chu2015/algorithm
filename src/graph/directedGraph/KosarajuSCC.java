package graph.directedGraph;

import graph.undirectedGraph.Graph;

public class KosarajuSCC {

	private boolean[] marked;
	private int count;
	private int[] id;
	
	public KosarajuSCC(Diagraph G){
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	
	private void dfs(Diagraph G,int v){
		marked[v] = true;
		count++;
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G,w);
			}
		}
	}
	
	public boolean marked(int w){
		return marked[w];
	}
	
	public int count(){
		return count;
	}
}
