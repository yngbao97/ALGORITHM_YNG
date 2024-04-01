package boj_15684_사다리조작;

import java.util.Arrays;
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
		System.out.println();
		
		
		
		
		
		if (answer == Integer.MAX_VALUE) answer = -1;

		System.out.println(answer);
		
		sc.close();
	}


	private static boolean isCorrect() {

		for (int c = 1; c <= N; c++) {
			int start = c;
			
			int row = 1;
			int col = c;
			
			while (row <= H) {
				if (ladder[row][col] == 0) {
					row++;
				} else if (ladder[row][col] == 1) {
					col++;
					row++;
				} else {
					col--;
					row++;
				}
			}
			
			if (col != start) return false;
		}
		
		return true;
	}

}
