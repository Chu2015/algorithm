package graph.directedGraph;

import graph.undirectedGraph.Bag;

public class Diagraph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	
	public Diagraph(int V){
		this.V = V;
		this.E = 0;
		adj =(Bag<Integer>[]) new Bag[V];
		for(int v = 0;v<V;v++){
			adj[v] = new Bag<Integer>();
		}
	}
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
	public void addEdge(int v,int w){
		adj[v].add(w);  //娌℃坊鍔犱竴鏉¤竟浼氬嚭鐜颁袱娆�
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public Diagraph reverse(){
		Diagraph R = new Diagraph(V);
		for(int i=0;i<V;i++){
			for(int j : adj[i]){
				R.addEdge(j, i);
			}
		}
		return R;
	}
}
