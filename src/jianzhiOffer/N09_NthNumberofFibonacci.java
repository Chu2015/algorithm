package jianzhiOffer;

public class N09_NthNumberofFibonacci {
	//閫掑綊(not recommend)
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
    //璺抽潚铔�
    public int JumpFloor(int n) {
		int pre = 0;
    	int result = 1;
    	if(n<1){
    		return 0;
    	}
    	for(int i=1; i<=n ;i++){
    		int temp = result;
    		result = pre+result;
    		pre =temp;
    	}
    	return result;
    }
    public static void main (String[] args){
    	N09_NthNumberofFibonacci n = new N09_NthNumberofFibonacci();
    	System.out.println(n.Fibonacci(99));
    }
}
