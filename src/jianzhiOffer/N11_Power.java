package jianzhiOffer;

public class N11_Power {
//    public double Power(double base, int exponent) {
//    	if(exponent<0){
//    		return 1/Power(base, -exponent);
//    	}
//        if(exponent==0){
//        	return 1;
//        }else if(exponent==1){
//        	return base;
//        }
//        if(exponent%2==0){
//        	return Power(base, exponent/2) * Power(base, exponent/2);
//        }else{
//        	return Power(base, exponent/2) * Power(base, exponent/2+1);
//        }
//        
//    }
    public double Power(double base, int exponent) {
    	if(base==0 && exponent<0){
    		return 0;
    	}
    	if(exponent<0){
    		return 1/Power(base, -exponent);
    	}
        if(exponent==0){
        	return 1;
        }else if(exponent==1){
        	return base;
        }
        //return Power(base, exponent/2) * Power(base, exponent/2); //bad
        double result = Power(base, exponent>>1); //better than exponent/2
        result *= result;
        //指数为奇数个情况
        if((exponent & 1)==1){
        	 result *= base;
        }
        return  result;
    }
    
    public static void main(String[] args){
    	long startTime=System.nanoTime();    
    	N11_Power p = new N11_Power();
    	System.out.println(p.Power(2, 1000));
    	long endTime=System.nanoTime();    
    	System.out.println(endTime-startTime);
    }
}
