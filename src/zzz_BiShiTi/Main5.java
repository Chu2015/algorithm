package zzz_BiShiTi;
import java.util.*;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character,ArrayList<Integer>> map = new HashMap<Character,ArrayList<Integer>>();
        int[][] aaa = new int[24][];
        while (in.hasNext()) {
        	String a = in.next();
        	int m = in.nextInt();
            char[] carray = a.toCharArray();
            for(int i=0;i<a.length();i++) {
            	char c = carray[i];
            	if(map.get(c)==null) {
            		ArrayList<Integer> arraylist = new ArrayList<Integer>();
            		arraylist.add(i);
            		map.put(c, arraylist);
            	}else {
            		ArrayList<Integer> arraylist = map.get(c);
            		arraylist.add(i);
            		map.put(c, arraylist);
            	}
            }
            Iterator iter = map.keySet().iterator();
            while(iter.hasNext()) {
            	Character key = (Character)iter.next();
            	ArrayList<Integer> eachlist  = map.get(key);
            	int size = eachlist.size();
            	int[] dis = new int[size-1];
            	for(int i=1;i<size;i++) {
            		dis[i] = eachlist.get(i)-eachlist.get(i-1);
            	}
            	int dp[] = new int[size-1];
            	for(int i=0;i<size-1;i++) {
            		if(dis[i]>m) {
            		   continue;	
            		}
            		
            	}
            }
            
            System.out.println(Integer.valueOf('a'));
        }
    }
}
