package boj_2178_미로탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	static int N;
	static int M;
	static int[][] maze;
	static boolean[][] visited;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		maze = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			char[] tmp = sc.nextLine().toCharArray();
			for (int j = 0; j < M; j++) {
				maze[i][j] = tmp[j] - '0';
			}
		}
		
		int answer = bfs();
		
		System.out.println(answer);
		sc.close();
	}
	
	private static int bfs() {
		int dist = 1;
		int size = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		size++;
		visited[0][0] = true;
		
		out: while (!queue.isEmpty()) {
			
			if (size == 0) {
				size = queue.size();
			}
			dist++;
			
			int cnt = size;
			for (int i = 0; i < cnt; i++) {
				int tmp = queue.poll();
				size--;
				
				int r = tmp / M;
				int c = tmp % M;
				
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && 
							maze[nr][nc] == 1 && !visited[nr][nc]) {
						int next = nr*M+nc;
						queue.add(next);
						visited[nr][nc] = true;
						if (next == N*M-1) break out;
					}
				}
			}
		}
		return dist;
	}
}
