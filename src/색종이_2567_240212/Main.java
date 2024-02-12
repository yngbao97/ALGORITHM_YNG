package 색종이_2567_240212;

import java.util.Scanner;

public class Main {

	static boolean[][] covered;
	static int answer;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		covered = new boolean[101][101];
		answer = 0;
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int r = x; r < x+10; r++) {
				for (int c = y; c < y+10; c++) {
					if (!covered[r][c]) {
						sum(r, c);
						covered[r][c] = true;
					}
				}
			}
		}
		System.out.println(answer);
		sc.close();
	}
	
	public static void sum(int x, int y) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			if (nr >= 0 && nr <= 100 && nc >= 0 && nc <= 100) {
				if (covered[nr][nc]) cnt++;
			}
		}
		answer = answer + 4 - (cnt * 2);
	}
}
