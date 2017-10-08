package jianzhiOffer;

public class N44_IsContinuous {
	
	//只有两个王，不够简便的方法
//    public boolean isContinuous(int [] numbers) {
//    	insertSort(numbers);
//    	boolean hasKing= false;
//    	boolean hasDoubleKing = false;
//    	int kingleft = 0;
//    	if(numbers[0]==0){
//    		hasKing = true;
//    		kingleft++;
//    	}
//    	if(numbers[1]==0){
//    		hasDoubleKing = true;
//    		kingleft++;
//    	}
//    	for(int i=kingleft;i<numbers.length-1;i++){
//    		int dis = (numbers[i+1]-numbers[i]);
//    		if( dis==2 ){
//    			if(!hasKing){
//    				return false;
//    			}else if(kingleft<=0){
//    				return false;
//    			}else{
//    				kingleft--;
//    			}
//    		}else if(dis==3){
//    			if(!hasDoubleKing && kingleft==2){
//    				kingleft -= 2;
//    			}else{
//    				return false;
//    			}
//    		}else if( dis>3 || dis==0){
//    			return false;
//    		}
//    	}
//    	
//		return true;
//    	
//    }
    public boolean isContinuous(int [] numbers) {
    	insertSort(numbers);

    	int kingNum = 0;
    	for(int i=0;i<numbers.length && numbers[i]==0;i++){
    		kingNum++;
    	}
    	int gapNum = 0;
    	
    	//算出间隔的数量和王的数量对比，每张王可以填补一个间隔
    	for(int i=kingNum;i<numbers.length-1;i++){
    		int dis = (numbers[i+1]-numbers[i]);
    		
    		if( dis-1>kingNum || dis==0){
    			return false;
    		}else{
    			gapNum+=dis-1;
    		}
    	}
    	
    	if(gapNum>kingNum){
    		return false;
    	}
    	
		return true;
    	
    }
    
    //between O(n)-O(n^2)，no extra space used
    public void insertSort(int[] numbers){
    	for(int i=1;i<numbers.length;i++){
    		//找到这个数的合适的位置
    		int j;
    		for(j=i-1;j>=0;j--){
	    		if(numbers[i]>numbers[j]){
	    			break;
	    		}
    		}
    		
    		//位置为j+1,将j到i之间的数字统统向前挪动一位
    		int position = j+1;
    		int current  = numbers[i];
    		for(int k=i-1; k>=position; k-- ){
    			numbers[k+1] = numbers[k];
    		}
    		numbers[position] = current;
    	}
    }
    
    public static void main(String args[]){
    	N44_IsContinuous i = new N44_IsContinuous();
    	int[] n = {2,3,1,0,6};
    	System.out.println(i.isContinuous(n));
//    	i.insertSort(n);
//    	for(int j : n){
//    		System.out.println(j+" ");
//    	}
    	
    	
    }
}
