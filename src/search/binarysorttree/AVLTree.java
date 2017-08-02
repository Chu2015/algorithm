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
				switch(T.bf) /*  ���T��ƽ��� */ 
				{
					case LH: /*  ԭ�����������������ߣ���Ҫ����ƽ�⴦�� */
						if(parent.value>T.value){
							parent.left = LeftBalance(T);	
						}else{
							parent.right = LeftBalance(T);	
						}
						taller=false;
							break;
					case EH: /*  ԭ�����������ȸߣ��������������߶�ʹ������ */ 
						T.bf=LH; 
						taller=true;
							break;
					case RH: /*  ԭ�����������������ߣ������������ȸ� */  
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
				switch(T.bf) /*  ���T��ƽ��� */ 
				{
					case LH: /*  ԭ�����������������ߣ������������ȸ� */ 
						T.bf=EH; taller=false;	break;
					case EH: /*  ԭ�����������ȸߣ��������������߶�ʹ������  */
					    T.bf=RH; taller=true; break;
					case RH: /*  ԭ�����������������ߣ���Ҫ����ƽ�⴦�� */ 
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
		switch(L.bf) /*  ���T��ƽ��� */ 
		{
			case LH: /*  �½�������T�����ӵ��������ϣ�Ҫ������������ */ 
				T.bf=EH;
				L.bf=EH;
				return rotateRight(T);
			case RH: /*  �½�������T�����ӵ��������ϣ�Ҫ��˫������ */ 
				Lr = L.right;
				switch(Lr.bf)
				{ /*  �޸�T�������ӵ�ƽ������ */ 
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
		{ /*  ���T����������ƽ��ȣ�������Ӧƽ�⴦�� */ 
		 case RH: /*  �½�������T���Һ��ӵ��������ϣ�Ҫ������������ */ 
				  T.bf=EH;
				  R.bf=EH;
				  return rotateLeft(T);		  
		 case LH: /*  �½�������T���Һ��ӵ��������ϣ�Ҫ��˫������ */ 
				  Rl=R.left; /*  Rlָ��T���Һ��ӵ��������� */ 
				  switch(Rl.bf)
				  { /*  �޸�T�����Һ��ӵ�ƽ������ */ 
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
				  T.right = rotateRight(R); /*  ��T��������������ƽ�⴦�� */ 
				  return rotateLeft(T); /*  ��T������ƽ�⴦�� */ 
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
