package boj_1018_체스판다시칠하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		char[][] board = new char[N][M];
		char[][] example = new char[8][8];
		
		for (int r = 0; r < N; r++) {
			board[r] = sc.nextLine().toCharArray();
		}
		
		String a = "WBWBWBWB";
		String b = "BWBWBWBW";
		for (int r = 0; r < 8; r++) {
			if (r%2 == 0) {
				example[r] = a.toCharArray();
			} else {
				example[r] = b.toCharArray();
			}
		}
		
		int answer = Integer.MAX_VALUE;
		
		for (int r = 0; r <= N-8; r++) {
			for (int c = 0; c <= M-8; c++) {
				
				int cnt = 0;
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (board[r+i][c+j] != example[i][j]) cnt++;
					}
				}
				
				if (cnt > 32) cnt = 64 - cnt;
				if (cnt < answer) answer = cnt;
			}
		}
		
		System.out.println(answer);
		sc.close();
	}
}