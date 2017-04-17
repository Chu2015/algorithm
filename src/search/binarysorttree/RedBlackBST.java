package search.binarysorttree;

public class RedBlackBST <Key extends Comparable<Key>,Value> {
	
	private final static boolean Red = true;
	private final static boolean Black = false;
	
	private Node root;
	
	private class Node{
		Node left;
		Node right;
		boolean color;
		Key key;
		Value value;
		int N;//结点个数
		
		Node(Key key,Value value,boolean color,int N){
			this.key = key;
			this.value = value;
			this.color = color;
			this.N = N;
		}
	}
	
	private boolean isRed(Node n){
		if(n==null) return false;
		return n.color == Red;
	}
	
	private Node rotateLeft(Node h){
		return null;
	}
	
	private Node rotateRight(Node h){
		return null;
	}
	
	private void flipColors(Node h){
		
	}
	
	public void put(Key key,Value value){
		put(root,key,value);
		
	}
	
	private Node put(Node n,Key key,Value value){
		if(n == null){
			return new Node(key, value, Red, 1);
		}
		int comp = root.key.compareTo(key);
		if(comp>0){
			n.left = put(n.left,key,value);
		}else if(comp<0){
			n.right = put(n.right,key,value);
		}else{
			n.value = value;
		}
		
		if(n.left.color == Black || n.left == null && n.right.color == Red ){
			return rotateLeft(n);
		}
		if(){
			
		}
		if(){
			
		}
		return n;
	}
	
}
