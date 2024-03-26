package boj_12100_2048;

import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int H;
	static int[][] ladder;
	static boolean[][] checked;
	static int[] sel;
	static int horCnt;
	static int answer;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		
		ladder = new int[H+2][N+2];
		checked = new boolean[H+2][N+2];
		answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			ladder[r][c] = 1;
			ladder[r][c+1] = 2;
		}
		
		for (int i = 0; i <= H+1; i++) {
			for (int j = 0; j <= N+1; j++) {
				System.out.print(ladder[i][j]+" ");
			}
			System.out.println();
		}
		
		for (int i = 0; i <= 3; i++) {
			horCnt = i;
			sel = new int[i];
			colComb(1, 0);
		}
		
		System.out.println(answer);
		
		sc.close();
	}
	
	private static void colComb(int idx, int cnt) {
		
		if (cnt >= horCnt) {
			rowComb(1, 0);
			return;
		}
		
		for (int i = idx; i < N; i++) {
			sel[cnt] = idx;
			colComb(i, cnt+1);
		}
		
	}

	private static void rowComb(int idx, int cnt) {
		if (cnt >= sel.length) {
			
			for(int i = 0; i <= H+1; i++) {
				for (int j = 0; j <= N+1; j++) {
					System.out.print(ladder[i][j] + " ");
				}
				System.out.println();
			}
			
			if (isCorrect() && sel.length < answer) {
				answer = sel.length;
			}
			return;
		}
		
		if (idx > H) return;
		
		int row = sel[cnt];
		for (int i = idx; i < H; i++) {
			if (ladder[row][i] == 0 && ladder[row][i+1] == 0) {
				ladder[row][i] = 1;
				ladder[row][i+1] = 2;
				rowComb(i+1, cnt+1);
				ladder[row][i] = 0;
				ladder[row][i+1] = 0;
			}
		}
	}

	private static boolean isCorrect() {

		for (int c = 1; c <= N; c++) {
			int start = c;
			
			int row = 1;
			int col = 1;
			
			while (row <= H) {
				if (ladder[row][col] == 0) {
					row += 1;
				} else if (ladder[row][col] == 1) {
					col -= 1;
				} else {
					col += 1;
				}
			}
			
			if (col != start) return false;
		}
		
		return true;
	}

}
