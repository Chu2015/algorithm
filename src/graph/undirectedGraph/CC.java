package graph.undirectedGraph;

//�������е���ͨ���������������
public class CC {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public CC(Graph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		//��ͼ��ÿ������б���
		for(int s=0; s<G.V();s++){
			//������û��ǹ��ģ���dfs
			if(!marked[s]){
				count ++;	//ÿ�ε��⣬����ʾһ���µ���ͨ�������ҵ�
				dfs(G,s);
			}
		}

	}
	private void dfs(Graph G,int v){
		marked[v] = true;
		id[v] = count; //����ÿһ��������ͨ����
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G,w);
			}
		}
	}
	
	//v��w�Ƿ���ͨ
	public boolean connected(int v,int w){
		return id[v] == id[w];
	}
	
	//����v���ڵڼ�����ͨ����
	public int id(int v){
		return id[v];
	}
	
	//������ͨ��������
	public int count(){
		return count;
	}
}
