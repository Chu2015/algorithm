package graph.directedGraph;

import graph.undirectedGraph.Graph;

//kosaraju�㷨��������ͼ��ǿ��ͨ ����
public class KosarajuSCC {

	private boolean[] marked;
	private int count;
	private int[] id;
	
	public KosarajuSCC(Diagraph G){
		marked = new boolean[G.V()];
		//�õ�����ͼ������ͼ
		Diagraph Greverse = G.reverse();
		
		//�õ�����ͼ���淴˳��
		DepthFirstOrder dfs = new DepthFirstOrder(G);
		Iterable<Integer> order = dfs.reversePost();
		
		//�����淴���н��������������
		for(int i : order){
			if(!marked[i]){
				count++;  //ÿ���µ�������ʼ��count+1,ѭ������ʱ��count��Ϊǿ��ͨ����
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
