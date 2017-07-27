package jianzhiOffer;

public class Add {
	
    public int Add(int num1,int num2) {
    	if(num2==0){
    		return num1;
    	}
        int i = num1^num2;
        int j = (num1&num2)<<1;
        return Add(i,j);
    }
    
	public static void main(String[] args){
		Add a = new Add();
		System.out.println(a.Add(111,899));
	}
}

