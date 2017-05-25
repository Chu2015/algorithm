package graph.undirectedGraph;

//判断是否是无环图
public class Cycle {

	private boolean[] marked;
	private boolean hasCycle;

	public Cycle(Graph G){
		marked = new boolean[G.V()];
		for(int s=0; s<G.V();s++){
			if(!marked[s]){
				dfs(G,s,s);
			}
		}
	}
	
	private void dfs(Graph G,int v,int u){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){  //相邻结点没有被mark过，继续延此结点往下走
				dfs(G,w,v);
			}else{
				if(w != u) hasCycle=true;//相邻结点被mark过：1、是上个结点，2、出现环
			}
		}
	}

	public boolean hasCycle(){
		return hasCycle;
	}
}
