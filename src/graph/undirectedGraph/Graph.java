package graph.undirectedGraph;

import java.io.InputStream;

public class Graph {
    //顶点数目：
	private final int V;
	//边的数目：
	private int E;
	//邻接表
	private Bag<Integer>[] adj;
	
	public Graph(int V){
		//初始化V，E，adj
		this.V = V;
		this.E = 0;
		adj =(Bag<Integer>[]) new Bag[V];
		for(int v = 0;v<V;v++){
			adj[v] = new Bag<Integer>();
		}
	}
	public Graph(In in){
		this(in.readInt());
		int E = in.readInt();
		//对每一条边，做处理
		for(int i=0;i<E;i++){
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	public void addEdge(int v,int w){
		//边的两个结点对应的数组都要添加
		adj[v].add(w);  
		adj[w].add(v);
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
}
