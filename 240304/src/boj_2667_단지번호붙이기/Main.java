package boj_2667_단지번호붙이기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	static int N;
	static int[][] area;
	static List<Integer> neib;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(sc.nextLine());
		area = new int[N][N];
		neib = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			char[] input = sc.nextLine().toCharArray();
			for (int j = 0; j < N; j++) {
				area[i][j] = input[j]-'0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (area[i][j] == 1) {
					neib.add(bfs(i, j));
				}
			}
		}
		
		Collections.sort(neib);
		
		System.out.println(neib.size());
		for (int a : neib) {
			System.out.println(a);
		}
		
		sc.close();
	}
	
	private static int bfs(int i, int j) {
		int cnt = 1;
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {i, j});
		area[i][j] = 0;
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N 
						|| area[nr][nc] == 0) continue;
				
				queue.add(new int[] {nr, nc});
				area[nr][nc] = 0;
				cnt++;
			}
		}
		return cnt;
	}

}
