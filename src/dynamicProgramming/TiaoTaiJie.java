package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;



public class TiaoTaiJie{
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
//			while (scanner.hasNext()) {
//				int n = scanner.nextInt();
//				int m = scanner.nextInt();
				System.out.println(leastJumpTime(4, 24));
//			}
		}

		public static int leastJumpTime(int n, int m) {
			if (m == n) {
				return 0;
			}
			int steps = m - n + 1;//台阶数(包含n和m)
			//dp数组表示，达到此位置最少的步数
			int[] dp = new int[steps];
			dp[0] = 0; //数组边界
			//初始化数组，表示无法达到
			for (int i = 1; i < steps; i++) {
				dp[i] = Integer.MAX_VALUE; 
			}
			//每个阶段，数组指针向右移动一个
			for (int i = 0; i < steps; i++) {
				//如果等于maxvalue，说明这个位置无法到达
				if (dp[i] == Integer.MAX_VALUE) { 
					dp[i] = 0;
					continue;
				}
				//得到台阶的因数，台阶编号为i+n
				ArrayList<Integer> list = getAppNums(i + n); 
				//每个阶段下，对可以到达的位置更新
				for (int j = 0; j < list.size(); j++) {
					int x = list.get(j);
					if (i + n + x <= m) {
						dp[i + x] = Math.min(dp[i + x], dp[i] + 1);
					}
				}
			}
			if (dp[steps - 1] == 0) {
				return -1;
			} else {
				return dp[steps-1];
			}
		}
		
		//求n的因数，除了1和n
		public static ArrayList<Integer> getAppNums(int n) {
			ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = 2; i <= Math.sqrt(n); i++) {
					if (n % i == 0) {
						list.add(i);
						if (n / i != i) {
							list.add(n / i);
						}
					}
				}
				return list;
			}
		}
