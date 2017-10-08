package graph.undirectedGraph;

import java.io.InputStream;

public class Graph {
    //������Ŀ��
	private final int V;
	//�ߵ���Ŀ��
	private int E;
	//�ڽӱ�
	private Bag<Integer>[] adj;
	
	public Graph(int V){
		//��ʼ��V��E��adj
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
		//��ÿһ���ߣ�������
		for(int i=0;i<E;i++){
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	public void addEdge(int v,int w){
		//�ߵ���������Ӧ�����鶼Ҫ���
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
