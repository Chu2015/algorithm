package search.binarysorttree;



public class AVLTree {
	public final static int EH = 0;
	public final static int LH = 1;
	public final static int RH = -1;
	
	private Node root;
	
	private class Node{
		Node left;
		Node right;
		int value;
		int bf;
		
		public Node(int value, int bf){
			this.value = value;
			this.bf = bf;
		}
	}
	
	private Node rotateLeft(Node h){
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		return x;
	}
	
	private Node rotateRight(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		return x;
	}
	
	public void insertAVL(int value){
		if(root == null){
			root = new Node(value,EH);
		}
		insertAVL(root,value,false,null);
	}
	
	public boolean insertAVL(Node T,int value,Boolean taller,Node parent){
		if(T==null){
			Node t = new Node(value,RH);
			if(value<parent.value){
				parent.left = t;
			}else{
				parent.right = t;
			}
			taller = true;
			return true;
		}
		//already exists
		if(value == T.value){
			return false;
		}
		//recursion to backtrace
		if(value<T.value){
			if(!insertAVL(T.left,value,taller,T)){
				return false;
			}
			if(taller){
				switch(T.bf) /*  检查T的平衡度 */ 
				{
					case LH: /*  原本左子树比右子树高，需要作左平衡处理 */
						if(parent.value>T.value){
							parent.left = LeftBalance(T);	
						}else{
							parent.right = LeftBalance(T);	
						}
						taller=false;
							break;
					case EH: /*  原本左、右子树等高，现因左子树增高而使树增高 */ 
						T.bf=LH; 
						taller=true;
							break;
					case RH: /*  原本右子树比左子树高，现左、右子树等高 */  
						T.bf=EH; 
						taller=false;
						break;
				}
			}
		}else{
			if(!insertAVL(T.left,value,taller,T)){
				return false;
			}
			if(taller){
				switch(T.bf) /*  检查T的平衡度 */ 
				{
					case LH: /*  原本左子树比右子树高，现左、右子树等高 */ 
						T.bf=EH; taller=false;	break;
					case EH: /*  原本左、右子树等高，现因右子树增高而使树增高  */
					    T.bf=RH; taller=true; break;
					case RH: /*  原本右子树比左子树高，需要作右平衡处理 */ 
						if(parent.value>T.value){
							parent.left = RightBalance(T);	
						}else{
							parent.right = RightBalance(T);
						}
					     taller=false; break;
				}
			}
			
		}
		return true;
	}
	
	
	private Node LeftBalance(Node T){
		Node L = T.left;
		Node Lr;
		switch(L.bf) /*  检查T的平衡度 */ 
		{
			case LH: /*  新结点插入在T的左孩子的左子树上，要作单右旋处理 */ 
				T.bf=EH;
				L.bf=EH;
				return rotateRight(T);
			case RH: /*  新结点插入在T的左孩子的右子树上，要作双旋处理 */ 
				Lr = L.right;
				switch(Lr.bf)
				{ /*  修改T及其左孩子的平衡因子 */ 
					case LH: T.bf=RH;
							 L.bf=EH;
							 break;
					case EH: 
							T.bf=EH;
							L.bf=EH;
							 break;
					case RH: T.bf=EH;
							 L.bf=LH;
							 break;
				}
				Lr.bf=EH;
				T.left = rotateLeft(L);
				return rotateRight(T);
		}
		return null;
	}
	
	private Node RightBalance(Node T){
		Node R = T.right;
		Node Rl;
		switch(R.bf)
		{ /*  检查T的右子树的平衡度，并作相应平衡处理 */ 
		 case RH: /*  新结点插入在T的右孩子的右子树上，要作单左旋处理 */ 
				  T.bf=EH;
				  R.bf=EH;
				  return rotateLeft(T);		  
		 case LH: /*  新结点插入在T的右孩子的左子树上，要作双旋处理 */ 
				  Rl=R.left; /*  Rl指向T的右孩子的左子树根 */ 
				  switch(Rl.bf)
				  { /*  修改T及其右孩子的平衡因子 */ 
					case RH: T.bf=LH;
							 R.bf=EH;
							 break;
					case EH: T.bf=EH;
					         R.bf=EH;
							 break;
					case LH: T.bf=EH;
							 R.bf=RH;
							 break;
				  }
				  Rl.bf=EH;
				  T.right = rotateRight(R); /*  对T的右子树作右旋平衡处理 */ 
				  return rotateLeft(T); /*  对T作左旋平衡处理 */ 
		}
		return null;
	}
	
	public static void main(String[] args){
		AVLTree tree = new AVLTree();
		int i;
		int a[]={3,2,1,4,5,6,7,10,9,8};
		
		for(i=0;i<a.length;i++)
		{
			tree.insertAVL(a[i]);
		}
		
		System.out.println();
	}
}
