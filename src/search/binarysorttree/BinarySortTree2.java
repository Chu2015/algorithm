package search.binarysorttree;

import java.util.HashMap;

public class BinarySortTree2<Key extends Comparable<Key>,Value> {
	Node root;
   private class Node{
		
		private Node left;
		private Node right;
		private Key key;
		private Value value;
		private int N;	//以该结点为根的子树中的结点总数
		
		public Node(Key key ,Value value,int N){
			this.key = key;this.value = value;this.N = N;
		}
	}
   
	public void put(Key k,Value v){
		root = put(root,k,v);
	}
	public Node put(Node x,Key k,Value v) {
		if(x==null){
			return new Node(k,v,1);
		}
		int com = k.compareTo(x.key);
		if(com>0){
			x.right = put(x.right,k,v);
		}else if(com<0){
			x.left = put(x.left,k,v);
		}else{
			x.value = v;
		}
		
		return x;
	}
	//非递归
	public void put2(Key k,Value v){
		if(root==null){
			root = new Node(k,v,1);
		}
		Node parent = null ;
		Node t = root;
		int com=0;
		while(t!=null){
			parent = t;
			com = t.key.compareTo(k);
			if(com >0){
				t = t.left;
			}else if(com<0){
				t = t.right;
			}else{
				t.value = v;
			}
		}
		Node newnode = new Node(k,v,1);
		if(com>0){
			parent.left = newnode;
		}else{
			parent.right = newnode;
		}
	}
	
	public void delete(Key k){
		root = delete(root,k);
	}
	//以x为根结点的树删除k后返回的结点
	public Node delete(Node x,Key k){
		int com = k.compareTo(x.key);
		if(com>0){
			x.right = delete(x.right,k);
			return x;
		}else if(com<0){
			x.left = delete(x.left,k);
			return x;
		}else{
			if(x.right==null){
				return x.left;
			}else if(x.left==null){
				return x.right;
			}else{
				Node min = min(x.right);
				min.right = deleteMin(x.right);
				min.left = x.left;
				return min;
			}
		}

	}
	private Node min(Node node) {
		if(node==null){
			return null;
		}
		while(node.left!=null){
			node = node.left;
		}
		return node;
	}
	private Node deleteMin(Node node){
		if(node==null){
			return null;
		}
		if(node.left==null){
			return node.right;
		}
		Node re = node;
		while(node.left.left!=null){
			node = node.left;
		}
		node.left = null;
		return re;
	}
	
}
