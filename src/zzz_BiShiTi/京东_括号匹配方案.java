package zzz_BiShiTi;
import java.util.Scanner;
import java.util.Scanner;
public class ����_����ƥ�䷽�� {
	

	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//ע��while������case
            String n = in.next();
            char[] c =n.toCharArray();
        
            System.out.println(solution(c,1));
        }
    }
	
	public static int solution(char[] c,int time) {
		int len =c.length;
		//�߽���������
		if(time==len/2) {
			return 1;
		}
		int start = (time-1)*2;
		//���غ͵�һ������Ӧ�ģ��ĺ���
		int index = solution2(c,start);
		//���ص�ǰ�������ж����ֿ���
		int result = 0;
		//�������1λ��ʼ��������index
		for(int i=start;i<=index;i++) {
			//�ҵ�һ������ɾ����
			if(c[i]==')') {
				for(int j=i-1;j>start;j--) {
					c[j+1] = c[j];
				}
				//�ݹ���ã�����newc��������Ϊֹ���ж����ֿ���
				result += solution(c,time+1);
				for(int j=start+1;j<i;j++) {
					c[j] = c[j+1];
				}
				c[i] = ')';
			}
		}
		return result;
	}
	
	//���غ͵�һ������Ӧ�ģ��ĺ���
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
