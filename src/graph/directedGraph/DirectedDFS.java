package graph.directedGraph;

//�ж�һ���������ڵ�ɵ�������н��
public class DirectedDFS{
	private boolean[] marked;
	
	//����һ����㣬��marked���������еĿɵ�����
	public DirectedDFS(Diagraph D,int s){
		marked = new boolean[D.V()];
		dfs(D,s);
	}
	
	//����һ���㣬��marked���������еĿɵ�����
	public DirectedDFS(Diagraph D,Iterable<Integer> v){
		marked = new boolean[D.V()];
		for(int w : v){
			if(!marked[w]){
				dfs(D,w);
			}
		}
	}
	
	public void dfs(Diagraph D,int s){
		marked[s] = true;
		for(int w : D.adj(s)){
			if(!marked[w]){
				dfs(D,w);
			}
		}
	}
	//�ж�һ���������ڵ�ɵ�������н��
	public boolean marked(int v){
		return marked[v];
	}
	
}
