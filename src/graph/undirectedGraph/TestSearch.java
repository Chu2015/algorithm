package graph.undirectedGraph;

public class TestSearch {

	public static void main(String[] args){
		Graph G = new Graph(new In(args[0]));
		int s = Integer.parseInt(args[1]);
		DepthFirstSearch search = new DepthFirstSearch(G,s);

		
		for(int v=0;v<G.V();v++){
			if(search.marked(v)){
				System.out.println(v+" ");
			}
		}
		
	}
}
