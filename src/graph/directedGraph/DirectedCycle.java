package graph.directedGraph;

import java.util.Stack;

//Ѱ������,�ҵ�����һ������
public class DirectedCycle {
	//����Ƿ񵽴���˽��
	private boolean[] marked;
	//���ÿ������ÿ�������ϸ����
	private int edgeTo[];
	//���cycle���
	private Stack<Integer> cycle;
	//��Ǵ˽���Ƿ��ڵ�ǰ������ջ��
	private boolean[] onStack;
	
	public DirectedCycle(Diagraph D){
		marked = new boolean[D.V()];
		edgeTo = new int[D.V()];
		onStack = new boolean[D.V()];
		for(int i=0 ; i<D.V() ; i++){
			if(!marked[i]){
				dfs(D,i);
			}
		}
	}
	
	public void dfs(Diagraph D,int s){
		marked[s] = true;
		onStack[s] = true;
		for(int w : D.adj(s)){
			if(cycle != null){
				return;
			}
			if(!marked[w]){  
				edgeTo[w] = s;
				dfs(D,w);
			}else if(onStack[w]){ 
				cycle = new Stack<Integer>();
				for(int i= s; i!= w;i = edgeTo[i]){
					cycle.push(i);
				}
				cycle.push(w);
				cycle.push(s);
			}
			onStack[s] = false;
		}
	}
	
	public boolean hasCycle(){
		return cycle!=null;
	}
	
	public Iterable<Integer> cycle(){
		return cycle;
		
	}
	
	
}
