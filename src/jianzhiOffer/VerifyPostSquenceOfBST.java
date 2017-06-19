package jianzhiOffer;

public class VerifyPostSquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
    	if(sequence!=null && sequence.length==0){
    		return false;
    	}
    	int end = sequence.length-1;
		return subverify(sequence,0,end);
    }
    
    public boolean subverify(int [] sequence,int start,int end){
    	if(start==end){
    		return true;
    	}
    	
    	int index=0,i=0;
    	
    	for(i=end-1 ; i>=start ; i--){
    		if(sequence[i]<sequence[end]){
    			break;
    		}
    	}
    	//no left tree or no right tree
		if(i<start || i==end-1){
			return subverify(sequence,start,end-1);
		}
		//left tree and right tree both
		index = i;
		while(i>=start){
			if(sequence[i]>sequence[end]){
				return false;
			}
			i--;
		}
		
		return subverify(sequence,start,index) && subverify(sequence,index+1,end-1);
    }
    
    public static void main(String[] args){
    	VerifyPostSquenceOfBST v = new VerifyPostSquenceOfBST();
    	int[] s ={5,7,6,9,11,10,8};
    	System.out.println(v.VerifySquenceOfBST(s));
    }
}
