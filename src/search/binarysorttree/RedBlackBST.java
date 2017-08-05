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
		int N = 0;//������
		
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
	
	private int sizeOf(Node n){
		if(n == null){
			return 0;
		}
		return n.N;
	}
	private Node rotateLeft(Node h){
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = Red;
		return x;
	}
	
	private Node rotateRight(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = Red;
		return x;
	}
	
	private void flipColors(Node h){
		h.left.color = Black;
		h.right.color = Black;
		h.color = Red;
	}
	
	public void put(Key key,Value value){
		root = put(root,key,value);
		root.color = Black;
	}
	
	private Node put(Node n,Key key,Value value){
		if(n == null){
			return new Node(key, value, Red, 1);//�²���Ľ����ɫΪ��
		}
		int comp = n.key.compareTo(key);
		if(comp>0){
			n.left = put(n.left,key,value);
		}else if(comp<0){
			n.right = put(n.right,key,value);
		}else{
			n.value = value;
		}
		
		//����������·���ϵ����н������������
		if(!isRed(n.left) && isRed(n.right) ){
			//wrong: return rotateLeft(n);
			n = rotateLeft(n);
		}
		if(isRed(n.left) && isRed(n.left.left)){
			//wrong: return rotateLeft(n);
			n = rotateRight(n);
		}
		if(isRed(n.left) && isRed(n.right)){
			flipColors(n);
		}
		n.N = sizeOf(n.left) + sizeOf(n.right) + 1;
		return n;
	}
	
	//ɾ����Сֵ
	public void deleteMin(){
		if(!isRed(root.left) && !isRed(root.right)){
			root.color = Red;
		} //����������һ��2��㣬�������ɫ��Ϊ�죬
		root = deleteMin(root);
		if(root!=null) root.color = Black;
	}
	private Node deleteMin(Node n){
		if(n.left == null){
			return null;
		}
		if(!isRed(n.left) && !isRed(n.left.left)){ //�����ڵ�Ϊ2���
			 n = moveRedLeft(n); //�Ѻ�ɫ�������
		}
		n.left = deleteMin(n.left);
		
		return balance(n);
	}

	private Node moveRedLeft(Node n){
		flipColors2(n);
		if(isRed(n.right.left)){
			n.right = rotateRight(n.right);
			n = rotateLeft(n);
		}
		return n;
	}
	private void flipColors2(Node n){
		n.left.color = Red;
		n.right.color = Red;
		n.color = Black;
	}
	
	private Node balance(Node n) {
		if(!isRed(n.left) && isRed(n.right) ){//��߲�Ϊ�죬�ұ�Ϊ�죬����ת
			n = rotateLeft(n);
		}
		if(isRed(n.left) && isRed(n.left.left)){//��ߡ���ߵ���߶�Ϊ�죬����ת
			n = rotateRight(n);
		}
		if(isRed(n.left) && isRed(n.right)){//��ߣ��ұ߶�Ϊ�죬��ɫת��
			flipColors(n);
		}	
		n.N = sizeOf(n.left) + sizeOf(n.right) + 1;
		return n;
	}
	
	public void print(){
		print(root);
	}
	
	public void print(Node x){
		if(x.left != null){
			print(x.left);
		}
		System.out.print(x.key+"|");
		if(x.right != null){
			print(x.right);
		}
	}
	public static void main(String[] args){
		RedBlackBST<Integer,String> RBbst = new RedBlackBST<Integer,String>();
		RBbst.put(1, "1");
		RBbst.put(9, "9");
		RBbst.put(8, "8");
		RBbst.put(7, "7");
		
		RBbst.print();
		RBbst.deleteMin();System.out.println();
		RBbst.print();
		
	}
}
