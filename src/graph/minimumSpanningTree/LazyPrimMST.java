package graph.minimumSpanningTree;

import graph.undirectedGraph.Queue;

public class LazyPrimMST {

	private boolean marked[];  //��Ƕ����Ƿ�����С������
	private MinPQ<Edge> minpq; //��С������ҵ���СȨ�صı�
	private Queue<Edge> queue; //������С�������ı�
	
	public LazyPrimMST(EdgeWeightedGraph ewg){
		//
		int V = ewg.V();
		queue = new Queue<Edge>();
		minpq = new MinPQ<Edge>();
		marked = new boolean[V];
		
		visit(ewg,0);
		while(!minpq.isEmpty()){
			Edge minEdge = minpq.delMin();
			
			int i = minEdge.either();
			int j = minEdge.other(i);
			if(marked[i] && marked[j]){ //�ж��Ƿ�����Ч��
				continue;
			}
			
			queue.enqueue(minEdge);
			
			if(!marked[i]){
				visit(ewg,i);
			}else{
				visit(ewg,j);
			}
			
		}
	}
	
	public void visit(EdgeWeightedGraph ewg,int v){
		marked[v] = true;
		for(Edge edge : ewg.adj(v)){
			if(!marked[edge.other(v)]){
				minpq.insert(edge);
			}
		}
	}
	
	public Iterable<Edge> edges(){
		return queue;
	}
	
	public double weight(){
		double weight = 0;
		for(Edge edge: queue){
			weight +=edge.weight();
		}
		return weight;
	}
}
