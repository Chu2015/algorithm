package graph.undirectedGraph;

//判断是否是二分图
public class TwoColor {
	private boolean[] marked;
	
	private boolean[] color;
	private boolean isTwoColorable = true;
	
	public TwoColor(Graph G){
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		for(int s=0; s<G.V();s++){
			if(!marked[s]){
				dfs(G,s);
			}
		}
	}
	
	private void dfs(Graph G,int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){  //相邻结点没有被mark过，继续延此结点往下走
				color[w] = !color[v]; //第一次到达此结点时，将它的color标记成和上个结点相反
				dfs(G,w);
			}else{
				//相邻结点被mark过：1、是上个结点，2、出现环，当第2种情况下color相同，则说明不是二分图，二分图一定是有环图
				if(color[w] == color[v]) isTwoColorable=false;
			}
		}
	}

	public boolean hasCycle(){
		return isTwoColorable;
	}
}
