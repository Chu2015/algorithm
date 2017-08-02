package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;



public class Test3 {
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
			int steps = m - n + 1;// 算上了起点和终点
			int[] dp = new int[steps];// 规划的量：到达 每个位置需要的最小步数
			dp[0] = 0; // 起点
			for (int i = 1; i < steps; i++) {
				dp[i] = Integer.MAX_VALUE; // 初始化 表示后续位置都不能到达
			}
			for (int i = 0; i < steps; i++) {
				if (dp[i] == Integer.MAX_VALUE) { // 该位置不能像前走
					dp[i] = 0;
					continue;
				}
				ArrayList<Integer> list = getAppNums(i + n); // i+n才是石板号
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
