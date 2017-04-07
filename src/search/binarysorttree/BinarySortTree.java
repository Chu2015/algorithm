package search.binarysorttree;

//用二叉树实现符号表
public class BinarySortTree<Key extends Comparable<Key>,Value> {
	
	private Node root;//根结点
	
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
	
	//返回二叉树总结点数
	public int size(){
		return size(root);
	}
	
	//以参数root作为根的树的总结点数
	public int size(Node root){
		if(root == null){
			return 0;
		}else{
			return root.N;
		}
	}
	
	//添加键值对
	public void put(Key key,Value value){
		root = put(root,key,value);
	}
	
	//向以x为根的树中添加键值对
	private Node put(Node x,Key key,Value value){
		if(x==null){
			return new Node(key,value,1);
		}else{
			int a = key.compareTo(x.key);
			if(a>0) x.right = put(x.right,key,value);
			else if(a<0) x.left = put(x.left,key,value);
			else x.value = value;
			x.N = size(x.left)+size(x.right)+1; //更新每个结点的N（表示以该结点作为根的子树的总结点）
			return x;
		}
	}
	
	//获取键的值
	public Value get(Key key){
		return get(root,key);
	}
	
	//获取以x为根的树中的键的值
	private Value get(Node x,Key key){
		if(x == null){
			return null;
		}
		int b = key.compareTo(x.key);
		if(b>0) return get(x.right,key); 
		else if(b<0) return get(x.left,key);
		else return x.value;
	}
	
	public Value min(){
		return min(root);
	}
	private Value min(Node x){
		if(x.left!=null){
			return min(x.left);
		}
		return x.value;
	}
	
	public Value max(){
		return max(root);
	}
	private Value max(Node x){
		if(x.right!=null){
			return max(x.right);
		}
		return x.value;
	}
	
	//查找排名为k的键(树中有k个小于它的键)
	public Key select(int k){
		return select(root,k);
	}
	
	private Key select(Node x,int k){
		if(k>=size() || x==null){
			return null;
		}
		int N = size(x.left);
		if(N==k){
			return x.key;
		}else if(N>k){
			return select(x.left,k);
		}else{
			return select(x.right,k-N-1);
		}
		
	}
	
	//向下取整
	public Key floor(Key key){
		return floor(root,key);
	}
	
	private Key floor(Node x,Key key){
		if(x==null){
			return null;
		}
		
		int i = x.key.compareTo(key);
		if(i==0){
			return x.key;
		}else if(i>0){
			return floor(x.left,key);
		}else{
			return floor(x.right,key)==null ? x.key:floor(x.right,key);
		}
	}
	
	public static void main(String[] args){
		BinarySortTree<Integer,String> bst = new BinarySortTree<Integer,String>();
		bst.put(1, "1");
		bst.put(22, "22");
		bst.put(2, "2");
		bst.put(45, "45");
		bst.put(21, "21");
		bst.put(333, "333");
		bst.put(331, "331");
		bst.put(322, "322");
		bst.put(62, "62");
		bst.put(85, "85");
		bst.put(31, "31");
		bst.put(33, "33");
		
		System.out.println(bst.min());
		System.out.println(bst.max());
		
		System.out.println(bst.select(5));
		System.out.println(bst.floor(89));
	}
}
