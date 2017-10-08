package graph.undirectedGraph;

public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	
	//对G图，从s点开始dfs
	public DepthFirstSearch(Graph G, int s){
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	
	private void dfs(Graph G,int v){
		//联通标记
		marked[v] = true;
		//数量点数+1
		count++;
		//dfs
		for(int w : G.adj(v)){
			//如果没有被标记
			if(!marked[w]){
				//递归
				dfs(G,w);
			}
		}
	}
	
	//检验w和s是不是联通的
	public boolean marked(int w){
		return marked[w];
	}
	
	//获取和s联通的点数
	public int count(){
		return count;
	}
}
