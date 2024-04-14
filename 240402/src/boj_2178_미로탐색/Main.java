package boj_2178_미로탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[][] maze = new int[N+2][M+2];
		
		for (int i = 1; i <= N; i++) {
			char[] tmp = sc.nextLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				maze[i][j] = tmp[j-1] - '0';
			}
		}
		
		int depth = 1;
		
		Queue<int[]> bfs = new LinkedList<>();
		boolean[][] visited = new boolean[N+2][M+2];
		
		bfs.add(new int[] {1, 1});
		visited[1][1] = true;
		int cnt = 1; 
		int answer = 0;
		
		while (!bfs.isEmpty()) {
			
			if (cnt == 0) {
				cnt = bfs.size();
				depth++;
			}
			
			for (int i = 0; i < cnt; i++) {
				int[] curr = bfs.poll();
				cnt--;
				
				if (curr[0] == N && curr[1] == M) {
					answer = depth;
					break;
				}
				
				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];
					
					if (maze[nr][nc] == 1 && !visited[nr][nc]) {
						bfs.add(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
		
		System.out.println(answer);
		sc.close();
	}
	
}
