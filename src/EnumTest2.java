interface Behaviour {  
    void print();  
    String getInfo();  
}  
public enum EnumTest2 implements Behaviour{  
    RED("��ɫ", 1), GREEN("��ɫ", 2), BLANK("��ɫ", 3), YELLO("��ɫ", 4);  
    // ��Ա����  
    private String name;  
    private int index;  
    // ���췽��  
    private EnumTest2(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
    //�ӿڷ���  
    public String getInfo() {  
        return this.name;  
    }  
    //�ӿڷ���  
    public void print() {  
        System.out.println(this.index+":"+this.name);  
    }  
    
    public static void main(String[] args) {
    
	}
}  

