package graph.undirectedGraph;

//�ж��Ƿ��Ƕ���ͼ
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
			if(!marked[w]){  //���ڽ��û�б�mark���������Ӵ˽��������
				color[w] = !color[v]; //��һ�ε���˽��ʱ��������color��ǳɺ��ϸ�����෴
				dfs(G,w);
			}else{
				//���ڽ�㱻mark����1�����ϸ���㣬2�����ֻ�������2�������color��ͬ����˵�����Ƕ���ͼ������ͼһ�����л�ͼ
				if(color[w] == color[v]) isTwoColorable=false;
			}
		}
	}

	public boolean hasCycle(){
		return isTwoColorable;
	}
}
