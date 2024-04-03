package boj_20056_마법사상어와파이어볼;

import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int N;
	static int M;
	static int K;
	static int[][] map;
	static int[][] balls;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); 		// 격자 크기
		M = sc.nextInt();		// 파이어볼 개수
		K = sc.nextInt();		// 명령 횟수
		
		map = new int[N][N];	// 각 칸에 파이어볼이 몇개 있는지
		balls = new int[M][5];	// 각 파이어볼의 위치(r, c)와 질량(m), 속력(s), 방향(d)
		
		for (int i = 0; i < M; i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			int m = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			map[r][c]++;
			balls[i] = new int[] {r, c, m, s, d};
		}
		
		for (int i = 0; i < K; i++) {
			move();
			bomb();
		}
		
		sc.close();
	}
	
	private static void bomb() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 1) {
					
				}
			}
		}
		
	}

	private static void move() {
		for (int i = 0; i < M; i++) {
			int r = balls[i][0];
			int c = balls[i][1];
			int d = balls[i][4];
			int s = balls[i][3];
			balls[i][0] = (r + (dr[d] * s) + N) / N;
			balls[i][1] = (c + (dc[d] * s) + N) / N;
			
			map[r][c]--;
			map[balls[i][0]][balls[i][1]]++;
		}
	}

}
