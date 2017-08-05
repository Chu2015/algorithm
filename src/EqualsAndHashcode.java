import java.util.Date;
import java.util.Objects;

public class EqualsAndHashcode {

	
	public static void main(String[] args) {
		Date date = new Date();
		Father2 f= new Father2("a",1,date);
		Son2 s = new Son2("a",1,date);
		Son2 s2 = new Son2("a",1,date);
		System.out.println(s2.equals(s));
	}
	
	
}
class Father2{
	
	private String name;
	private double salary;
	private Date payday;
	public Father2(String name,double salary,Date payday){
		this.name = name;
		this.salary = salary;
		this.payday = payday;
	}
	@Override
//	public int hashCode() {
//		return 7*Objects.hashCode(name)+11*new Double(salary).hashCode()+13*Objects.hashCode(payday);
//	}
	public int hashCode() {
		return Objects.hash(name,salary,payday);
    }
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(obj.getClass()!=getClass()){
			return false;
		}
		
		System.out.println(getClass());
		
		Father2 e = (Father2)obj;
		
		//return e.name.equals(this.name) && e.payday.equals(this.payday) && e.salary==this.salary;
		return Objects.equals(name, e.name) && Objects.equals(payday, e.payday) && e.salary==this.salary;
	}
	
}
class Son2 extends Father2{
	double bonus;
	public Son2(String name, double salary, Date payday) {
		super(name, salary, payday);
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)){
			return false;
		}
		Son2 s = (Son2) obj;
		return s.bonus == this.bonus;
	}
	
	
}

