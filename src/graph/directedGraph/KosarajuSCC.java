package graph.directedGraph;

import graph.undirectedGraph.Graph;

//kosaraju算法计算有向图的强连通 分量
public class KosarajuSCC {

	private boolean[] marked;
	private int count;
	private int[] id;
	
	public KosarajuSCC(Diagraph G){
		marked = new boolean[G.V()];
		//得到有向图的逆向图
		Diagraph Greverse = G.reverse();
		
		//得到逆向图的逆反顺序
		DepthFirstOrder dfs = new DepthFirstOrder(G);
		Iterable<Integer> order = dfs.reversePost();
		
		//按照逆反序列进行深度优先搜索
		for(int i : order){
			if(!marked[i]){
				count++;  //每次新的搜索开始，count+1,循环结束时，count即为强连通分量
				dfs(G,i);	
			}
		}
	}
	
	private void dfs(Diagraph G,int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G,w);
			}
		}
	}
	
	public int count(){
		return count;
	}
}
