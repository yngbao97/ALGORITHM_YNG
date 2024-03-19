package boj_15684_사다리조작;

import java.util.Scanner;

public class Main {

	static int N;	// 세로선 개수
	static int M;	// 존재하는 가로선 개수
	static int H;	// 가로선을 놓을 수 있는 행의 개수
	static int[][] ladder;		// 열-행([H][N]) 순서
	static boolean[][] buildable;
	static boolean[][] checked;		// 체크여부 (필요없으면 지우기)
	static int answer;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		
		ladder = new int[N+1][H+1];
		int[] status = new int[N+1];
		buildable = new boolean[N+1][H+1];
		answer = 0;
		
		for (int i = 0; i < M; i++) {
			int h = sc.nextInt();
			int n = sc.nextInt();
			
			// 사다리 모양 입력
			ladder[n][h] = 1;
			ladder[n+1][h] = 2;
			
			// 열 별 가로선 개수 세기, 홀수면 추가 가로선 필요
			status[n]++;
		}
		
//		초기 사다리 모양 출력
//		for (int i = 1; i <= H; i++) {
//			for (int j = 1; j <=N; j++) {
//				System.out.print(ladder[j][i]);
//			}
//			System.out.println();
//		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (status[i] % 2 != 0) cnt++;
		}
		
		// 1차 거르기
		if (cnt > 3) answer = -1;
		
		if (answer != -1) {
			
			// 가로선을 놓을 수 있는 곳 체크
			for (int i = 1; i < N; i++) {
				for (int j = 1; j <= H; j++) {
					if (ladder[i+1][j] == 0) {
						buildable[i][j] = true;
					}
				}
			}
			
			comb(1, 1);
			
		}
		
		sc.close();
	}
	
	public static void comb(int col, int row) {
		if (col >= N) return;
		
		
		
	}
}
