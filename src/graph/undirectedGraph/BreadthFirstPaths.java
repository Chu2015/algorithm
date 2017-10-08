package graph.undirectedGraph;

public class BreadthFirstPaths {
	//����������û�е���
	private boolean[] marked;
	//edgeTo[v]=m,��ʾ��m�㵽���v��
	private int[] edgeTo;
	//��s��ʼ
	private final int s;
	
	public BreadthFirstPaths(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G,s);
	}
	
	private void bfs(Graph G, int s){
		//������ȣ�ʹ�ö����Ƚ��ȳ�
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		//��s��������
		queue.enqueue(s);
		while(!queue.isEmpty()){
			//�������ײ�ȡ��
			int v = queue.dequeue();
			//�����ڽ�����
			for(int w : G.adj(v)){
				if(!marked[w]){
					//��δ����ǹ������ڽ����ӵ�������
					queue.enqueue(w);
					//���±������
					marked[w] = true;
					//����·������
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
