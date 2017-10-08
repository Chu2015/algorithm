package graph.undirectedGraph;

//查找所有的连通分量，个数及结点
public class CC {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public CC(Graph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		//对图中每个点进行遍历
		for(int s=0; s<G.V();s++){
			//碰到还没标记过的，旧dfs
			if(!marked[s]){
				count ++;	//每次到这，都表示一个新的连通分量被找到
				dfs(G,s);
			}
		}

	}
	private void dfs(Graph G,int v){
		marked[v] = true;
		id[v] = count; //保存每一个结点的联通分量
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G,w);
			}
		}
	}
	
	//v，w是否联通
	public boolean connected(int v,int w){
		return id[v] == id[w];
	}
	
	//定点v属于第几个连通分量
	public int id(int v){
		return id[v];
	}
	
	//返回联通分量总数
	public int count(){
		return count;
	}
}
