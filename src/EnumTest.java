public enum EnumTest {  
    RED("��ɫ", 1), GREEN("��ɫ", 2), BLANK("��ɫ", 3), YELLO("��ɫ", 4);  
    // ��Ա����  
    private String name;  
    private int index;  
    // ���췽��  
    private EnumTest(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
    // ��ͨ����  
    public static String getName(int index) {  
        for (EnumTest c : EnumTest.values()) {  
        	System.out.println(c.name+c.index);
            if (c.getIndex() == index) {  
                return c.name;  
            }  
        }  
        return null;  
    }  
    // get set ����  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getIndex() {  
        return index;  
    }  
    public void setIndex(int index) {  
        this.index = index;  
    }  
   
    public static void main(String[] args) {
    	EnumTest.getName(0);
	}
}  

 
  