package graph.directedGraph;

import java.util.Stack;

//寻找有向环,找到任意一个即可
public class DirectedCycle {
	//标记是否到达过此结点
	private boolean[] marked;
	//标记每个到达每个结点的上个结点
	private int edgeTo[];
	//存放cycle结点
	private Stack<Integer> cycle;
	//标记此结点是否在当前的搜索栈内
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
