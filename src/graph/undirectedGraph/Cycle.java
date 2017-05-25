package graph.undirectedGraph;

//�ж��Ƿ����޻�ͼ
public class Cycle {

	private boolean[] marked;
	private boolean hasCycle;

	public Cycle(Graph G){
		marked = new boolean[G.V()];
		for(int s=0; s<G.V();s++){
			if(!marked[s]){
				dfs(G,s,s);
			}
		}
	}
	
	private void dfs(Graph G,int v,int u){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){  //���ڽ��û�б�mark���������Ӵ˽��������
				dfs(G,w,v);
			}else{
				if(w != u) hasCycle=true;//���ڽ�㱻mark����1�����ϸ���㣬2�����ֻ�
			}
		}
	}

	public boolean hasCycle(){
		return hasCycle;
	}
}
