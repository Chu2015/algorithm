package graph.undirectedGraph;

public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	
	//��Gͼ����s�㿪ʼdfs
	public DepthFirstSearch(Graph G, int s){
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	
	private void dfs(Graph G,int v){
		//��ͨ���
		marked[v] = true;
		//��������+1
		count++;
		//dfs
		for(int w : G.adj(v)){
			//���û�б����
			if(!marked[w]){
				//�ݹ�
				dfs(G,w);
			}
		}
	}
	
	//����w��s�ǲ�����ͨ��
	public boolean marked(int w){
		return marked[w];
	}
	
	//��ȡ��s��ͨ�ĵ���
	public int count(){
		return count;
	}
}
