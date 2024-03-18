package boj_15684_사다리조작;

import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int H;
	static int[][] ladder;
	static boolean[][] checked;
	static int answer;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();		// 열 개수 
		M = sc.nextInt();		// 가로선의 개수
		H = sc.nextInt();		// 행 개수
		
		ladder = new int[H+1][N+1];
		checked = new boolean[H+1][N+1];
		answer = 0;
		
		for (int i = 0; i < M; i++) {
			int h = sc.nextInt();
			int n = sc.nextInt();
			
			ladder[h][n] += 1;
			ladder[h][n+1] += 2;
			checked[h][n] = true;
			checked[h][n-1] = true;
			checked[h][n+1] = true;
		}
		
		for (int i = 1; i <= N; i++) {
			
		}
		
		
		sc.close();
	}
}
