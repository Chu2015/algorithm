package jianzhiOffer;

public class Print1ToNdigitMaxNum {
	//can not solve big number
	public static void print1ToNdigitMaxNum(int n){
		int number = 1,i=0;
		while(n-->0){
			number *= 10;
		}
		for(int j=1;j<number;j++){
			System.out.println(j);
		}
	}

	//using char array to solve the big recursively
	public static void print1ToNdigitMaxNum2(int n){
		if(n<=0){
			return;
		}
		char[] number= new char[n];
		for(int i=0;i<10;i++){
			number[0]=(char) ('0'+i);
			print1ToNdigitMaxNum2(number,0);
		}
	}
	
	private static void print1ToNdigitMaxNum2(char[] number,int index) {
		if(index >= number.length){
			print(number);
			return;
		}
		for(int i=0;i<10;i++){
			number[index] = (char) ('0'+i);
			print1ToNdigitMaxNum2(number,index+1);
		}
	}
	
	
	private static void print(char[] number) {
		int i=0;
		while(number[i]=='0'){
			i++;
		}
		String s = new String(number,i,number.length-i);
		System.out.printf(s);
	}


	public static void main(String[] args){
		char[] number = {'0','0','0','3','1'};
		Print1ToNdigitMaxNum.print(number);
//		Print1ToNdigitMaxNum.print1ToNdigitMaxNum2(3);
//		int b=8;
//		char a = (char) ('0'+b);
//		System.out.println(a);
	}
}
