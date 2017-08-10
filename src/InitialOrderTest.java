
public class InitialOrderTest {
    public static void main(String[] args) {
    	Object o = new Object();
        Son son = new Son();
        Grandpa g = new Grandpa();
        System.out.println(son.getClass() == Son.class);
    }
}

class Grandpa {
    public Grandpa() {
        System.out.println("this is grandpa.");
    }
    
    Father method(){
		return null;
    }
    
    static{
    	System.out.println("初始化grandpa的静态区域");
    }

    public Grandpa(int age) {
        System.out.println("grandpa is " + age + " years old.");
    }

    private Height height = new Height(1.5f);
    {
    	System.out.println("非静态代码块");
    }
    
    public static Gender gender = new Gender(true, "grandpa");
}

class Father extends Grandpa {

    public Father() {
        System.out.println("this is father.");
    }

    public Father(int age) {
        System.out.println("father is " + age + " years old.");
    }

    private Height height = new Height(1.6f);

    public static Gender gender = new Gender(true, "father");
    static{
    	System.out.println("初始化father的静态区域");
    }
    @Override
	protected Father method(){
		return null;
    }
}

class Son extends Father {

    public Son() {
        super(50);
        System.out.println("this is son.");
    }

    public Son(int age) {
        System.out.println("son is " + age + " years old.");
    }

    private Height height = new Height(1.8f);

    public static Gender gender = new Gender(true, "son");
    static{
    	System.out.println("初始化son的静态区域");
    }
}

class Height {
    public Height(float height) {
        System.out.println("initializing height " + height + " meters.");
    }
}

class Gender {
    public Gender(boolean isMale) {
        if (isMale) {
            System.out.println("this is a male.");
        } else {
            System.out.println("this is a female.");
        }
    }

    public Gender(boolean isMale, String identify) {
        if (isMale) {
            System.out.println(identify + " is a male.");
        } else {
            System.out.println(identify + " is a female.");
        }
    }
}