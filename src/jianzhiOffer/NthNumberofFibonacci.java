package jianzhiOffer;

public class NthNumberofFibonacci {
	//递归(not recommend)
//    public int Fibonacci(int n) {
//    	if(n<=0){
//    		return 0;
//    	}
//    	if(n==1){
//    		return 1;
//    	}
//    	return Fibonacci(n-1)+Fibonacci(n-1);
//    }
//   
	
    public int Fibonacci(int n) {
    	int pre = 0;
    	int result = 1;
    	if(n<=1){
    		return 0;
    	}
    	if(n==2){
    		return 1;
    	}
    	for(int i=3; i<=n ;i++){
    		int temp = result;
    		result = pre+result;
    		pre =temp;
    	}
    	return result;
    }
    //跳青蛙
    public int JumpFloor(int target) {
		int pre = 0;
    	int result = 1;
    	if(target<1){
    		return 0;
    	}
    	for(int i=1; i<=target ;i++){
    		int temp = result;
    		result = pre+result;
    		pre =temp;
    	}
    	return result;
    }
    public static void main (String[] args){
    	NthNumberofFibonacci n = new NthNumberofFibonacci();
    	System.out.println(n.Fibonacci(12));
    }
}
