package graph.undirectedGraph;

//����ͼ
public class SymbolGraph {
	private ST<String,Integer> st; //���ŵ�������ӳ��
	private String[] keys; //���������ŵ�ӳ��
	private Graph graph;
	
	public SymbolGraph(String stream,String sp){
		st = new ST<String,Integer>();
		In in = new In(stream);
		while(in.hasNextLine()){
			String[] a = in.readLine().split(sp);
			for(int i=0;i<a.length;i++){
				if(!st.contains(a[i])){
					st.put(a[i], i);  //����st
				}
			}
		}
		keys = new String[st.size()];
		for(String name : st.keys()){
			keys[st.get(name)] = name;//����keys
		}
		
		graph = new Graph(st.size());
		
		while(in.hasNextLine()){
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for(int i=1;i<a.length;i++){
				int w = st.get(a[i]);
				graph.addEdge(v,w);
			}
		}
	}
	public boolean contains(String s) {
		return st.contains(s);
	}
	public int index(String s){
		return st.get(s);
	}
	public String name(int v){
		return keys[v];
	}
	public Graph G(){
		return graph;
	}
}
