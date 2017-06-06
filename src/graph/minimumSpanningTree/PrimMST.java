package graph.minimumSpanningTree;

import graph.undirectedGraph.Bag;

public class PrimMST {
	private Edge[] edgeTo; //ÿ�����������������ı�
	private	double[] distTo; //ÿ������������������
	private boolean[] marked;
	private IndexMinPQ<Double> pq; //������keyΪ�ڵ��ţ�ֵΪ��㵽������������ֵ(��Ӧ��distTo)
	
	public PrimMST(EdgeWeightedGraph ewg){
		//��ʼ��
		int v = ewg.V();
		edgeTo = new Edge[v];
		distTo = new double[v];
		marked = new boolean[v];
		for(int i=0 ;i<v ;i++){
			distTo[i]=Double.POSITIVE_INFINITY;
		}
		pq = new IndexMinPQ<Double>(v);
		
		//��0��㿪ʼ�����ú�distTo�����ֵ����pq�в���
		distTo[0] = 0.0;
		pq.insert(0, 0.0);
		
		//��pq��ȡ����Сֵ��Ӧ��keyֵ������������
		while(!pq.isEmpty()){
			visit(ewg,pq.delMin());		
		}
	}

	private void visit(EdgeWeightedGraph ewg, int v) {
		//�������Ϊ�ѷ���
		marked[v] = true;
		
		//�����˽����Χ�ļ�Ȩ��
		for(Edge edge : ewg.adj(v)){
			//�Ҵ����һ�˵Ľ��
			int w = edge.other(v);
			if(!marked[w]){
				//����δ���ʹ��Ľ�㣬����˱ߵ�Ȩ��С�����е�Ȩ�أ������ֵ���µ�edgeTo��distTo���Լ�pq
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
  