package boj_1010_다리놓기;

import java.util.Scanner;

public class Main {

	static int[][] dp;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			dp = new int[M+1][N+1];
			int answer = comb(M, N);
			
			System.out.println(answer);
		}
		sc.close();
	}
	
	private static int comb(int m, int n) {
		if (n == 1 || m == 1) return dp[m][n] = m;
		if (n == m) return dp[m][n] = 1;
		
		if (dp[m][n] != 0) return dp[m][n];
		
		return dp[m][n] = comb(m-1, n) + comb(m-1, n-1);
	}
}
