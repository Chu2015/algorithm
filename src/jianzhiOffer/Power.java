package jianzhiOffer;

public class Power {
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
        if((exponent & 1)==1){
        	 result *= base;
        }
        return  result;
    }
    
    public static void main(String[] args){
    	long startTime=System.nanoTime();   //获取开始时间  
    	Power p = new Power();
    	System.out.println(p.Power(2, 1000));
    	long endTime=System.nanoTime();   //获取开始时间  
    	System.out.println(endTime-startTime);
    }
}
