
public class Test {

	public int aa = 99;
	public Test(){
		method1();
		System.out.println(aa);
	}
	
	public void method1(){
		System.out.println("ִ�и��෽��");
	}
	
	public static void main(String[] args) {
		Test t = new Sub();
		Sub s = new Sub();
		//�������ÿ�ʵ�����ͣ��������ð��ձ�������
		System.out.println(t.aa);
		System.out.println(s.aa);
	}
}

class Sub extends Test{
	public int aa=100;
	
	@Override
	public void method1(){
		System.out.println("ִ�����෽��");
	} 
	
}