package jianzhiOffer;

public class N47_Plus {
	
    public int Add(int num1,int num2) {
    	if(num2==0){
    		return num1;
    	}
        int i = num1^num2;
        int j = (num1&num2)<<1;
        return Add(i,j);
    }
    
	public static void main(String[] args){
		N47_Plus a = new N47_Plus();
		System.out.println(a.Add(111,899));
	}
}

