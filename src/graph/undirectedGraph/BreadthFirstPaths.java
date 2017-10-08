package graph.undirectedGraph;

public class BreadthFirstPaths {
	//标记这个点有没有到过
	private boolean[] marked;
	//edgeTo[v]=m,表示从m点到达的v点
	private int[] edgeTo;
	//从s开始
	private final int s;
	
	public BreadthFirstPaths(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G,s);
	}
	
	private void bfs(Graph G, int s){
		//深度优先，使用队列先进先出
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		//将s点加入队列
		queue.enqueue(s);
		while(!queue.isEmpty()){
			//将队列首部取出
			int v = queue.dequeue();
			//对相邻结点遍历
			for(int w : G.adj(v)){
				if(!marked[w]){
					//还未被标记过的相邻结点添加到队列中
					queue.enqueue(w);
					//更新标记数组
					marked[w] = true;
					//更新路径数组
					edgeTo[w] = v;
				}
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)){return null;}
		Stack<Integer> stack = new Stack();
		for(int i = edgeTo[v];i!=s ; i = edgeTo[i]){
			stack.push(i);
		}
		stack.push(s);
		return stack;
	}
}
