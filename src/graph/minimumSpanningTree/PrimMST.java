package graph.minimumSpanningTree;

import graph.undirectedGraph.Bag;

public class PrimMST {
	private Edge[] edgeTo; //每个顶点距离树的最近的边
	private	double[] distTo; //每个点距离树的最近距离
	private boolean[] marked;
	private IndexMinPQ<Double> pq; //索引的key为节点编号，值为结点到树的最近距离的值(相应的distTo)
	
	public PrimMST(EdgeWeightedGraph ewg){
		//初始化
		int v = ewg.V();
		edgeTo = new Edge[v];
		distTo = new double[v];
		marked = new boolean[v];
		for(int i=0 ;i<v ;i++){
			distTo[i]=Double.POSITIVE_INFINITY;
		}
		pq = new IndexMinPQ<Double>(v);
		
		//从0结点开始，设置好distTo数组的值，向pq中插入
		distTo[0] = 0.0;
		pq.insert(0, 0.0);
		
		//从pq中取出最小值对应的key值，访问这个结点
		while(!pq.isEmpty()){
			visit(ewg,pq.delMin());		
		}
	}

	private void visit(EdgeWeightedGraph ewg, int v) {
		//将结点标记为已访问
		marked[v] = true;
		
		//遍历此结点周围的加权边
		for(Edge edge : ewg.adj(v)){
			//找打边另一端的结点
			int w = edge.other(v);
			if(!marked[w]){
				//对于未访问过的结点，如果此边的权重小于已有的权重，将这个值更新到edgeTo，distTo，以及pq
				if(edge.weight() < distTo[w]){
					edgeTo[w] = edge;
					distTo[w] = edge.weight();
					if(pq.contains(w)){
						pq.change(w, distTo[w]);
					}else{
						pq.insert(w, distTo[w]);
					}
				}
			}
		}
	}
	
	public Iterable<Edge> edges(){
		Bag<Edge> bag = new Bag<Edge>();
		for(Edge e : edgeTo){
			bag.add(e);
		}
		return bag;
	}
	
	public double weight(){
		double sum = 0;
		for(double d : distTo){
			sum += d;
		}
		return sum;
	}
	
}
  