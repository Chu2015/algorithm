package jianzhiOffer;

public class NumberOf1Between1AndN {
	
//    public int NumberOf1Between1AndN_Solution(int n) {
//    	int i=10;
//    	int sum = 0;
//    	while(n/i!=0){
//    		int j = n%i>=(i/10) ? n%(i/10)+1 : 0;
//    		sum += n/i * (i/10) +j;
//    		i *= 10;
//        }
//    	
//    	if(n%i/(i/10)>1){
//    		sum += i/10;
//    	}else if(n%i/(i/10)==1){
//    		sum += n%(i/10)+1;
//    	}
//    	return sum;
//    }
    
    public int NumberOf1Between1AndN_Solution(int n) {

    	char[] intChar = String.valueOf(n).toCharArray();
    	return recursive(intChar,0);
    }
    
    private int recursive(char[] a,int index){
    	int sum = 0;
    	int length = a.length;
    	int num  = Integer.valueOf(String.valueOf(a[index]));
    	
    	if(index==length-1){
    		if(num>=1){
    			return 1;
    		}else{
    			return 0;
    		}
    		
    	}
    	
    	//当前位数的1出现的次数
    	if(num>1){
    		sum += power(length-(index+1));
    	}else if(num==1){
    		sum += Integer.valueOf(String.valueOf(a, index+1, length-(index+1))) + 1;
    	}else if(num==0){
    		return 0;
    	}
    	//当前位数的影响下，带来的后面的位数出现1的次数
    	sum += power(length-(index+2))*(length-(index+1))*Integer.valueOf(String.valueOf(a[index]));
    	
    	return sum += recursive(a,index+1);
    }
    
    private int power(int i){
    	if(i==0){
    		return 1;
    	}
    	int j=10;
    	while(--i>0){
    		j *= 10;
    	}
    	return j;
    }
    
    
    
    public static void main(String[] args){
    	NumberOf1Between1AndN n = new NumberOf1Between1AndN();
    	System.out.println(n.NumberOf1Between1AndN_Solution(10));
    	System.out.println(n.power(0));
    }
    
    
}
