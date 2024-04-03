/*
 * (설계+구현)48분
 * 안전거리가 가장 긴 임의의 칸을 찾는 문제다.
 * 문제를 잘못 이해했다.. 문해력 키우자,..
 * 상어에서 다른 상어까지의 거리를 구하는 문제가 아니라
 * 임의의 한 칸에서 상어를 만나기 전까지 어느 거리만큼 안전하냐는 문제였다...
 * 
 * 0인 지점을 찾아 모두 bfs 돌아서 최대 안전거리 갱신해주면 된다.
 */
package boj_17086_아기상어2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					visited = new boolean[N][M];
					bfs(i, j);
				}
			}
		}
		
		System.out.println(answer);
		sc.close();
	}
	
	private static void bfs(int r, int c) {
		int cnt = 1;
		int dist = 0;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		visited[r][c] = true;
		
		out: while(!queue.isEmpty()) {
			if (cnt == 0) {
				cnt = queue.size();
				dist++;
			}
			
			int[] curr = queue.poll();
			cnt--;

			for (int i = 0; i < 8; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
					queue.add(new int[] {nr, nc});
					visited[nr][nc] = true;
					if (map[nr][nc] == 1) break out;
				}
			}
		}
		
		answer = Math.max(answer, dist+1);
		
	}

}
