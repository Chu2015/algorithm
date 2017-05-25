package graph.directedGraph;

//判断一个结点或多个节点可到达的所有结点
public class DirectedDFS{
	private boolean[] marked;
	
	//给定一个结点，用marked数组标记所有的可到达结点
	public DirectedDFS(Diagraph D,int s){
		marked = new boolean[D.V()];
		dfs(D,s);
	}
	
	//给定一组结点，用marked数组标记所有的可到达结点
	public DirectedDFS(Diagraph D,Iterable<Integer> v){
		marked = new boolean[D.V()];
		for(int w : v){
			if(!marked[w]){
				dfs(D,w);
			}
		}
	}
	
	public void dfs(Diagraph D,int s){
		marked[s] = true;
		for(int w : D.adj(s)){
			if(!marked[w]){
				dfs(D,w);
			}
		}
	}
	//判断一个结点或多个节点可到达的所有结点
	public boolean marked(int v){
		return marked[v];
	}
	
}
