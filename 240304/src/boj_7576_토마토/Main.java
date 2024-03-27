package boj_7576_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int M;
	static int N;
	static int[][] box;
	static Queue<int[]> queue;
	static int answer;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		box = new int[N][M];
		queue = new LinkedList<>();
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
				if (box[i][j] == 1) {
					queue.add(new int[] {i, j});
					box[i][j] = -1;
				}
			}
		}
		
		if (queue.size() != N*M) {
			
			int cnt = queue.size();
			while(!queue.isEmpty()) {
				
				if (cnt == 0) {
					cnt = queue.size();
					answer++;
				}
				
				int[] curr = queue.poll();
				cnt--;
				
				for (int i = 0; i < 4; i++) {
					int nr = curr[0] + dr[i];
					int nc = curr[1] + dc[i];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= M
							|| box[nr][nc] != 0) continue;
					
					queue.add(new int[] {nr, nc});
					box[nr][nc] = -1;
					
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[i][j] != -1) {
						answer = -1;
					}
				}
			}
		}
		System.out.println(answer);
		sc.close();
	}

}
