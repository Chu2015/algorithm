package jianzhiOffer;

public class N48_Sum_Solution {
	
//    public int Sum_Solution(int n) {
//    	Add[] addArray = new Add[n];//在java中并不会调用Add类的构造函数
//		return Add.sum;
//    }
    
    public int Sum_Solution(int n) {
		return n<=0 ? 0: n + Sum_Solution(--n);
    }
    
	public static void main(String[] args){
		N48_Sum_Solution s = new N48_Sum_Solution();
		System.out.println(s.Sum_Solution(10));
	}
	
}

class Add{
	public static int sum=0;
	public static int N = 0;
	
	public Add(){
		N++;
		sum +=N;
	}
}