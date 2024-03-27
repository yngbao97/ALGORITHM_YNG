package boj_1012_유기농배추;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int M;
	static int N;
	static int[][] area;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt();
			area = new int[N][M];
			
			for (int i = 0; i < K; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				area[x][y] = 1;
			}
			
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (area[i][j] == 1) {
						bfs(i, j);
						answer++;
					}
				}
			}
			
			System.out.println(answer);
		}
		sc.close();
	}
	
	private static void bfs(int i, int j) {
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {i, j});
		area[i][j] = 0;
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M
						|| area[nr][nc] == 0) continue;
				
				queue.add(new int[] {nr, nc});
				area[nr][nc] = 0;
			}
		}
	}
}
