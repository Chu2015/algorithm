package zzz_BiShiTi;
import java.util.Scanner;
import java.util.Scanner;
public class 京东_括号匹配方案 {
	

	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String n = in.next();
            char[] c =n.toCharArray();
        
            System.out.println(solution(c,1));
        }
    }
	
	public static int solution(char[] c,int time) {
		int len =c.length;
		//边界条件处理
		if(time==len/2) {
			return 1;
		}
		int start = (time-1)*2;
		//返回和第一个（对应的）的号码
		int index = solution2(c,start);
		//返回当前数组中有多少种可能
		int result = 0;
		//从数组第1位开始，遍历到index
		for(int i=start;i<=index;i++) {
			//找到一个可以删除的
			if(c[i]==')') {
				for(int j=i-1;j>start;j--) {
					c[j+1] = c[j];
				}
				//递归调用，返回newc操作到空为止会有多少种可能
				result += solution(c,time+1);
				for(int j=start+1;j<i;j++) {
					c[j] = c[j+1];
				}
				c[i] = ')';
			}
		}
		return result;
	}
	
	//返回和第一个（对应的）的号码
	public static int solution2(char[] c,int start) {
		if(c.length==2) {
			return 1;
		}
		int count=0;
		for(int i=start;i<c.length;i++) {
			if(c[i]=='(') {
				count++;
			}else if(c[i]==')') {
				count--;
				if(count==0) {
					return i;
				}
			}
		}

		return -1;
	}
	
	
}
