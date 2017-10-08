package graph.undirectedGraph;

//利用dfs查找图中的路径
public class DepthFirstPaths {
	//标记这个点有没有到过
	private boolean[] marked;
	//edgeTo[v]=m,表示从m点到达的v点
	private int[] edgeTo;
	//起点
	private final int s;
	
	public DepthFirstPaths(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G,s);
	}
	
	private void dfs(Graph G,int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(G,w);
			}
		}
	}

	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(hasPathTo(v) != true) return null;
		Stack<Integer> path = new Stack();
		for(int x =v ;x != s; x = edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;
	}

}
