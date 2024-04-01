package boj_1890_점프;

import java.util.Scanner;

public class Main {

	static int N;
	static int[][] board;
	static int[][] dp;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		board = new int[N][N];
		dp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		dfs(0, 0);

		sc.close();
	}
	
	private static void dfs(int r, int c) {
		if (board[r][c] == 0) return;
		
		int jump = board[r][c];
		
		if (r + jump < N) dp[r+jump][c]++;
		if (c + jump < N) dp[r][c+jump]++;
		
		
		
	}

}
