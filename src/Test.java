
public class Test {

	public int aa = 99;
	public Test(){
		method1();
		System.out.println(aa);
	}
	
	public void method1(){
		System.out.println("执行父类方法");
	}
	
	public static void main(String[] args) {
		Test t = new Sub();
		Sub s = new Sub();
		//方法调用看实际类型，变量调用按照变量类型
		System.out.println(t.aa);
		System.out.println(s.aa);
	}
}

class Sub extends Test{
	public int aa=100;
	
	@Override
	public void method1(){
		System.out.println("执行子类方法");
	} 
	
}